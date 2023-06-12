package com.notronix.etsy.api.users.method;

import com.notronix.etsy.api.Resource;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.users.method.GetMeMethod;

public interface UserResource<C> extends Resource
{
    GetMeMethod<C> createGetMeMethod(AccessToken accessToken);

    GetUserAddressesMethod<C> createGetUserAddressesMethod(AccessToken accessToken);

    GetUserAddressMethod<C> createGetUserAddressMethod(AccessToken accessToken);

    GetUserMethod<C> createGetUserMethod(AccessToken accessToken);
}
