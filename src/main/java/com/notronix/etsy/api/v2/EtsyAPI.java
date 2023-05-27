package com.notronix.etsy.api.v2;

import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.v2.method.PageableResponse;
import com.notronix.etsy.api.v2.method.Response;
import com.notronix.etsy.api.v2.model.authentication.EtsyScope;
import com.notronix.etsy.api.v2.model.baseline.ApiMethod;
import com.notronix.etsy.api.v2.model.carts.Cart;
import com.notronix.etsy.api.v2.model.carts.CartAssociations;
import com.notronix.etsy.api.v2.model.countries.Country;
import com.notronix.etsy.api.v2.model.listings.*;
import com.notronix.etsy.api.v2.model.shops.*;
import com.notronix.etsy.api.v2.model.taxonomy.Style;
import com.notronix.etsy.api.v2.model.taxonomy.Taxonomy;
import com.notronix.etsy.api.model.taxonomy.TaxonomyNodeProperty;
import com.notronix.etsy.api.v2.model.types.DataType;
import com.notronix.etsy.api.v2.model.users.ShippingTemplate;
import com.notronix.etsy.api.v2.model.users.User;
import com.notronix.etsy.api.v2.model.users.UserAssociations;

import java.io.File;
import java.util.List;

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
     * @param scopes   An array of {@link EtsyScope Etsy scopes} that you require
     *                 permission for from the Etsy account holder.
     * @param callback A callback URL that can be used.  If supplied, Etsy will redirect to this URL and provide the
     *                 <i>verifier</i> code as part of the query parameters.  If not supplied, an Out-of-Band (OOB)
     *                 process should be used instead.
     * @return temporary OAuth credentials that can be used to obtain access credentials.
     * @throws NullPointerException if the array of scopes is null
     * @throws EtsyException        if there is any error related to the underlying API HTTP request
     */
    Credentials getTemporaryCredentials(EtsyScope[] scopes, String callback)
            throws NullPointerException, EtsyException;

    /**
     * Gets the access OAuth credentials from Etsy.
     * <br><br>
     * The returned <code>Credentials</code> are used for any Etsy API call that requires OAuth authentication.
     *
     * @param tempCredentials the credentials obtained using {@link EtsyAPI#getTemporaryCredentials}
     * @param verifier        the verifier code retrieved from Etsy as a result of granting permission when following the
     *                        {@link Credentials#getLoginUrl() login URL}.
     * @return OAuth access credentials that can be used with any API call that requires OAuth authentication.
     * @throws NullPointerException if temporaryCredentials or verifier are null
     * @throws EtsyException        if there is any error related to the underlying API HTTP request
     */
    Credentials getAccessCredentials(Credentials tempCredentials, String verifier)
            throws NullPointerException, EtsyException;

    PageableResponse<? extends User> findAllUsers(String keywords, Integer limit, Integer offset,
                                                  UserAssociations... associations) throws EtsyException;

    PageableResponse<? extends User> findAllUsers(PageableResponse<? extends User> response) throws EtsyException;

    List<? extends ApiMethod> getMethodTable() throws EtsyException;

    DataType describeOccasionEnum() throws EtsyException;

    DataType describeRecipientEnum() throws EtsyException;

    DataType describeWhenMadeEnum(Boolean includeFormatted) throws EtsyException;

    DataType describeWhoMadeEnum() throws EtsyException;

    List<? extends Country> findAllCountry() throws EtsyException;

    List<? extends Style> findSuggestedStyles() throws EtsyException;

    List<? extends User> getUser(Credentials accessCreds, List<String> userIdsOrNames, UserAssociations... associations)
            throws EtsyException;

    String getAvatarImgSrc(Credentials accessCreds, String userId) throws EtsyException;

    Response<? extends List<? extends Shop>> findAllShops(Credentials accessCreds, String shopName, Integer limit,
                                                          Integer offset, Float lat, Float lon, Float distanceMax,
                                                          ShopAssociations... associations)
            throws EtsyException;

    PageableResponse<? extends Shop> findAllUserShops(Credentials accessCreds, String userId, Integer limit,
                                                      Integer offset, ShopAssociations... associations)
            throws EtsyException;

    List<? extends Shop> getShop(Credentials accessCreds, List<String> shopIdsOrNames, ShopAssociations... associations)
            throws EtsyException;

    Response<? extends List<? extends ShippingTemplate>> findAllUserShippingProfiles(Credentials accessCreds, String userId,
                                                                                     Integer limit, Integer offset,
                                                                                     Integer page)
            throws EtsyException;

    List<? extends Taxonomy> getSellerTaxonomy() throws EtsyException;

    List<? extends TaxonomyNodeProperty> getTaxonomyNodeProperties(Long taxonomyId) throws EtsyException;

    Listing createListing(Credentials accessCreds, Integer quantity, String title,
                          String description, Float price, List<String> materials, Long shippingTemplateId,
                          Long shopSectionId, List<Long> imageIds, Boolean isCustomizable, Boolean nonTaxable,
                          ListingState state, Integer processingMin, Integer processingMax, Long categoryId,
                          Long taxonomyId, List<String> tags, String whoMade, Boolean isSupply, String whenMade,
                          String recipient, String occasion, List<String> style)
            throws EtsyException;

    Listing updateListing(Credentials accessCreds, Long listingId, String title,
                          String description, List<String> materials, Boolean renew, Long shippingTemplateId,
                          Long shopSectionId, ListingState state, List<Long> imageIds, Boolean isCustomizable,
                          Float itemWeight, Float itemLength, Float itemWidth, Float itemHeight, WeightUnit weightUnit,
                          DimensionUnit dimensionUnit, Boolean nonTaxable, Long categoryId, Long taxonomyId,
                          List<String> tags, String whoMade, Boolean isSupply, String whenMade, String recipient,
                          String occasion, List<String> style, Integer processingMin, Integer processingMax,
                          String featuredRank)
            throws EtsyException;

    List<? extends Listing> getListing(Credentials accessCreds, List<Long> listingIds, ListingAssociations... associations)
            throws EtsyException;

    ListingInventory getInventory(Credentials accessCreds, Long listingId, Boolean writeMissingInventory)
            throws EtsyException;

    ListingInventory updateInventory(Credentials accessCreds, Long listingId, ListingInventory inventory)
            throws EtsyException;

    Response<? extends List<? extends Listing>> findAllActiveListings(Credentials accessCreds, Integer limit, Integer offset)
            throws EtsyException;

    PageableResponse<? extends Listing> findAllShopListingsActive(Credentials accessCreds, String shopIdOrName)
            throws EtsyException;

    ListingImage uploadListingImage(Credentials accessCreds, Long listingId, File image,
                                    Integer rank, Boolean overwrite, Boolean isWaterMarked) throws EtsyException;

    List<? extends ListingVariationImage> getVariationImages(Credentials accessCreds, Long listingId)
            throws EtsyException;

    List<? extends ListingVariationImage> updateVariationImages(Credentials accessCreds, Long listingId,
                                                                List<? extends ListingVariationImage> variationImages)
            throws EtsyException;

    Cart createSingleListingCart(Credentials accessCreds, String userId, Long listingId, Integer quantity,
                                 CartAssociations... associations) throws EtsyException;

    Response<? extends List<? extends Cart>> getAllUserCarts(Credentials accessCreds, String userId,
                                                             CartAssociations... associations) throws EtsyException;

    Cart getUserCart(Credentials accessCreds, String userId, Long cartId) throws EtsyException;

    Cart addToCart(Credentials accessCreds, String userId, Long listingId, Integer quantity) throws EtsyException;

    @Deprecated
    List<? extends Coupon> findAllShopCoupons(Credentials accessCreds, String shopIdOrName) throws EtsyException;

    PageableResponse<? extends Receipt> findAllShopReceipts(Credentials accessCreds, String shopIdOrName,
                                                            ReceiptAssociations... associations)
            throws EtsyException;

    Response<? extends List<? extends Receipt>> submitTracking(Credentials accessCreds, Long shopId, Long receiptId,
                                                               String trackingCode, String carrierName, Boolean sendBcc)
            throws EtsyException;
}
