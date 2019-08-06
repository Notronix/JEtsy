package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.impl.model.EtsyCoupon;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class FindAllShopCouponsMethod extends AbstractEtsyMethod<List<EtsyCoupon>>
{
    private String shopIdOrName;

    @Override
    String getURI() {
        return "/shops/" + requireNonNull(shopIdOrName) + "/coupons";
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public List<EtsyCoupon> getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyCoupon>> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyCoupon>>>(){}.getType());

        return response.getResults();
    }

    public String getShopIdOrName() {
        return shopIdOrName;
    }

    public void setShopIdOrName(String shopIdOrName) {
        this.shopIdOrName = shopIdOrName;
    }

    public FindAllShopCouponsMethod withShopIdOrName(String shopIdOrName) {
        this.shopIdOrName = shopIdOrName;
        return this;
    }
}
