package com.notronix.etsy.api;

import com.notronix.etsy.api.authentication.method.AuthResource;
import com.notronix.etsy.api.common.method.Method;
import com.notronix.etsy.api.listings.method.ListingResource;
import com.notronix.etsy.api.shops.method.ShopResource;
import com.notronix.etsy.api.taxonomy.method.TaxonomyResource;
import com.notronix.etsy.api.users.method.UserResource;

public interface API<C>
{
    void setMarshaller(Marshaller marshaller);

    void setUnmarshaller(Unmarshaller unmarshaller);

    AuthResource<C> getAuthResource();

    UserResource<C> getUserResource();

    ListingResource<C> getListingResource();

    ShopResource<C> getShopResource();

    TaxonomyResource<C> getTaxonomyResource();

    <T> Response<T> execute(AppKey appKey, Method<T, C> method) throws EtsyException;
}
