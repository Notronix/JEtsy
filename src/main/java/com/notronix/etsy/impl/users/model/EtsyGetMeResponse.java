package com.notronix.etsy.impl.users.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.users.model.GetMeResponse;

public class EtsyGetMeResponse implements GetMeResponse
{
    @SerializedName("user_id")
    private Long userId;

    @SerializedName("shop_id")
    private Long shopId;

    @Override
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
