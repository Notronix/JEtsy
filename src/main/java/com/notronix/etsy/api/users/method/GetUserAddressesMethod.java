package com.notronix.etsy.api.users.method;

import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.common.method.Method;
import com.notronix.etsy.api.users.model.UserAddress;

public interface GetUserAddressesMethod<C> extends Method<PageableResponse<UserAddress>, C>
{
}
