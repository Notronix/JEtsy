package com.notronix.etsy.api.shops.method;

import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.common.method.EtsyParameter;
import com.notronix.etsy.api.common.method.Method;
import com.notronix.etsy.api.common.method.ParameterPosition;
import com.notronix.etsy.api.shops.model.ShippingProfile;

public interface GetShopShippingProfilesMethod<C> extends Method<PageableResponse<ShippingProfile>, C>
{
    @EtsyParameter(nullable = false, position = ParameterPosition.PATH)
    void setShopId(Long shopId);
}
