package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.model.CartAssociations;
import com.notronix.etsy.impl.model.EtsyCart;

import java.util.List;

import static com.notronix.etsy.impl.method.MethodUtils.addIfProvided;
import static com.notronix.etsy.impl.method.MethodUtils.safeList;
import static java.util.Objects.requireNonNull;

public class GetAllUserCartsMethod extends AbstractEtsyMethod<EtsyResponse<List<EtsyCart>>>
{
    private String userId;
    private CartAssociations[] associations;

    @Override
    String getURI() {
        String uri = "/users/" + requireNonNull(userId) + "/carts";
        uri = addIfProvided(uri, "includes", safeList(associations), ASSOCIATIONS_CONVERTER);

        return uri;
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public EtsyResponse<List<EtsyCart>> getResponse(Gson gson, String jsonPayload) {
        return gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyCart>>>(){}.getType());
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public GetAllUserCartsMethod withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public CartAssociations[] getAssociations() {
        return associations;
    }

    public void setAssociations(CartAssociations[] associations) {
        this.associations = associations;
    }

    public GetAllUserCartsMethod withAssociations(CartAssociations[] associations) {
        this.associations = associations;
        return this;
    }
}
