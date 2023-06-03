package com.notronix.etsy.impl.shops.method;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.impl.EtsyPageableResponse;
import com.notronix.etsy.impl.PageableEtsyMethod;
import com.notronix.etsy.impl.shops.model.EtsyShippingProfile;

import static java.util.Objects.requireNonNull;

public class GetShopShippingProfilesMethod extends PageableEtsyMethod<EtsyShippingProfile>
{
    private Long shopId;

    public GetShopShippingProfilesMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public PageableResponse<EtsyShippingProfile> getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload,
                new TypeToken<EtsyPageableResponse<EtsyShippingProfile>>(){}.getType());
    }

    @Override
    protected String getURI() {
        return "/application/shops/" + requireNonNull(shopId) + "/shipping-profiles";
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public GetShopShippingProfilesMethod withShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }
}
