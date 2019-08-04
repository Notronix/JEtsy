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

    Credentials getTemporaryCredentials(Credentials clientCreds, String callback, Set<String> scopes)
            throws EtsyAPIException;

    Credentials getAccessCredentials(Credentials clientCreds, Credentials tempCredentials, String verifier)
            throws EtsyAPIException;

    DataType describeOccasionEnum(Credentials clientCreds)
            throws EtsyAPIException;

    DataType describeRecipientEnum(Credentials clientCreds)
            throws EtsyAPIException;

    DataType describeWhenMadeEnum(Credentials clientCreds)
            throws EtsyAPIException;

    DataType describeWhoMadeEnum(Credentials clientCreds)
            throws EtsyAPIException;

    List<? extends ApiMethod> getMethodTable(Credentials clientCreds)
            throws EtsyAPIException;

    List<? extends Country> findAllCountry(Credentials clientCreds)
            throws EtsyAPIException;

    List<? extends Style> findSuggestedStyles(Credentials clientCreds)
            throws EtsyAPIException;

    User getUser(Credentials clientCreds, Credentials accessCreds, String userId, UserAssociations... associations)
            throws EtsyAPIException;

    String getAvatarImgSrc(Credentials clientCreds, Credentials accessCreds, String userId)
            throws EtsyAPIException;

    Response<? extends List<? extends Shop>> findAllShops(Credentials clientCreds, Credentials accessCreds,
                                                          String shopName, Integer limit, Integer offset,
                                                          Float lat, Float lon, Float distanceMax,
                                                          ShopAssociations... associations)
            throws EtsyAPIException;

    Response<? extends List<? extends Shop>> findAllUserShops(Credentials clientCreds, Credentials accessCreds,
                                                              String userId, ShopAssociations... associations)
            throws EtsyAPIException;

    Shop getShop(Credentials clientCreds, Credentials accessCreds, Long shopId, ShopAssociations... associations)
            throws EtsyAPIException;

    Response<? extends List<? extends ShippingTemplate>> findAllUserShippingProfiles(Credentials clientCreds,
                                                                                     Credentials accessCreds,
                                                                                     String userId,
                                                                                     Integer limit,
                                                                                     Integer offset)
            throws EtsyAPIException;

    List<? extends Taxonomy> getSellerTaxonomy(Credentials clientCreds)
            throws EtsyAPIException;

    List<? extends TaxonomyNodeProperty> getTaxonomyNodeProperties(Credentials clientCreds, Long taxonomyId)
            throws EtsyAPIException;

    Listing createListing(Credentials clientCreds, Credentials accessCreds, Listing listing)
            throws EtsyAPIException;

    Listing getListing(Credentials clientCreds, Credentials accessCreds, Long listingId, ListingAssociations... associations)
            throws EtsyAPIException;

    ListingInventory getInventory(Credentials clientCreds, Credentials accessCreds, Long listingId, Boolean writeMissingInventory)
            throws EtsyAPIException;

    ListingInventory updateInventory(Credentials clientCreds, Credentials accessCreds, Long listingId, ListingInventory inventory)
            throws EtsyAPIException;

    Response<? extends Listing> findAllActiveListings(Credentials clientCreds, Credentials accessCreds, Integer limit, Integer offset)
            throws EtsyAPIException;

    ListingImage uploadListingImage(Credentials clientCreds, Credentials accessCreds, Long listingId, File image,
                                    Integer rank, Boolean overwrite, Boolean isWaterMarked)
            throws EtsyAPIException;

    List<? extends ListingVariationImage> getVariationImages(Credentials clientCreds, Credentials accessCreds, Long listingId)
            throws EtsyAPIException;

    List<? extends ListingVariationImage> updateVariationImages(Credentials clientCreds, Credentials accessCreds, Long listingId,
                               List<? extends ListingVariationImage> variationImages)
            throws EtsyAPIException;

    Cart createSingleListingCart(Credentials clientCreds, Credentials accessCreds, String userId, Long listingId,
                                 CartAssociations... associations)
            throws EtsyAPIException;

    Response<? extends List<? extends Cart>> getAllUserCarts(Credentials clientCreds, Credentials accessCreds,
                                                             String userId, CartAssociations... associations)
            throws EtsyAPIException;

    Cart getUserCart(Credentials clientCreds, Credentials accessCreds, String userId, Long cartId)
            throws  EtsyAPIException;

    Cart addToCart(Credentials clientCreds, Credentials accessCreds, String userId, Long listingId, Integer quantity)
            throws EtsyAPIException;

    List<? extends Coupon> findAllShopCoupons(Credentials clientCreds, Credentials accessCreds, Long shopId)
            throws EtsyAPIException;
}
