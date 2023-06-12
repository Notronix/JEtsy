package com.notronix.etsy.impl.shops.method;

import com.google.api.client.http.HttpContent;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.shops.method.GetShopMethod;
import com.notronix.etsy.api.shops.model.Shop;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.shops.model.EtsyShop;

import static java.util.Objects.requireNonNull;

public class EtsyGetShopMethod extends AbstractEtsyMethod<Shop> implements GetShopMethod<HttpContent>
{
    private Long shopId;

    @Override
    public EtsyShop buildResponseBody(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, EtsyShop.class);
    }

    @Override
    protected String getURI() {
        return "/application/shops/" + requireNonNull(shopId);
    }

    public Long getShopId() {
        return shopId;
    }

    @Override
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public EtsyGetShopMethod withShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }
}
