package com.notronix.etsy.impl.users.method;

import com.google.api.client.http.HttpContent;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.users.method.*;

public class EtsyUserResource implements UserResource<HttpContent>
{
    @Override
    public EtsyGetMeMethod createGetMeMethod(AccessToken accessToken) {
        return new EtsyGetMeMethod().withAccessToken(accessToken);
    }

    @Override
    public EtsyGetUserAddressesMethod createGetUserAddressesMethod(AccessToken accessToken) {
        return new EtsyGetUserAddressesMethod().withAccessToken(accessToken);
    }

    @Override
    public EtsyGetUserAddressMethod createGetUserAddressMethod(AccessToken accessToken) {
        return new EtsyGetUserAddressMethod().withAccessToken(accessToken);
    }

    @Override
    public EtsyGetUserMethod createGetUserMethod(AccessToken accessToken) {
        return new EtsyGetUserMethod().withAccessToken(accessToken);
    }
}
