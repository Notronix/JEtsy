package com.notronix.etsy.impl.shops.method;

import com.google.api.client.http.HttpContent;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.common.method.OAuthMethod;
import com.notronix.etsy.api.shops.method.GetShopShippingProfilesMethod;
import com.notronix.etsy.api.shops.model.ShippingProfile;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.EtsyPageableResponse;
import com.notronix.etsy.impl.shops.model.EtsyShippingProfile;

import static java.util.Objects.requireNonNull;

public class EtsyGetShopShippingProfilesMethod extends AbstractEtsyMethod<PageableResponse<ShippingProfile>>
    implements GetShopShippingProfilesMethod<HttpContent>, OAuthMethod
{
    private AccessToken accessToken;
    private Long shopId;

    @Override
    public PageableResponse<ShippingProfile> buildResponseBody(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload,
                new TypeToken<EtsyPageableResponse<EtsyShippingProfile>>(){}.getType());
    }

    @Override
    protected String getURI() {
        return "/application/shops/" + requireNonNull(shopId) + "/shipping-profiles";
    }

    @Override
    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public EtsyGetShopShippingProfilesMethod withAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public Long getShopId() {
        return shopId;
    }

    @Override
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public EtsyGetShopShippingProfilesMethod withShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }
}
