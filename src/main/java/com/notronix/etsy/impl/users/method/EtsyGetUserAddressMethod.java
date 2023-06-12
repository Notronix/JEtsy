package com.notronix.etsy.impl.users.method;

import com.google.api.client.http.HttpContent;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.common.method.OAuthMethod;
import com.notronix.etsy.api.users.method.GetUserAddressMethod;
import com.notronix.etsy.api.users.model.UserAddress;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.users.model.EtsyUserAddress;

import static java.util.Objects.requireNonNull;

public class EtsyGetUserAddressMethod extends AbstractEtsyMethod<UserAddress>
    implements GetUserAddressMethod<HttpContent>, OAuthMethod
{
    private AccessToken accessToken;
    private Long userAddressId;

    @Override
    public EtsyUserAddress buildResponseBody(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, EtsyUserAddress.class);
    }

    @Override
    protected String getURI() {
        return "/application/user/addresses/" + requireNonNull(userAddressId);
    }

    @Override
    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public EtsyGetUserAddressMethod withAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public Long getUserAddressId() {
        return userAddressId;
    }

    @Override
    public void setUserAddressId(Long userAddressId) {
        this.userAddressId = userAddressId;
    }

    public EtsyGetUserAddressMethod withUserAddressId(Long userAddressId) {
        this.userAddressId = userAddressId;
        return this;
    }
}
