package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.model.ShopAssociations;
import com.notronix.etsy.impl.model.EtsyShop;

import java.util.List;

import static com.notronix.etsy.impl.method.MethodUtils.addIfProvided;
import static com.notronix.etsy.impl.method.MethodUtils.safeList;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.joining;

public class GetShopMethod extends AbstractEtsyMethod<List<EtsyShop>>
{
    private List<String> shopIdsOrNames;
    private ShopAssociations[] associations;

    @Override
    String getURI() {
        String uri = "/shops/" + requireNonNull(shopIdsOrNames).stream().distinct().collect(joining(","));
        uri = addIfProvided(uri, "includes", safeList(associations), ASSOCIATIONS_CONVERTER);

        return uri;
    }

    @Override
    public List<EtsyShop> getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyShop>> response
                = gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyShop>>>(){}.getType());

        return response.getResults();
    }

    public List<String> getShopIdsOrNames() {
        return shopIdsOrNames;
    }

    public void setShopIdsOrNames(List<String> shopIdsOrNames) {
        this.shopIdsOrNames = shopIdsOrNames;
    }

    public GetShopMethod withShopIdsOrNames(List<String> shopIdsOrNames) {
        this.shopIdsOrNames = shopIdsOrNames;
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
