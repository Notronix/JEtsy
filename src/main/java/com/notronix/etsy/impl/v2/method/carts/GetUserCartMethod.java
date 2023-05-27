package com.notronix.etsy.impl.v2.method.carts;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.carts.EtsyCart;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class GetUserCartMethod extends EtsyMethod<EtsyCart>
{
    private String userId;
    private Long cartId;

    public GetUserCartMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    protected String getURI() {
        return "/users/" + requireNonNull(userId) + "/carts/" + requireNonNull(cartId);
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public EtsyCart getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyResponse<List<EtsyCart>> response =
                unmarshaller.unmarshal(payload, new TypeToken<EtsyResponse<List<EtsyCart>>>(){}.getType());

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
