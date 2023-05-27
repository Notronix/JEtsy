package com.notronix.etsy.impl.v2.method.shops;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.v2.model.shops.ShopAssociations;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.shops.EtsyShop;

import java.util.List;

import static com.notronix.etsy.impl.EtsyMethodUtils.addIfProvided;
import static com.notronix.etsy.impl.EtsyMethodUtils.safeList;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.joining;

public class GetShopMethod extends EtsyMethod<List<EtsyShop>>
{
    private List<String> shopIdsOrNames;
    private ShopAssociations[] associations;

    public GetShopMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    protected String getURI() {
        String uri = "/shops/" + requireNonNull(shopIdsOrNames).stream().distinct().collect(joining(","));
        uri = addIfProvided(uri, "includes", safeList(associations), ASSOCIATIONS_CONVERTER);

        return uri;
    }

    @Override
    public List<EtsyShop> getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyResponse<List<EtsyShop>> response
                = unmarshaller.unmarshal(payload, new TypeToken<EtsyResponse<List<EtsyShop>>>(){}.getType());

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
