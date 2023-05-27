package com.notronix.etsy.impl.v2;

import com.google.api.client.auth.oauth.OAuthHmacSigner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.v2.EtsyAPI;
import com.notronix.etsy.api.v2.method.PageableResponse;
import com.notronix.etsy.api.v2.model.authentication.EtsyScope;
import com.notronix.etsy.api.v2.model.carts.Cart;
import com.notronix.etsy.api.v2.model.carts.CartAssociations;
import com.notronix.etsy.api.v2.model.countries.Country;
import com.notronix.etsy.api.v2.model.listings.*;
import com.notronix.etsy.api.v2.model.shops.ReceiptAssociations;
import com.notronix.etsy.api.v2.model.shops.ShopAssociations;
import com.notronix.etsy.api.v2.model.taxonomy.Style;
import com.notronix.etsy.api.v2.model.users.User;
import com.notronix.etsy.api.v2.model.users.UserAssociations;
import com.notronix.etsy.impl.v2.json.*;
import com.notronix.etsy.impl.v2.method.EtsyPageableResponse;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.method.authentication.EtsyOAuthAccessTokenRequest;
import com.notronix.etsy.impl.v2.method.authentication.EtsyOAuthTempCredentialsRequest;
import com.notronix.etsy.impl.v2.method.baseline.GetMethodTableMethod;
import com.notronix.etsy.impl.v2.method.carts.AddToCartMethod;
import com.notronix.etsy.impl.v2.method.carts.CreateSingleListingCartMethod;
import com.notronix.etsy.impl.v2.method.carts.GetAllUserCartsMethod;
import com.notronix.etsy.impl.v2.method.carts.GetUserCartMethod;
import com.notronix.etsy.impl.v2.method.countries.FindAllCountryMethod;
import com.notronix.etsy.impl.v2.method.listings.*;
import com.notronix.etsy.impl.v2.method.shops.*;
import com.notronix.etsy.impl.v2.method.taxonomy.FindSuggestedStylesMethod;
import com.notronix.etsy.impl.v2.method.taxonomy.GetSellerTaxonomyMethod;
import com.notronix.etsy.impl.v2.method.taxonomy.GetTaxonomyNodePropertiesMethod;
import com.notronix.etsy.impl.v2.method.types.DescribeOccasionEnumMethod;
import com.notronix.etsy.impl.v2.method.types.DescribeRecipientEnumMethod;
import com.notronix.etsy.impl.v2.method.types.DescribeWhenMadeEnumMethod;
import com.notronix.etsy.impl.v2.method.types.DescribeWhoMadeEnumMethod;
import com.notronix.etsy.impl.v2.method.users.FindAllUserShippingProfilesMethod;
import com.notronix.etsy.impl.v2.method.users.FindAllUsersMethod;
import com.notronix.etsy.impl.v2.method.users.GetAvatarImgSrcMethod;
import com.notronix.etsy.impl.v2.method.users.GetUserMethod;
import com.notronix.etsy.impl.v2.model.baseline.EtsyApiMethod;
import com.notronix.etsy.impl.v2.model.carts.EtsyCart;
import com.notronix.etsy.impl.v2.model.listings.*;
import com.notronix.etsy.impl.v2.model.shops.EtsyCoupon;
import com.notronix.etsy.impl.v2.model.shops.EtsyReceipt;
import com.notronix.etsy.impl.v2.model.shops.EtsyRelatedLinks;
import com.notronix.etsy.impl.v2.model.shops.EtsyShop;
import com.notronix.etsy.impl.v2.model.taxonomy.EtsyTaxonomy;
import com.notronix.etsy.impl.v2.model.taxonomy.EtsyTaxonomyNodeProperty;
import com.notronix.etsy.impl.v2.model.types.EtsyDataType;
import com.notronix.etsy.impl.v2.model.users.EtsyShippingTemplate;
import com.notronix.etsy.impl.v2.model.users.EtsyUser;

import java.io.File;
import java.lang.reflect.Type;
import java.time.Instant;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.join;

public class EtsyDataService implements EtsyAPI
{
    private final Object lock = new Object();
    private final Credentials clientCredentials;
    private EtsyMethodExecutor executor;

    private EtsyMethodExecutor getExecutor() {
        if (executor != null) {
            return executor;
        }

        synchronized (lock) {
            if (executor != null) {
                return executor;
            }

            executor = new EtsyMethodExecutor(getMarshaller(), getUnMarshaller());
        }

        return executor;
    }

    private Marshaller getMarshaller() {
        return new Marshaller()
        {
            private final Gson gson = new GsonBuilder().setVersion(0)
                    .registerTypeAdapter(EtsyPaymentInfo.class, new EtsyPaymentInfoAdapter())
                    .registerTypeAdapter(EtsyRelatedLinks.class, new EtsyRelatedLinksAdapter())
                    .registerTypeAdapter(Boolean.class, new EtsyBooleanAdapter())
                    .registerTypeAdapter(EtsyMoney.class, new EtsyMoneyAdapter())
                    .registerTypeAdapter(ListingState.class, new ListingStateAdapter().nullSafe())
                    .create();

            @Override
            public String marshal(Object object) {
                return gson.toJson(object);
            }
        };
    }

    private Unmarshaller getUnMarshaller() {
        return new Unmarshaller()
        {
            private final Gson gson = new GsonBuilder()
                    .registerTypeAdapter(EtsyPaymentInfo.class, new EtsyPaymentInfoAdapter())
                    .registerTypeAdapter(EtsyRelatedLinks.class, new EtsyRelatedLinksAdapter())
                    .registerTypeAdapter(Boolean.class, new EtsyBooleanAdapter())
                    .registerTypeAdapter(Instant.class, new InstantAdapter().nullSafe())
                    .registerTypeAdapter(ListingState.class, new ListingStateAdapter().nullSafe())
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

    /**
     * Creates a new Etsy data service that can act on behalf of the registered application as identified by the supplied
     * consumerKey (or Key String) and consumerSecret (or Shared Secret).
     *
     * @param consumerKey    the consumer key (or key string) that identifies the registered Etsy application.
     * @param consumerSecret the consumer secret (or shared secret) that identifies the registered Etsy application.
     * @throws NullPointerException if either of the consumerKey or consumerSecret are null.
     */
    public EtsyDataService(String consumerKey, String consumerSecret) throws NullPointerException {
        clientCredentials = Credentials.forKeyPair(requireNonNull(consumerKey), requireNonNull(consumerSecret));
    }

    @Override
    public Credentials getTemporaryCredentials(EtsyScope[] scopes, String callback)
            throws NullPointerException, EtsyException {
        requireNonNull(scopes);

        try {
            String scope = "?scope=" + join(scopes, "%20");
            String url = "https://openapi.etsy.com/v2/oauth/request_token" + scope;
            EtsyOAuthTempCredentialsRequest request = new EtsyOAuthTempCredentialsRequest(url);
            request.setTransport(getExecutor().getRequestFactory().getTransport());
            request.setConsumerKey(requireNonNull(clientCredentials.getToken()));
            request.setCallback(isBlank(callback) ? "oob" : callback);

            OAuthHmacSigner signer = new OAuthHmacSigner();
            signer.clientSharedSecret = requireNonNull(clientCredentials.getTokenSecret());
            request.setSigner(signer);

            return request.execute();
        }
        catch (Exception ex) {
            throw new EtsyException("An error occurred trying to get temporary Etsy OAuth credentials.", ex);
        }
    }

    @Override
    public Credentials getAccessCredentials(Credentials temporaryCredentials, String verifier)
            throws NullPointerException, EtsyException {
        requireNonNull(temporaryCredentials);
        requireNonNull(verifier);

        try {
            String url = "https://openapi.etsy.com/v2/oauth/access_token";
            EtsyOAuthAccessTokenRequest request = new EtsyOAuthAccessTokenRequest(url);
            request.setTransport(getExecutor().getRequestFactory().getTransport());
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
            throw new EtsyException("An error occurred trying to get Etsy OAuth access credentials.", ex);
        }
    }

    @Override
    public EtsyPageableResponse<EtsyUser> findAllUsers(String keywords, Integer limit, Integer offset,
                                                       UserAssociations... associations) throws EtsyException {
        return getExecutor().execute(new FindAllUsersMethod(clientCredentials)
                .withKeywords(keywords).withLimit(limit).withOffset(offset).withAssociations(associations));
    }

    @Override
    public EtsyPageableResponse<EtsyUser> findAllUsers(PageableResponse<? extends User> response)
            throws EtsyException {
        return getExecutor().execute(new FindAllUsersMethod(clientCredentials)
                .withKeywords((String) response.getParams().get("keywords"))
                .withLimit(response.getPagination().getEffectiveLimit())
                .withOffset(response.getPagination().getNextOffset()));
    }

    @Override
    public EtsyDataType describeOccasionEnum() throws EtsyException {
        return getExecutor().execute(new DescribeOccasionEnumMethod(clientCredentials));
    }

    @Override
    public EtsyDataType describeRecipientEnum() throws EtsyException {
        return getExecutor().execute(new DescribeRecipientEnumMethod(clientCredentials));
    }

    @Override
    public EtsyDataType describeWhenMadeEnum(Boolean includeFormatted) throws EtsyException {
        return getExecutor().execute(new DescribeWhenMadeEnumMethod(clientCredentials).withIncludeFormatted(includeFormatted));
    }

    @Override
    public EtsyDataType describeWhoMadeEnum() throws EtsyException {
        return getExecutor().execute(new DescribeWhoMadeEnumMethod(clientCredentials));
    }

    @Override
    public List<EtsyApiMethod> getMethodTable() throws EtsyException {
        return getExecutor().execute(new GetMethodTableMethod(clientCredentials));
    }

    @Override
    public List<? extends Country> findAllCountry() throws EtsyException {
        return getExecutor().execute(new FindAllCountryMethod(clientCredentials));
    }

    @Override
    public List<? extends Style> findSuggestedStyles() throws EtsyException {
        return getExecutor().execute(new FindSuggestedStylesMethod(clientCredentials));
    }

    @Override
    public List<EtsyUser> getUser(Credentials accessCreds, List<String> userIdsOrNames, UserAssociations... associations)
            throws EtsyException {
        return getExecutor().execute(new GetUserMethod(clientCredentials, accessCreds)
                .withUserIdsOrNames(userIdsOrNames)
                .withAssociations(associations));
    }

    @Override
    public String getAvatarImgSrc(Credentials accessCreds, String userId) throws EtsyException {
        return getExecutor().execute(new GetAvatarImgSrcMethod(clientCredentials, accessCreds).withUserId(userId));
    }

    @Override
    public EtsyResponse<List<EtsyShop>> findAllShops(Credentials accessCreds,
                                                     String shopName, Integer limit, Integer offset,
                                                     Float lat, Float lon, Float distanceMax,
                                                     ShopAssociations... associations) throws EtsyException {
        return getExecutor().execute(new FindAllShopsMethod(clientCredentials, accessCreds)
                .withAssociations(associations)
                .withShopName(shopName)
                .withLimit(limit)
                .withOffset(offset)
                .withLatitude(lat)
                .withLongitude(lon)
                .withDistanceMax(distanceMax));
    }

    @Override
    public EtsyPageableResponse<EtsyShop> findAllUserShops(Credentials accessCreds, String userId,
                                                           Integer limit, Integer offset, ShopAssociations... associations)
            throws EtsyException {
        return getExecutor().execute(new FindAllUserShopsMethod(clientCredentials, accessCreds)
                .withUserId(userId)
                .withLimit(limit)
                .withOffset(offset)
                .withAssociations(associations));
    }

//    public EtsyPageableResponse<EtsyShop> findAllUserShopsNext(Credentials accessCreds,
//                                                               EtsyPageableResponse<EtsyShop> pager)
//            throws EtsyAPIException {
//        return getExecutor().execute(requireNonNull(pager).buildNextPage(new FindAllUserShopsMethod(clientCredentials, accessCreds)));
//    }

    @Override
    public List<EtsyShop> getShop(Credentials accessCreds, List<String> shopIdsOrNames, ShopAssociations... associations)
            throws EtsyException {
        return getExecutor().execute(new GetShopMethod(clientCredentials, accessCreds)
                .withShopIdsOrNames(shopIdsOrNames)
                .withAssociations(associations));
    }

    @Override
    public EtsyResponse<List<EtsyShippingTemplate>> findAllUserShippingProfiles(Credentials accessCreds, String userId,
                                                                                Integer limit, Integer offset, Integer page)
            throws EtsyException {
        return getExecutor().execute(new FindAllUserShippingProfilesMethod(clientCredentials, accessCreds)
                .withUserId(userId)
                .withLimit(limit)
                .withOffset(offset)
                .withPage(page));
    }

    @Override
    public List<EtsyTaxonomy> getSellerTaxonomy() throws EtsyException {
        return getExecutor().execute(new GetSellerTaxonomyMethod(clientCredentials));
    }

    @Override
    public List<EtsyTaxonomyNodeProperty> getTaxonomyNodeProperties(Long taxonomyId) throws EtsyException {
        return getExecutor().execute(new GetTaxonomyNodePropertiesMethod(clientCredentials).withTaxonomyId(taxonomyId));
    }

    @Override
    public List<EtsyListing> getListing(Credentials accessCreds, List<Long> listingIds,
                                        ListingAssociations... associations)
            throws EtsyException {
        return getExecutor().execute(new GetListingMethod(clientCredentials, accessCreds)
                .withListingIds(requireNonNull(listingIds))
                .withAssociations(associations));
    }

    @Override
    public EtsyListingInventory getInventory(Credentials accessCreds, Long listingId, Boolean writeMissingInventory)
            throws EtsyException {
        return getExecutor().execute(new GetInventoryMethod(clientCredentials, accessCreds)
                .withListingId(requireNonNull(listingId))
                .withWriteMissingInventory(writeMissingInventory));
    }

    @Override
    public EtsyListingInventory updateInventory(Credentials accessCreds, Long listingId, ListingInventory inventory)
            throws EtsyException {
        return getExecutor().execute(new UpdateInventoryMethod(clientCredentials, accessCreds)
                .withListingId(listingId)
                .withInventory(inventory));
    }

    @Override
    public EtsyListing createListing(Credentials accessCreds, Integer quantity, String title,
                                     String description, Float price, List<String> materials, Long shippingTemplateId,
                                     Long shopSectionId, List<Long> imageIds, Boolean isCustomizable, Boolean nonTaxable,
                                     ListingState state, Integer processingMin, Integer processingMax, Long categoryId,
                                     Long taxonomyId, List<String> tags, String whoMade, Boolean isSupply, String whenMade,
                                     String recipient, String occasion, List<String> style) throws EtsyException {
        return getExecutor().execute(new CreateListingMethod(clientCredentials, accessCreds)
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
                                     Integer processingMax, String featuredRank) throws EtsyException {
        return getExecutor().execute(new UpdateListingMethod(clientCredentials, accessCreds)
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
    public EtsyPageableResponse<EtsyListing> findAllActiveListings(Credentials accessCreds, Integer limit, Integer offset)
            throws EtsyException {
        return getExecutor().execute(new FindAllListingActiveMethod(clientCredentials, accessCreds)
                .withLimit(limit)
                .withOffset(offset));
    }

//    public EtsyPageableResponse<EtsyListing> findAllActiveListingsNext(Credentials accessCreds,
//                                                                       EtsyPageableResponse<EtsyListing> pager)
//            throws EtsyAPIException {
//        return getExecutor().execute(requireNonNull(pager).buildNextPage(new FindAllListingActiveMethod(clientCredentials, accessCreds)));
//    }

    @Override
    public EtsyPageableResponse<EtsyListing> findAllShopListingsActive(Credentials accessCreds, String shopIdOrName)
            throws EtsyException {
        return getExecutor().execute(new FindAllShopListingsActiveMethod(clientCredentials, accessCreds)
                .withShopIdOrName(shopIdOrName)
                .withAssociations(ListingAssociations.values()));
    }

//    public EtsyPageableResponse<EtsyListing> findAllShopListingsActiveNext(Credentials accessCreds,
//                                                                           PageableResponse<Listing> pager)
//            throws EtsyAPIException {
//        return getExecutor().execute(requireNonNull(pager).buildNextPage(new FindAllShopListingsActiveMethod(clientCredentials,
//                accessCreds)));
//    }

    @Override
    public EtsyListingImage uploadListingImage(Credentials accessCreds, Long listingId, File image, Integer rank,
                                               Boolean overwrite, Boolean isWaterMarked) throws EtsyException {
        return getExecutor().execute(new UploadListingImageMethod(clientCredentials, accessCreds)
                .withListingId(listingId)
                .withImage(image)
                .withRank(rank)
                .withOverwrite(overwrite)
                .withIsWaterMarked(isWaterMarked));
    }

    @Override
    public List<EtsyListingVariationImage> getVariationImages(Credentials accessCreds, Long listingId)
            throws EtsyException {
        return getExecutor().execute(new GetVariationImagesMethod(clientCredentials, accessCreds).withListingId(listingId));
    }

    @Override
    public List<EtsyListingVariationImage> updateVariationImages(Credentials accessCreds, Long listingId,
                                                                 List<? extends ListingVariationImage> variationImages)
            throws EtsyException {
        return getExecutor().execute(new UpdateVariationImagesMethod(clientCredentials, accessCreds)
                .withListingId(listingId)
                .withVariationImages(variationImages));
    }

    @Override
    public EtsyCart createSingleListingCart(Credentials accessCreds, String userId, Long listingId, Integer quantity,
                                            CartAssociations... associations) throws EtsyException {
        return getExecutor().execute(new CreateSingleListingCartMethod(clientCredentials, accessCreds)
                .withUserId(userId)
                .withListingId(listingId)
                .withQuantity(quantity));
    }

    @Override
    public EtsyPageableResponse<EtsyCart> getAllUserCarts(Credentials accessCreds, String userId,
                                                          CartAssociations... associations) throws EtsyException {
        return getExecutor().execute(new GetAllUserCartsMethod(clientCredentials, accessCreds)
                .withUserId(userId)
                .withAssociations(associations));
    }

    @Override
    public Cart getUserCart(Credentials accessCreds, String userId, Long cartId) throws EtsyException {
        return getExecutor().execute(new GetUserCartMethod(clientCredentials, accessCreds)
                .withUserId(userId)
                .withCartId(cartId));
    }

    @Override
    public EtsyCart addToCart(Credentials accessCreds, String userId, Long listingId, Integer quantity)
            throws EtsyException {
        return getExecutor().execute(new AddToCartMethod(clientCredentials, accessCreds)
                .withUserId(userId)
                .withListingId(listingId));
    }

    @Deprecated
    @Override
    public List<EtsyCoupon> findAllShopCoupons(Credentials accessCreds, String shopIdOrName) throws EtsyException {
        return getExecutor().execute(new FindAllShopCouponsMethod(clientCredentials, accessCreds).withShopIdOrName(shopIdOrName));
    }

    @Override
    public EtsyPageableResponse<EtsyReceipt> findAllShopReceipts(Credentials accessCreds, String shopIdOrName,
                                                                 ReceiptAssociations... associations)
            throws EtsyException {
        return getExecutor().execute(new FindAllShopReceiptsMethod(clientCredentials, accessCreds).withShopIdOrName(shopIdOrName));
    }

//    public EtsyPageableResponse<EtsyReceipt> findAllShopReceiptsNext(Credentials accessCreds,
//                                                                     EtsyPageableResponse<EtsyReceipt> pager)
//            throws EtsyAPIException {
//        return getExecutor().execute(requireNonNull(pager)
//                .buildNextPage(new FindAllShopReceiptsMethod(clientCredentials, accessCreds)));
//    }

    @Override
    public EtsyResponse<List<EtsyReceipt>> submitTracking(Credentials accessCreds, Long shopId,
                                                          Long receiptId, String trackingCode, String carrierName,
                                                          Boolean sendBcc) throws EtsyException {
        return getExecutor().execute(new SubmitTrackingMethod(clientCredentials, accessCreds)
                .withShopId(shopId).withReceiptId(receiptId)
                .withTrackingCode(trackingCode).withCarrierName(carrierName).withSendBcc(sendBcc));
    }


}
