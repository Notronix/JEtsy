package com.notronix.etsy.api.shops.method;

import com.notronix.etsy.api.Resource;
import com.notronix.etsy.api.authentication.model.AccessToken;

public interface ShopResource<C> extends Resource
{
    GetShopMethod<C> createGetShopMethod();

    GetShopShippingProfilesMethod<C> createGetShopShippingProfilesMethod(AccessToken accessToken);

    GetShopSectionsMethod<C> createGetShopSectionsMethod();
}
