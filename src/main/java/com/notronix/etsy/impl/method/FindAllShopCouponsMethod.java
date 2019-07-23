package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.impl.model.EtsyCoupon;

import java.util.List;

public class FindAllShopCouponsMethod extends AbstractEtsyMethod<List<EtsyCoupon>>
{
    private Long shopId;

    @Override
    String getURI() {
        return "/shops/" + shopId + "/coupons";
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

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public FindAllShopCouponsMethod withShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }
}
