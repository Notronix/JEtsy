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

    Response<? extends List<? extends ShippingTemplate>> findAllShippingTemplates(Credentials clientCreds, Credentials accessCreds)
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

    ListingImage uploadListingImage(Credentials clientCreds, Credentials accessCreds, Long listingId, File image)
            throws EtsyAPIException;
}
