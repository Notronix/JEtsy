package com.notronix.etsy.impl;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.*;
import com.notronix.etsy.api.common.method.Method;
import com.notronix.etsy.api.common.method.OAuthMethod;
import com.notronix.etsy.impl.authentication.method.EtsyAuthResource;
import com.notronix.etsy.impl.common.json.InstantAdapter;
import com.notronix.etsy.impl.listings.method.EtsyListingResource;
import com.notronix.etsy.impl.shops.method.EtsyShopResource;
import com.notronix.etsy.impl.taxonomy.method.EtsyTaxonomyResource;
import com.notronix.etsy.impl.users.method.EtsyUserResource;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.Objects.requireNonNull;
import static org.apache.http.HttpStatus.*;

public class EtsyAPI implements API<HttpContent>
{
    private final Object lock = new Object();
    private static final EtsyAPI DEFAULT_INSTANCE = createDefaultInstance();
    private HttpRequestFactory requestFactory;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    private EtsyAuthResource authResource;
    private EtsyUserResource userResource;
    private EtsyListingResource listingResource;
    private EtsyShopResource shopResource;
    private EtsyTaxonomyResource taxonomyResource;

    public Marshaller getMarshaller() {
        return marshaller;
    }

    @Override
    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }

    @Override
    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    @Override
    public EtsyAuthResource getAuthResource() {
        return authResource;
    }

    public void setAuthResource(EtsyAuthResource authResource) {
        this.authResource = authResource;
    }

    @Override
    public EtsyUserResource getUserResource() {
        return userResource;
    }

    public void setUserResource(EtsyUserResource userResource) {
        this.userResource = userResource;
    }

    @Override
    public EtsyListingResource getListingResource() {
        return listingResource;
    }

    public void setListingResource(EtsyListingResource listingResource) {
        this.listingResource = listingResource;
    }

    @Override
    public EtsyShopResource getShopResource() {
        return shopResource;
    }

    public void setShopResource(EtsyShopResource shopResource) {
        this.shopResource = shopResource;
    }

    @Override
    public EtsyTaxonomyResource getTaxonomyResource() {
        return taxonomyResource;
    }

    public void setTaxonomyResource(EtsyTaxonomyResource taxonomyResource) {
        this.taxonomyResource = taxonomyResource;
    }

    protected static boolean requestFailed(int statusCode) {
        return statusCode != SC_OK && statusCode != SC_CREATED && statusCode != SC_ACCEPTED && statusCode != SC_NO_CONTENT;
    }

    public HttpRequestFactory getRequestFactory() {
        if (requestFactory != null) {
            return requestFactory;
        }

        synchronized (lock) {
            if (requestFactory != null) {
                return requestFactory;
            }

            requestFactory = new NetHttpTransport.Builder().build().createRequestFactory();
        }

        return requestFactory;
    }

    @Override
    public <T> Response<T> execute(AppKey appKey, Method<T, HttpContent> method) throws EtsyException {
        try {
            GenericUrl url = new GenericUrl(method.getURL());
            HttpContent requestContent = method.buildRequestContent(getMarshaller());

            HttpRequest request = getRequestFactory().buildRequest(method.getRequestMethod(), url, requestContent);
            request.getHeaders().set("x-api-key", requireNonNull(appKey.getValue()));

            if (method instanceof OAuthMethod) {
                String accessToken = requireNonNull(((OAuthMethod) method).getAccessToken().getValue());
                request.getHeaders().setAuthorization(Collections.singletonList("Bearer " + accessToken));
            }

            int statusCode;
            String reason;
            String payload;

            final HttpResponse response = request.execute();

            try {
                response.setContentLoggingLimit(0);
                statusCode = response.getStatusCode();
                reason = response.getStatusMessage();
                payload = response.parseAsString();
            }
            finally {
                response.disconnect();
            }

            if (requestFailed(statusCode)) {
                throw new EtsyException("Etsy API call failed" + ". Code: " + statusCode + ", Reason: " + reason
                        + ", Details: " + payload);
            }

            T responseContent = method.buildResponseBody(getUnmarshaller(), payload);
            HttpHeaders headers = response.getHeaders();

            return new Response<T>()
            {
                @Override
                public String getRequestUUID() {
                    return getHeaderValue(headers,
                            httpHeaders -> httpHeaders.getFirstHeaderStringValue(REQUEST_UUID) == null ? null
                                    : httpHeaders.getFirstHeaderStringValue(REQUEST_UUID));
                }

                @Override
                public Integer getLimitPerSecond() {
                    return getHeaderValue(headers,
                            httpHeaders -> httpHeaders.getFirstHeaderStringValue(LIMIT_PER_SECOND) == null ? null
                                    : Integer.parseInt(httpHeaders.getFirstHeaderStringValue(LIMIT_PER_SECOND)));
                }

                @Override
                public Integer getLimitPerDay() {
                    return getHeaderValue(headers,
                            httpHeaders -> httpHeaders.getFirstHeaderStringValue(LIMIT_PER_DAY) == null ? null
                                    : Integer.parseInt(httpHeaders.getFirstHeaderStringValue(LIMIT_PER_DAY)));
                }

                @Override
                public Integer getCallsRemainingThisDay() {
                    return getHeaderValue(headers,
                            httpHeaders -> httpHeaders.getFirstHeaderStringValue(REMAINING_THIS_DAY) == null ? null
                                    : Integer.parseInt(httpHeaders.getFirstHeaderStringValue(REMAINING_THIS_DAY)));
                }

                @Override
                public Integer getCallsRemainingThisSecond() {
                    return getHeaderValue(headers,
                            httpHeaders -> httpHeaders.getFirstHeaderStringValue(REMAINING_THIS_SECOND) == null ? null
                                    : Integer.parseInt(httpHeaders.getFirstHeaderStringValue(REMAINING_THIS_SECOND)));
                }

                @Override
                public T getContent() {
                    return responseContent;
                }
            };
        }
        catch (Exception ex) {
            String error = null;
            String description = null;

            if (ex instanceof HttpResponseException) {
                Map<String, String> content =
                        getUnmarshaller().unmarshal(((HttpResponseException) ex).getContent(),
                                new TypeToken<HashMap<String, String>>(){}.getType());
                error = content.get("error");
                description = content.get("error_description");
            }

            throw new EtsyException("Etsy request failed.", ex)
                    .withError(error).withErrorDescription(description);
        }
    }

    private <T> T getHeaderValue(HttpHeaders headers, Function<HttpHeaders, T> function) {
        return headers == null ? null : function.apply(headers);
    }

    public static EtsyAPI getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static EtsyAPI createDefaultInstance() {
        Marshaller marshaller = createDefaultMarshaller();
        Unmarshaller unmarshaller = createDefaultUnMarshaller();

        EtsyAPI etsyAPI = new EtsyAPI();
        etsyAPI.setMarshaller(marshaller);
        etsyAPI.setUnmarshaller(unmarshaller);
        etsyAPI.setAuthResource(new EtsyAuthResource());
        etsyAPI.setListingResource(new EtsyListingResource());
        etsyAPI.setShopResource(new EtsyShopResource());
        etsyAPI.setUserResource(new EtsyUserResource());
        etsyAPI.setTaxonomyResource(new EtsyTaxonomyResource());

        return etsyAPI;
    }

    private static Marshaller createDefaultMarshaller() {
        return new Marshaller()
        {
            private final Gson gson = new GsonBuilder().setVersion(0).create();

            @Override
            public String marshal(Object object) {
                return gson.toJson(object);
            }
        };
    }

    private static Unmarshaller createDefaultUnMarshaller() {
        return new Unmarshaller()
        {
            private final Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Instant.class, new InstantAdapter().nullSafe())
                    .create();

            @Override
            public <T> T unmarshal(String payload, Class<T> classOfT) {
                return gson.fromJson(payload, classOfT);
            }

            @Override
            public <T> T unmarshal(String payload, Type typeOfT) {
                return gson.fromJson(payload, typeOfT);
            }
        };
    }

    private static void getTime() {
        try {
            String time = "Sat, 10 Jun 2023 11:36:46 GMT";
            Instant date = ZonedDateTime.parse(time, DateTimeFormatter.RFC_1123_DATE_TIME).toInstant();

            System.exit(0);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
