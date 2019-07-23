package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.model.ShopAssociations;
import com.notronix.etsy.impl.model.EtsyShop;

import java.util.List;

import static com.notronix.etsy.impl.method.MethodUtils.addIfProvided;
import static com.notronix.etsy.impl.method.MethodUtils.safeList;
import static java.util.Objects.requireNonNull;

public class GetShopMethod extends AbstractEtsyMethod<EtsyShop>
{
    private Long shopId;
    private ShopAssociations[] associations;

    @Override
    String getURI() {
        String uri = "/shops/" + requireNonNull(shopId);
        uri = addIfProvided(uri, "includes", safeList(associations), ASSOCIATIONS_CONVERTER);

        return uri;
    }

    @Override
    public EtsyShop getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyShop>> response
                = gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyShop>>>(){}.getType());

        return response.getResults().stream().findAny().orElse(null);
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

    public ShopAssociations[] getAssociations() {
        return associations;
    }

    public void setAssociations(ShopAssociations[] associations) {
        this.associations = associations;
    }

    public GetShopMethod withAssociations(ShopAssociations[] associations) {
        this.associations = associations;
        return this;
    }
}
