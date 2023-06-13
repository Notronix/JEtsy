package com.notronix.etsy.impl.shops.method;

import com.google.api.client.http.HttpContent;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.shops.method.ShopResource;

public class EtsyShopResource implements ShopResource<HttpContent>
{
    @Override
    public EtsyGetShopMethod createGetShopMethod() {
        return new EtsyGetShopMethod();
    }

    @Override
    public EtsyGetShopShippingProfilesMethod createGetShopShippingProfilesMethod(AccessToken accessToken) {
        return new EtsyGetShopShippingProfilesMethod().withAccessToken(accessToken);
    }

    @Override
    public EtsyGetShopSectionsMethod createGetShopSectionsMethod() {
        return new EtsyGetShopSectionsMethod();
    }
}
