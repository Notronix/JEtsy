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
import com.notronix.etsy.api.method.Method;
import com.notronix.etsy.api.model.*;
import com.notronix.etsy.impl.authentication.EtsyOAuthAccessTokenRequest;
import com.notronix.etsy.impl.authentication.EtsyOAuthTempCredentialsRequest;
import com.notronix.etsy.impl.json.*;
import com.notronix.etsy.impl.method.*;
import com.notronix.etsy.impl.model.*;

import java.io.File;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.notronix.etsy.impl.method.MethodUtils.addIfProvided;
import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.http.HttpStatus.*;

public class EtsyDataService implements EtsyAPI
{
    private final Object lock = new Object();
    private final Credentials clientCredentials;
    private HttpRequestFactory requestFactory;
    private Gson updatingGSON;
    private Gson receivingGSON;

    /**
     * Creates a new Etsy data service that can act on behalf of the registered application as identified by the supplied
     * consumerKey (or Key String) and consumerSecret (or Shared Secret).
     *
     * @param consumerKey the consumer key (or key string) that identifies the registered Etsy application.
     * @param consumerSecret the consumer secret (or shared secret) that identifies the registered Etsy application.
     * @throws NullPointerException if either of the consumerKey or consumerSecret are null.
     */
    public EtsyDataService(String consumerKey, String consumerSecret) throws NullPointerException {
        clientCredentials = Credentials.forKeyPair(requireNonNull(consumerKey), requireNonNull(consumerSecret));
    }

    @Override
    public Credentials getTemporaryCredentials(Set<String> scopes, String callback)
            throws NullPointerException, EtsyAPIException {
        requireNonNull(scopes);

        try {
            String scope = "?scope=" + join(requireNonNull(scopes), "%20");
            String url = "https://openapi.etsy.com/v2/oauth/request_token" + scope;
            EtsyOAuthTempCredentialsRequest request = new EtsyOAuthTempCredentialsRequest(url);
            request.setTransport(getRequestFactory().getTransport());
            request.setConsumerKey(requireNonNull(clientCredentials.getToken()));
            request.setCallback(isBlank(callback) ? "oob" : callback);

            OAuthHmacSigner signer = new OAuthHmacSigner();
            signer.clientSharedSecret = requireNonNull(clientCredentials.getTokenSecret());
            request.setSigner(signer);

            return request.execute();
        }
        catch (Exception ex) {
            throw new EtsyAPIException("An error occurred trying to get temporary Etsy OAuth credentials.", ex);
        }
    }

    @Override
    public Credentials getAccessCredentials(Credentials temporaryCredentials, String verifier)
            throws NullPointerException, EtsyAPIException {
        requireNonNull(temporaryCredentials);
        requireNonNull(verifier);

        try {
            String url = "https://openapi.etsy.com/v2/oauth/access_token";
            EtsyOAuthAccessTokenRequest request = new EtsyOAuthAccessTokenRequest(url);
            request.setTransport(getRequestFactory().getTransport());
            request.setConsumerKey(clientCredentials.getToken());
            request.setTemporaryToken(temporaryCredentials.getToken());
            request.setVerifier(verifier);

            OAuthHmacSigner signer = new OAuthHmacSigner();
            signer.clientSharedSecret = clientCredentials.getTokenSecret();
            signer.tokenSharedSecret = temporaryCredentials.getTokenSecret();
            request.setSigner(signer);

            return request.execute();
        }
        catch (Exception ex) {
            throw new EtsyAPIException("An error occurred trying to get Etsy OAuth access credentials.", ex);
        }
    }

    @Override
    public EtsyDataType describeOccasionEnum() throws EtsyAPIException {
        return execute(new DescribeOccasionEnumMethod(clientCredentials));
    }

    @Override
    public EtsyDataType describeRecipientEnum() throws EtsyAPIException {
        return execute(new DescribeRecipientEnumMethod(clientCredentials));
    }

    @Override
    public EtsyDataType describeWhenMadeEnum(Boolean includeFormatted)
            throws EtsyAPIException {
        return execute(new DescribeWhenMadeEnumMethod(clientCredentials).withIncludeFormatted(includeFormatted));
    }

    @Override
    public EtsyDataType describeWhoMadeEnum() throws EtsyAPIException {
        return execute(new DescribeWhoMadeEnumMethod(clientCredentials));
    }

    @Override
    public List<EtsyApiMethod> getMethodTable() throws EtsyAPIException {
        return execute(new GetMethodTableMethod(clientCredentials));
    }

    @Override
    public List<? extends Country> findAllCountry() throws EtsyAPIException {
        return execute(new FindAllCountryMethod(clientCredentials));
    }

    @Override
    public List<? extends Style> findSuggestedStyles() throws EtsyAPIException {
        return execute(new FindSuggestedStylesMethod(clientCredentials));
    }

    @Override
    public List<EtsyUser> getUser(Credentials accessCreds, List<String> userIdsOrNames, UserAssociations... associations)
            throws EtsyAPIException {
        return execute(new GetUserMethod(clientCredentials, accessCreds)
                .withUserIdsOrNames(userIdsOrNames)
                .withAssociations(associations));
    }

    @Override
    public String getAvatarImgSrc(Credentials accessCreds, String userId)
            throws EtsyAPIException {
        return execute(new GetAvatarImgSrcMethod(clientCredentials, accessCreds).withUserId(userId));
    }

    @Override
    public EtsyResponse<List<EtsyShop>> findAllShops(Credentials accessCreds,
                                                     String shopName, Integer limit, Integer offset,
                                                     Float lat, Float lon, Float distanceMax,
                                                     ShopAssociations... associations) throws EtsyAPIException {
        return execute(new FindAllShopsMethod(clientCredentials, accessCreds)
                .withAssociations(associations)
                .withShopName(shopName)
                .withLimit(limit)
                .withOffset(offset)
                .withLatitude(lat)
                .withLongitude(lon)
                .withDistanceMax(distanceMax));
    }

    @Override
    public EtsyResponse<List<EtsyShop>> findAllUserShops(Credentials accessCreds, String userId,
                                                         Integer limit, Integer offset, ShopAssociations... associations)
            throws EtsyAPIException {
        return execute(new FindAllUserShopsMethod(clientCredentials, accessCreds)
                .withUserId(userId)
                .withLimit(limit)
                .withOffset(offset)
                .withAssociations(associations));
    }

    public EtsyResponse<List<EtsyShop>> findAllUserShopsNext(Credentials accessCreds,
                                                             EtsyResponse<List<EtsyShop>> pager)
            throws EtsyAPIException {
        return execute(requireNonNull(pager).buildNextPage(new FindAllUserShopsMethod(clientCredentials, accessCreds)));
    }

    @Override
    public List<EtsyShop> getShop(Credentials accessCreds, List<String> shopIdsOrNames,
                                  ShopAssociations... associations)
            throws EtsyAPIException {
        return execute(new GetShopMethod(clientCredentials, accessCreds)
                .withShopIdsOrNames(shopIdsOrNames)
                .withAssociations(associations));
    }

    @Override
    public EtsyResponse<List<EtsyShippingTemplate>> findAllUserShippingProfiles(Credentials accessCreds,
                                                                                String userId,
                                                                                Integer limit,
                                                                                Integer offset,
                                                                                Integer page)
            throws EtsyAPIException {
        return execute(new FindAllUserShippingProfilesMethod(clientCredentials, accessCreds)
                .withUserId(userId)
                .withLimit(limit)
                .withOffset(offset)
                .withPage(page));
    }

    @Override
    public List<EtsyTaxonomy> getSellerTaxonomy() throws EtsyAPIException {
        return execute(new GetSellerTaxonomyMethod(clientCredentials));
    }

    @Override
    public List<EtsyTaxonomyNodeProperty> getTaxonomyNodeProperties(Long taxonomyId)
            throws EtsyAPIException {
        return execute(new GetTaxonomyNodePropertiesMethod(clientCredentials).withTaxonomyId(taxonomyId));
    }

    @Override
    public List<EtsyListing> getListing(Credentials accessCreds, List<Long> listingIds,
                                        ListingAssociations... associations) throws EtsyAPIException {
        return execute(new GetListingMethod(clientCredentials, accessCreds)
                .withListingIds(requireNonNull(listingIds))
                .withAssociations(associations));
    }

    @Override
    public EtsyListingInventory getInventory(Credentials accessCreds, Long listingId,
                                             Boolean writeMissingInventory) throws EtsyAPIException {
        return execute(new GetInventoryMethod(clientCredentials, accessCreds)
                .withListingId(requireNonNull(listingId))
                .withWriteMissingInventory(writeMissingInventory));
    }

    @Override
    public EtsyListingInventory updateInventory(Credentials accessCreds, Long listingId,
                                                ListingInventory inventory) throws EtsyAPIException {
        return execute(new UpdateInventoryMethod(clientCredentials, accessCreds)
                .withListingId(listingId)
                .withInventory(inventory));
    }

    @Override
    public EtsyListing createListing(Credentials accessCreds, Integer quantity, String title,
                                     String description, Float price, List<String> materials, Long shippingTemplateId,
                                     Long shopSectionId, List<Long> imageIds, Boolean isCustomizable, Boolean nonTaxable,
                                     ListingState state, Integer processingMin, Integer processingMax, Long categoryId,
                                     Long taxonomyId, List<String> tags, String whoMade, Boolean isSupply, String whenMade,
                                     String recipient, String occasion, List<String> style) throws EtsyAPIException {
        return execute(new CreateListingMethod(clientCredentials, accessCreds)
                .withQuantity(quantity).withTitle(title).withDescription(description).withPrice(price)
                .withMaterials(materials).withShippingTemplateId(shippingTemplateId).withShopSectionId(shopSectionId)
                .withImageIds(imageIds).withIsCustomizable(isCustomizable).withNonTaxable(nonTaxable).withState(state)
                .withProcessingMin(processingMin).withProcessingMax(processingMax).withCategoryId(categoryId)
                .withTaxonomyId(taxonomyId).withTags(tags).withWhoMade(whoMade).withIsSupply(isSupply).withWhenMade(whenMade)
                .withRecipient(recipient).withOccasion(occasion).withStyle(style));
    }

    @Override
    public EtsyListing updateListing(Credentials accessCreds, Long listingId, String title,
                                     String description, List<String> materials, Boolean renew, Long shippingTemplateId,
                                     Long shopSectionId, ListingState state, List<Long> imageIds, Boolean isCustomizable,
                                     Float itemWeight, Float itemLength, Float itemWidth, Float itemHeight,
                                     WeightUnit weightUnit, DimensionUnit dimensionUnit, Boolean nonTaxable, Long categoryId,
                                     Long taxonomyId, List<String> tags, String whoMade, Boolean isSupply, String whenMade,
                                     String recipient, String occasion, List<String> style, Integer processingMin,
                                     Integer processingMax, String featuredRank) throws EtsyAPIException {
        return execute(new UpdateListingMethod(clientCredentials, accessCreds)
                .withListingId(listingId).withTitle(title).withDescription(description).withMaterials(materials)
                .withRenew(renew).withShippingTemplateId(shippingTemplateId).withShopSectionId(shopSectionId)
                .withState(state).withImageIds(imageIds).withIsCustomizable(isCustomizable).withItemWeight(itemWeight)
                .withItemLength(itemLength).withItemWidth(itemWidth).withItemHeight(itemHeight).withWeightUnit(weightUnit)
                .withDimensionUnit(dimensionUnit).withNonTaxable(nonTaxable).withCategoryId(categoryId)
                .withTaxonomyId(taxonomyId).withTags(tags).withWhoMade(whoMade).withIsSupply(isSupply).withWhenMade(whenMade)
                .withRecipient(recipient).withOccasion(occasion).withStyle(style).withProcessingMin(processingMin)
                .withProcessingMax(processingMax).withFeaturedRank(featuredRank));
    }

    @Override
    public EtsyResponse<List<EtsyListing>> findAllActiveListings(Credentials accessCreds, Integer limit, Integer offset)
            throws EtsyAPIException {
        return execute(new FindAllListingActiveMethod(clientCredentials, accessCreds)
                .withLimit(limit)
                .withOffset(offset));
    }

    @Override
    public EtsyListingImage uploadListingImage(Credentials accessCreds, Long listingId,
                                               File image, Integer rank, Boolean overwrite, Boolean isWaterMarked)
            throws EtsyAPIException {
        return execute(new UploadListingImageMethod(clientCredentials, accessCreds)
                .withListingId(listingId)
                .withImage(image)
                .withRank(rank)
                .withOverwrite(overwrite)
                .withIsWaterMarked(isWaterMarked));
    }

    @Override
    public List<EtsyListingVariationImage> getVariationImages(Credentials accessCreds, Long listingId)
            throws EtsyAPIException {
        return execute(new GetVariationImagesMethod(clientCredentials, accessCreds).withListingId(listingId));
    }

    @Override
    public List<EtsyListingVariationImage> updateVariationImages(Credentials accessCreds,
                                                                 Long listingId,
                                                                 List<? extends ListingVariationImage> variationImages)
            throws EtsyAPIException {
        return execute(new UpdateVariationImagesMethod(clientCredentials, accessCreds)
                .withListingId(listingId)
                .withVariationImages(variationImages));
    }

    @Override
    public EtsyCart createSingleListingCart(Credentials accessCreds, String userId, Long listingId,
                                            Integer quantity, CartAssociations... associations)
            throws EtsyAPIException {
        return execute(new CreateSingleListingCartMethod(clientCredentials, accessCreds)
                .withUserId(userId)
                .withListingId(listingId)
                .withQuantity(quantity));
    }

    @Override
    public EtsyResponse<List<EtsyCart>> getAllUserCarts(Credentials accessCreds, String userId,
                                                        CartAssociations... associations) throws EtsyAPIException {
        return execute(new GetAllUserCartsMethod(clientCredentials, accessCreds)
                .withUserId(userId)
                .withAssociations(associations));
    }

    @Override
    public Cart getUserCart(Credentials accessCreds, String userId, Long cartId)
            throws EtsyAPIException {
        return execute(new GetUserCartMethod(clientCredentials, accessCreds)
                .withUserId(userId)
                .withCartId(cartId));
    }

    @Override
    public EtsyCart addToCart(Credentials accessCreds, String userId, Long listingId,
                              Integer quantity) throws EtsyAPIException {
        return execute(new AddToCartMethod(clientCredentials, accessCreds)
                .withUserId(userId)
                .withListingId(listingId));
    }

    @Override
    public List<EtsyCoupon> findAllShopCoupons(Credentials accessCreds, String shopIdOrName)
            throws EtsyAPIException {
        return execute(new FindAllShopCouponsMethod(clientCredentials, accessCreds).withShopIdOrName(shopIdOrName));
    }

    @Override
    public EtsyResponse<List<EtsyReceipt>> findAllShopReceipts(Credentials accessCreds,
                                                               String shopIdOrName, ReceiptAssociations... associations)
            throws EtsyAPIException {
        return execute(new FindAllShopReceiptsMethod(clientCredentials, accessCreds).withShopIdOrName(shopIdOrName));
    }

    public EtsyResponse<List<EtsyReceipt>> findAllShopReceiptsNext(Credentials accessCreds,
                                                                   EtsyResponse<List<EtsyReceipt>> pager)
            throws EtsyAPIException {
        return execute(requireNonNull(pager)
                .buildNextPage(new FindAllShopReceiptsMethod(clientCredentials, accessCreds)));
    }

    @Override
    public EtsyResponse<List<EtsyReceipt>> submitTracking(Credentials accessCreds, Long shopId,
                                                          Long receiptId, String trackingCode, String carrierName,
                                                          Boolean sendBcc) throws EtsyAPIException {
        return execute(new SubmitTrackingMethod(clientCredentials, accessCreds)
                .withShopId(shopId).withReceiptId(receiptId)
                .withTrackingCode(trackingCode).withCarrierName(carrierName).withSendBcc(sendBcc));
    }

    private <T> T execute(Method<T> method) throws EtsyAPIException {
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

    private HttpRequest configureRequest(Method<?> method)
            throws EtsyAPIException {
        Credentials clientCreds = requireNonNull(method.getClientCredentials());
        Credentials accessCreds = (method.requiresOAuth()
                ? requireNonNull(method.getAccessCredentials()) : method.getAccessCredentials());

        HttpRequest request;
        String httpMethod = method.getRequestMethod();
        HttpContent content = method.getContent(getUpdatingGSON());

        String baseUrl = method.getURL();
        baseUrl = addIfProvided(baseUrl, "api_key", nonNull(accessCreds) ? null : clientCreds.getToken());
        GenericUrl url = new GenericUrl(baseUrl);

        try {
            request = getRequestFactory().buildRequest(httpMethod, url, content);
        }
        catch (Exception ex) {
            throw new EtsyAPIException("An error occurred trying to build request.", ex);
        }

        if (nonNull(accessCreds)) {
            OAuthHmacSigner signer = new OAuthHmacSigner();
            signer.clientSharedSecret = clientCreds.getTokenSecret();
            signer.tokenSharedSecret = accessCreds.getTokenSecret();

            OAuthParameters parameters = new OAuthParameters();
            parameters.consumerKey = clientCreds.getToken();
            parameters.signer = signer;
            parameters.token = accessCreds.getToken();

            Map<String, Object> urlEncodedParams = null;

            if (content instanceof UrlEncodedContent) {
                urlEncodedParams = Data.mapOf(((UrlEncodedContent) content).getData());
                url.putAll(urlEncodedParams);
            }

            try {
                parameters.intercept(request);
                ofNullable(urlEncodedParams)
                        .ifPresent(contentParams -> contentParams.forEach((key, value) -> url.remove(key)));
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

            requestFactory = new NetHttpTransport.Builder().build().createRequestFactory();
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
                    .registerTypeAdapter(EtsyRelatedLinks.class, new EtsyRelatedLinksAdapter())
                    .registerTypeAdapter(Boolean.class, new EtsyBooleanAdapter())
                    .registerTypeAdapter(EtsyMoney.class, new EtsyMoneyAdapter())
                    .registerTypeAdapter(ListingState.class, new ListingStateAdapter().nullSafe())
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
                    .registerTypeAdapter(EtsyRelatedLinks.class, new EtsyRelatedLinksAdapter())
                    .registerTypeAdapter(Boolean.class, new EtsyBooleanAdapter())
                    .registerTypeAdapter(Instant.class, new InstantAdapter().nullSafe())
                    .registerTypeAdapter(ListingState.class, new ListingStateAdapter().nullSafe())
                    .create();
        }

        return receivingGSON;
    }
}
