package com.notronix.etsy.api.shops.method;

import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.common.method.EtsyParameter;
import com.notronix.etsy.api.common.method.Method;
import com.notronix.etsy.api.common.method.ParameterPosition;
import com.notronix.etsy.api.shops.model.ShopSection;

public interface GetShopSectionsMethod<C> extends Method<PageableResponse<ShopSection>, C>
{
    @EtsyParameter(nullable = false, position = ParameterPosition.PATH)
    void setShopId(Long shopId);
}
