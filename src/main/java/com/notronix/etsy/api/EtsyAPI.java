package com.notronix.etsy.api;

import com.notronix.etsy.api.authentication.Credentials;
import com.notronix.etsy.api.method.Response;
import com.notronix.etsy.api.model.*;

import java.io.File;
import java.util.List;
import java.util.Set;

public interface EtsyAPI
{
    String __SELF__ = "__SELF__";

    /**
     * Gets the temporary OAuth credentials from Etsy.
     * <br><br>
     * The returned <code>Credentials</code> contains a
     * {@link Credentials#getLoginUrl() login URL} that can be used to connect to an existing Etsy account and in turn
     * receive a <i>verifier</i> code.  The verifier code and these temporary credentials are then used when calling
     * {@link EtsyAPI#getAccessCredentials}
     *
     * @param scopes A set of {@link com.notronix.etsy.api.authentication.EtsyScope Etsy scopes} that you require
     *               permission for from the Etsy account holder.
     * @param callback A callback URL that can be used.  If supplied, Etsy will redirect to this URL and provide the
     *                 <i>verifier</i> code as part of the query parameters.  If not supplied, an Out-of-Band (OOB)
     *                 process should be used instead.
     *
     * @return temporary OAuth credentials that can be used to obtain access credentials.
     * @throws NullPointerException if the set of scopes is null
     * @throws EtsyAPIException if there is any error related to the underlying API HTTP request
     */
    Credentials getTemporaryCredentials(Set<String> scopes, String callback)
            throws NullPointerException, EtsyAPIException;

    /**
     * Gets the access OAuth credentials from Etsy.
     * <br><br>
     * The returned <code>Credentials</code> are used for any Etsy API call that requires OAuth authentication.
     *
     * @param tempCredentials the credentials obtains using {@link EtsyAPI#getTemporaryCredentials}
     * @param verifier the verifier code retrieved from Etsy as a result of granting permission when following the
     *                 {@link Credentials#getLoginUrl() login URL}.
     *
     * @return OAuth access credentials that can be used with any API call that requires OAuth authentication.
     * @throws NullPointerException if temporaryCredentials or verifier are null
     * @throws EtsyAPIException if there is any error related to the underlying API HTTP request
     */
    Credentials getAccessCredentials(Credentials tempCredentials, String verifier)
            throws NullPointerException, EtsyAPIException;

    List<? extends ApiMethod> getMethodTable()
            throws EtsyAPIException;

    DataType describeOccasionEnum()
            throws EtsyAPIException;

    DataType describeRecipientEnum()
            throws EtsyAPIException;

    DataType describeWhenMadeEnum(Boolean includeFormatted)
            throws EtsyAPIException;

    DataType describeWhoMadeEnum()
            throws EtsyAPIException;

    List<? extends Country> findAllCountry()
            throws EtsyAPIException;

    List<? extends Style> findSuggestedStyles()
            throws EtsyAPIException;

    List<? extends User> getUser(Credentials accessCreds, List<String> userIdsOrNames,
                                 UserAssociations... associations) throws EtsyAPIException;

    String getAvatarImgSrc(Credentials accessCreds, String userId)
            throws EtsyAPIException;

    Response<? extends List<? extends Shop>> findAllShops(Credentials accessCreds,
                                                          String shopName, Integer limit, Integer offset,
                                                          Float lat, Float lon, Float distanceMax,
                                                          ShopAssociations... associations)
            throws EtsyAPIException;

    Response<? extends List<? extends Shop>> findAllUserShops(Credentials accessCreds,
                                                              String userId, Integer limit, Integer offset,
                                                              ShopAssociations... associations)
            throws EtsyAPIException;

    List<? extends Shop> getShop(Credentials accessCreds, List<String> shopIdsOrNames,
                                 ShopAssociations... associations) throws EtsyAPIException;

    Response<? extends List<? extends ShippingTemplate>> findAllUserShippingProfiles(Credentials accessCreds,
                                                                                     String userId,
                                                                                     Integer limit,
                                                                                     Integer offset,
                                                                                     Integer page)
            throws EtsyAPIException;

    List<? extends Taxonomy> getSellerTaxonomy()
            throws EtsyAPIException;

    List<? extends TaxonomyNodeProperty> getTaxonomyNodeProperties(Long taxonomyId)
            throws EtsyAPIException;

    Listing createListing(Credentials accessCreds, Integer quantity, String title,
                          String description, Float price, List<String> materials, Long shippingTemplateId,
                          Long shopSectionId, List<Long> imageIds, Boolean isCustomizable, Boolean nonTaxable,
                          ListingState state, Integer processingMin, Integer processingMax, Long categoryId,
                          Long taxonomyId, List<String> tags, String whoMade, Boolean isSupply, String whenMade,
                          String recipient, String occasion, List<String> style)
            throws EtsyAPIException;

    Listing updateListing(Credentials accessCreds, Long listingId, String title,
                          String description, List<String> materials, Boolean renew, Long shippingTemplateId,
                          Long shopSectionId, ListingState state, List<Long> imageIds, Boolean isCustomizable,
                          Float itemWeight, Float itemLength, Float itemWidth, Float itemHeight, WeightUnit weightUnit,
                          DimensionUnit dimensionUnit, Boolean nonTaxable, Long categoryId, Long taxonomyId,
                          List<String> tags, String whoMade, Boolean isSupply, String whenMade, String recipient,
                          String occasion, List<String> style, Integer processingMin, Integer processingMax,
                          String featuredRank)
            throws EtsyAPIException;

    List<? extends Listing> getListing(Credentials accessCreds, List<Long> listingIds, ListingAssociations... associations)
            throws EtsyAPIException;

    ListingInventory getInventory(Credentials accessCreds, Long listingId, Boolean writeMissingInventory)
            throws EtsyAPIException;

    ListingInventory updateInventory(Credentials accessCreds, Long listingId, ListingInventory inventory)
            throws EtsyAPIException;

    Response<? extends List<? extends Listing>> findAllActiveListings(Credentials accessCreds, Integer limit, Integer offset)
            throws EtsyAPIException;

    ListingImage uploadListingImage(Credentials accessCreds, Long listingId, File image,
                                    Integer rank, Boolean overwrite, Boolean isWaterMarked)
            throws EtsyAPIException;

    List<? extends ListingVariationImage> getVariationImages(Credentials accessCreds, Long listingId)
            throws EtsyAPIException;

    List<? extends ListingVariationImage> updateVariationImages(Credentials accessCreds, Long listingId,
                                                                List<? extends ListingVariationImage> variationImages)
            throws EtsyAPIException;

    Cart createSingleListingCart(Credentials accessCreds, String userId, Long listingId,
                                 Integer quantity, CartAssociations... associations)
            throws EtsyAPIException;

    Response<? extends List<? extends Cart>> getAllUserCarts(Credentials accessCreds,
                                                             String userId, CartAssociations... associations)
            throws EtsyAPIException;

    Cart getUserCart(Credentials accessCreds, String userId, Long cartId)
            throws EtsyAPIException;

    Cart addToCart(Credentials accessCreds, String userId, Long listingId, Integer quantity)
            throws EtsyAPIException;

    List<? extends Coupon> findAllShopCoupons(Credentials accessCreds, String shopIdOrName)
            throws EtsyAPIException;

    Response<? extends List<? extends Receipt>> findAllShopReceipts(Credentials accessCreds,
                                                                    String shopIdOrName, ReceiptAssociations... associations)
            throws EtsyAPIException;

    Response<? extends List<? extends Receipt>> submitTracking(Credentials accessCreds,
                                                               Long shopId, Long receiptId, String trackingCode,
                                                               String carrierName, Boolean sendBcc)
            throws EtsyAPIException;
}
