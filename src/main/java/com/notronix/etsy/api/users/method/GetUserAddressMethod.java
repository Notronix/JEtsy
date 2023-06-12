package com.notronix.etsy.api.users.method;

import com.notronix.etsy.api.common.method.EtsyParameter;
import com.notronix.etsy.api.common.method.Method;
import com.notronix.etsy.api.common.method.ParameterPosition;
import com.notronix.etsy.api.users.model.UserAddress;

public interface GetUserAddressMethod<C> extends Method<UserAddress, C>
{
    @EtsyParameter(nullable = false, position = ParameterPosition.PATH)
    void setUserAddressId(Long userAddressId);
}
