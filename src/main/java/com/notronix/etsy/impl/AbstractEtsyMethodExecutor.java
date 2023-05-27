package com.notronix.etsy.impl;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.*;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;
import static org.apache.http.HttpStatus.*;

public abstract class AbstractEtsyMethodExecutor implements MethodExecutor<HttpContent>
{
    protected abstract GenericUrl conditionUrl(String baseUrl, Credentials clientCreds, Credentials accessCreds);
    protected abstract HttpRequest buildRequest(String method, GenericUrl url, HttpContent content,
                                                Credentials clientCreds) throws EtsyException;
    protected abstract void handleAccess(HttpRequest request, HttpContent content, GenericUrl url,
                                         Credentials clientCreds, Credentials accessCreds) throws EtsyException;

    private final Object lock = new Object();
    private HttpRequestFactory requestFactory;

    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;

    public AbstractEtsyMethodExecutor(Marshaller marshaller, Unmarshaller unmarshaller) {
        this.marshaller = marshaller;
        this.unmarshaller = unmarshaller;
    }

    public Marshaller getMarshaller() {
        return marshaller;
    }

    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }

    protected boolean requestFailed(int statusCode) {
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

    public <Response> Response execute(Method<Response, HttpContent> method) throws EtsyException {
        HttpRequest request = configureRequest(method);
        try {
            int statusCode;
            String reason;
            String payload;

            HttpResponse response = request.execute();

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

            return method.getResponse(getUnmarshaller(), payload);
        }
        catch (Exception ex) {
            String reason = null;

            if (ex instanceof HttpResponseException) {
                Map<String, String> content =
                        getUnmarshaller().unmarshal(((HttpResponseException) ex).getContent(),
                                new TypeToken<HashMap<String, String>>()
                                {
                                }.getType());
                String error = content.get("error");
                reason = content.get("error_description");
            }

            throw new EtsyException("Etsy request failed.", ex).dueToExpiredToken(equalsIgnoreCase(reason, "access token is expired"));
        }
    }

    private <Response> HttpRequest configureRequest(Method<Response, HttpContent> method)
            throws EtsyException {
        Credentials clientCreds = requireNonNull(method.getClientCredentials());
        Credentials accessCreds = (method.requiresOAuth()
                ? requireNonNull(method.getAccessCredentials()) : method.getAccessCredentials());

        String httpMethod = method.getRequestMethod();

        try {
            HttpContent content = method.getContent(getMarshaller());

            GenericUrl url = conditionUrl(method.getURL(), clientCreds, accessCreds);
            HttpRequest request = buildRequest(httpMethod, url, content, clientCreds);

            if (nonNull(accessCreds)) {
                handleAccess(request, content, url, clientCreds, accessCreds);
            }

            return request;
        }
        catch (Exception ex) {
            throw ex instanceof EtsyException ? (EtsyException) ex
                    : new EtsyException("An error occurred configuring request.", ex);
        }
    }
}
