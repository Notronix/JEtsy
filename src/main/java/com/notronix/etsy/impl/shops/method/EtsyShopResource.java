package com.notronix.etsy.impl.shops.method;

import com.google.api.client.http.HttpContent;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.shops.method.GetShopMethod;
import com.notronix.etsy.api.shops.method.GetShopSectionsMethod;
import com.notronix.etsy.api.shops.method.GetShopShippingProfilesMethod;
import com.notronix.etsy.api.shops.method.ShopResource;

public class EtsyShopResource implements ShopResource<HttpContent>
{
    @Override
    public GetShopMethod<HttpContent> createGetShopMethod() {
        return new EtsyGetShopMethod();
    }

    @Override
    public GetShopShippingProfilesMethod<HttpContent> createGetShopShippingProfilesMethod(AccessToken accessToken) {
        return new EtsyGetShopShippingProfilesMethod().withAccessToken(accessToken);
    }

    @Override
    public GetShopSectionsMethod<HttpContent> createGetShopSectionsMethod() {
        return new EtsyGetShopSectionsMethod();
    }
}
