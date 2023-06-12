package com.notronix.etsy.api.users.method;

import com.notronix.etsy.api.common.method.EtsyParameter;
import com.notronix.etsy.api.common.method.Method;
import com.notronix.etsy.api.common.method.ParameterPosition;
import com.notronix.etsy.api.users.model.User;

public interface GetUserMethod<C> extends Method<User, C>
{
    @EtsyParameter(nullable = false, position = ParameterPosition.PATH)
    void setUserId(Long userId);
}
