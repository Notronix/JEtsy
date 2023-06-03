package com.notronix.etsy.api;

import com.notronix.etsy.api.authentication.AuthResource;
import com.notronix.etsy.api.listings.ListingResource;
import com.notronix.etsy.api.shops.ShopResource;
import com.notronix.etsy.api.taxonomy.TaxonomyResource;
import com.notronix.etsy.api.users.UserResource;

public interface API
{
    AuthResource getAuthResource();

    ListingResource getListingResource();

    ShopResource getShopResource();

    TaxonomyResource getTaxonomyResource();

    UserResource getUserResource();
}
