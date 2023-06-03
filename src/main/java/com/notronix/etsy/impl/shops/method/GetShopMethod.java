package com.notronix.etsy.impl.shops.method;

import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.EtsyMethod;
import com.notronix.etsy.impl.shops.model.EtsyShop;

import static java.util.Objects.requireNonNull;

public class GetShopMethod extends EtsyMethod<EtsyShop>
{
    private Long shopId;

    public GetShopMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    public EtsyShop getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, EtsyShop.class);
    }

    @Override
    protected String getURI() {
        return "/application/shops/" + requireNonNull(shopId);
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public GetShopMethod withShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }
}
