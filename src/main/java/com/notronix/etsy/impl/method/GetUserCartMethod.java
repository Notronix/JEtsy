package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.impl.model.EtsyCart;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class GetUserCartMethod extends AbstractEtsyMethod<EtsyCart>
{
    private String userId;
    private Long cartId;

    @Override
    String getURI() {
        return "/users/" + requireNonNull(userId) + "/carts/" + requireNonNull(cartId);
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public EtsyCart getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyCart>> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyCart>>>(){}.getType());

        return response.getResults().stream().findAny().orElse(null);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public GetUserCartMethod withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public GetUserCartMethod withCartId(Long cartId) {
        this.cartId = cartId;
        return this;
    }
}
