package com.notronix.etsy.impl;

import com.google.api.client.auth.oauth.OAuthHmacSigner;
import com.google.api.client.auth.oauth.OAuthParameters;
import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.Data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.notronix.etsy.api.EtsyAPI;
import com.notronix.etsy.api.EtsyAPIException;
import com.notronix.etsy.api.authentication.Credentials;
import com.notronix.etsy.api.model.*;
import com.notronix.etsy.impl.authentication.EtsyOAuthAccessTokenRequest;
import com.notronix.etsy.impl.authentication.EtsyOAuthTempCredentialsRequest;
import com.notronix.etsy.impl.json.EtsyBooleanAdapter;
import com.notronix.etsy.impl.json.EtsyMoneyAdapter;
import com.notronix.etsy.impl.json.EtsyPaymentInfoAdapter;
import com.notronix.etsy.impl.method.*;
import com.notronix.etsy.impl.model.*;

import java.io.File;
import java.util.List;
import java.util.Set;

import static java.util.Objects.requireNonNull;
import static jdk.nashorn.internal.objects.NativeArray.join;
import static org.apache.http.HttpStatus.*;

public class EtsyDataService implements EtsyAPI
{
    private final Object lock = new Object();
    private HttpRequestFactory requestFactory;
    private Gson updatingGSON;
    private Gson receivingGSON;

    @Override
    public Credentials getTemporaryCredentials(Credentials clientCreds, String callback, Set<String> scopes)
            throws EtsyAPIException {
        try {
            String scope = "?scope=" + join(requireNonNull(scopes), "%20");
            String url = "https://openapi.etsy.com/v2/oauth/request_token" + scope;
            EtsyOAuthTempCredentialsRequest request = new EtsyOAuthTempCredentialsRequest(url);
            request.setTransport(getRequestFactory().getTransport());
            request.setConsumerKey(requireNonNull(clientCreds.getToken()));
            request.setCallback(callback);

            OAuthHmacSigner signer = new OAuthHmacSigner();
            signer.clientSharedSecret = requireNonNull(clientCreds.getTokenSecret());
            request.setSigner(signer);

            return request.execute();
        }
        catch (Exception ex) {
            throw new EtsyAPIException("An error occurred trying to get temporary Etsy OAuth credentials.", ex);
        }
    }

    @Override
    public Credentials getAccessCredentials(Credentials clientCreds, Credentials temporaryCredentials, String verifier)
            throws EtsyAPIException {
        try {
            String url = "https://openapi.etsy.com/v2/oauth/access_token";
            EtsyOAuthAccessTokenRequest request = new EtsyOAuthAccessTokenRequest(url);
            request.setTransport(getRequestFactory().getTransport());
            request.setConsumerKey(clientCreds.getToken());
            request.setTemporaryToken(temporaryCredentials.getToken());
            request.setVerifier(verifier);

            OAuthHmacSigner signer = new OAuthHmacSigner();
            signer.clientSharedSecret = clientCreds.getTokenSecret();
            signer.tokenSharedSecret = temporaryCredentials.getTokenSecret();
            request.setSigner(signer);

            return request.execute();
        }
        catch (Exception ex) {
            throw new EtsyAPIException("An error occurred trying to get Etsy OAuth access credentials.", ex);
        }
    }

    @Override
    public EtsyDataType describeOccasionEnum(Credentials clientCreds) throws EtsyAPIException {
        return execute(new DescribeOccasionEnumMethod().withClientCredentials(clientCreds));
    }

    @Override
    public EtsyDataType describeRecipientEnum(Credentials clientCreds) throws EtsyAPIException {
        return execute(new DescribeRecipientEnumMethod().withClientCredentials(clientCreds));
    }

    @Override
    public EtsyDataType describeWhenMadeEnum(Credentials clientCreds) throws EtsyAPIException {
        return execute(new DescribeWhenMadeEnumMethod().withClientCredentials(clientCreds));
    }

    @Override
    public EtsyDataType describeWhoMadeEnum(Credentials clientCreds) throws EtsyAPIException {
        return execute(new DescribeWhoMadeEnumMethod().withClientCredentials(clientCreds));
    }

    @Override
    public List<EtsyApiMethod> getMethodTable(Credentials clientCreds) throws EtsyAPIException {
        return execute(new GetMethodTableMethod().withClientCredentials(clientCreds));
    }

    @Override
    public List<? extends Country> findAllCountry(Credentials clientCreds) throws EtsyAPIException {
        return execute(new FindAllCountryMethod().withClientCredentials(clientCreds));
    }

    @Override
    public List<? extends Style> findSuggestedStyles(Credentials clientCreds) throws EtsyAPIException {
        return execute(new FindSuggestedStylesMethod().withClientCredentials(clientCreds));
    }

    @Override
    public EtsyUser getUser(Credentials clientCreds, Credentials accessCreds, String userId, UserAssociations... associations)
            throws EtsyAPIException {
        return execute(new GetUserMethod()
                               .withUserId(userId)
                               .withAssociations(associations)
                               .withClientCredentials(clientCreds)
                               .withAccessCredentials(accessCreds));
    }

    @Override
    public String getAvatarImgSrc(Credentials clientCreds, Credentials accessCreds, String userId)
            throws EtsyAPIException {
        return execute(new GetAvatarImgSrcMethod()
                .withUserId(userId)
                .withClientCredentials(clientCreds)
                .withAccessCredentials(accessCreds));
    }

    @Override
    public EtsyResponse<List<EtsyShippingTemplate>> findAllShippingTemplates(Credentials clientCreds, Credentials accessCreds)
            throws EtsyAPIException {
        return execute(new GetShippingTemplatesMethod().withClientCredentials(clientCreds).withAccessCredentials(accessCreds));
    }

    @Override
    public List<EtsyTaxonomy> getSellerTaxonomy(Credentials clientCreds) throws EtsyAPIException {
        return execute(new GetSellerTaxonomyMethod().withClientCredentials(clientCreds));
    }

    @Override
    public List<EtsyTaxonomyNodeProperty> getTaxonomyNodeProperties(Credentials clientCreds, Long taxonomyId)
            throws EtsyAPIException {
        return execute(new GetTaxonomyNodePropertiesMethod().withTaxonomyId(taxonomyId).withClientCredentials(clientCreds));
    }

    @Override
    public EtsyListing getListing(Credentials clientCreds, Credentials accessCreds, Long listingId,
                                  ListingAssociations... associations) throws EtsyAPIException {
        return execute(new GetListingMethod()
                               .withListingId(requireNonNull(listingId))
                               .withAssociations(associations)
                               .withClientCredentials(clientCreds)
                               .withAccessCredentials(accessCreds));
    }

    @Override
    public EtsyListingInventory getInventory(Credentials clientCreds, Credentials accessCreds, Long listingId,
                                             Boolean writeMissingInventory) throws EtsyAPIException {
        return execute(new GetInventoryMethod()
                               .withListingId(requireNonNull(listingId))
                               .withWriteMissingInventory(writeMissingInventory)
                               .withClientCredentials(clientCreds)
                               .withAccessCredentials(accessCreds));
    }

    @Override
    public EtsyListingInventory updateInventory(Credentials clientCreds, Credentials accessCreds, Long listingId,
                                                ListingInventory inventory) throws EtsyAPIException {
        return execute(new UpdateInventoryMethod()
                               .withListingId(listingId)
                               .withInventory(inventory)
                               .withClientCredentials(clientCreds)
                               .withAccessCredentials(accessCreds));
    }

    @Override
    public EtsyListing createListing(Credentials clientCreds, Credentials accessCreds, Listing listing) throws EtsyAPIException {
        return execute(new CreateListingMethod()
                               .withListing(requireNonNull(listing))
                               .withClientCredentials(clientCreds)
                               .withAccessCredentials(accessCreds));
    }

    @Override
    public EtsyResponse<EtsyListing> findAllActiveListings(Credentials clientCreds, Credentials accessCreds, Integer limit, Integer offset)
            throws EtsyAPIException {
        return execute(new FindAllListingActiveMethod()
                               .withLimit(limit)
                               .withOffset(offset)
                               .withClientCredentials(clientCreds)
                               .withAccessCredentials(accessCreds));
    }

    @Override
    public EtsyListingImage uploadListingImage(Credentials clientCreds, Credentials accessCreds, Long listingId, File image)
            throws EtsyAPIException {
        return execute(new UploadListingImageMethod()
                               .withListingId(listingId)
                               .withImage(image)
                               .withClientCredentials(clientCreds)
                               .withAccessCredentials(accessCreds));
    }

    private <T> T execute(EtsyMethod<T> method) throws EtsyAPIException {
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
                throw new EtsyAPIException("Etsy API call failed" + ". Code: " + statusCode + ", Reason: " + reason
                                                       + ", Details: " + payload);
            }

            return method.getResponse(getReceivingGSON(), payload);
        }
        catch (Exception ex) {
            throw new EtsyAPIException("Etsy request failed.", ex);
        }
    }

    private HttpRequest configureRequest(EtsyMethod method)
            throws EtsyAPIException {
        Credentials clientCreds = requireNonNull(method.getClientCredentials());
        Credentials accessCreds = (method.requiresOAuth()
                ? requireNonNull(method.getAccessCredentials()) : method.getAccessCredentials());

        String httpMethod = method.getRequestMethod();
        HttpContent content = method.getContent(getUpdatingGSON());
        GenericUrl url = new GenericUrl(method.getURL(clientCreds.getToken()));
        HttpRequest request;

        try {
            request = getRequestFactory().buildRequest(httpMethod, url, content);
        }
        catch (Exception ex) {
            throw new EtsyAPIException("An error occurred trying to build request.", ex);
        }

        if (accessCreds != null) {
            OAuthHmacSigner signer = new OAuthHmacSigner();
            signer.clientSharedSecret = clientCreds.getTokenSecret();
            signer.tokenSharedSecret = accessCreds.getTokenSecret();

            OAuthParameters parameters = new OAuthParameters();
            parameters.consumerKey = clientCreds.getToken();
            parameters.signer = signer;
            parameters.token = accessCreds.getToken();

            if (content instanceof UrlEncodedContent) {
                url.putAll(Data.mapOf(((UrlEncodedContent) content).getData()));
            }

            try {
                parameters.intercept(request);
            }
            catch (Exception e) {
                EtsyAPIException eae = new EtsyAPIException("An error occurred computing method signature", e);
                eae.initCause(e);
                throw eae;
            }
        }

        return request;
    }

    private boolean requestFailed(int statusCode) {
        return statusCode != SC_OK && statusCode != SC_CREATED && statusCode != SC_ACCEPTED && statusCode != SC_NO_CONTENT;
    }

    private HttpRequestFactory getRequestFactory() {
        if (requestFactory != null) {
            return requestFactory;
        }

        synchronized (lock) {
            if (requestFactory != null) {
                return requestFactory;
            }

            requestFactory = new NetHttpTransport().createRequestFactory();
        }

        return requestFactory;
    }

    private Gson getUpdatingGSON() {
        if (updatingGSON != null) {
            return updatingGSON;
        }

        synchronized (lock) {
            if (updatingGSON != null) {
                return updatingGSON;
            }

            updatingGSON = new GsonBuilder().setVersion(0)
                    .registerTypeAdapter(EtsyPaymentInfo.class, new EtsyPaymentInfoAdapter())
                    .registerTypeAdapter(Boolean.class, new EtsyBooleanAdapter())
                    .registerTypeAdapter(EtsyMoney.class, new EtsyMoneyAdapter())
                    .create();
        }

        return updatingGSON;
    }

    private Gson getReceivingGSON() {
        if (receivingGSON != null) {
            return receivingGSON;
        }

        synchronized (lock) {
            if (receivingGSON != null) {
                return receivingGSON;
            }

            receivingGSON = new GsonBuilder()
                    .registerTypeAdapter(EtsyPaymentInfo.class, new EtsyPaymentInfoAdapter())
                    .registerTypeAdapter(Boolean.class, new EtsyBooleanAdapter())
                    .create();
        }

        return receivingGSON;
    }
}
