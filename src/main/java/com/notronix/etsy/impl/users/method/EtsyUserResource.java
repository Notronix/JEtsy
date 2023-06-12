package com.notronix.etsy.impl.users.method;

import com.google.api.client.http.HttpContent;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.users.method.*;

public class EtsyUserResource implements UserResource<HttpContent>
{
    @Override
    public GetMeMethod<HttpContent> createGetMeMethod(AccessToken accessToken) {
        return new EtsyGetMeMethod().withAccessToken(accessToken);
    }

    @Override
    public GetUserAddressesMethod<HttpContent> createGetUserAddressesMethod(AccessToken accessToken) {
        return new EtsyGetUserAddressesMethod().withAccessToken(accessToken);
    }

    @Override
    public GetUserAddressMethod<HttpContent> createGetUserAddressMethod(AccessToken accessToken) {
        return new EtsyGetUserAddressMethod().withAccessToken(accessToken);
    }

    @Override
    public GetUserMethod<HttpContent> createGetUserMethod(AccessToken accessToken) {
        return new EtsyGetUserMethod().withAccessToken(accessToken);
    }
}
