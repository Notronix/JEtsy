package com.notronix.etsy.impl.users.method;

import com.google.api.client.http.HttpContent;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.common.method.OAuthMethod;
import com.notronix.etsy.api.users.method.GetUserMethod;
import com.notronix.etsy.api.users.model.User;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.users.model.EtsyUser;

import static java.util.Objects.requireNonNull;

public class EtsyGetUserMethod extends AbstractEtsyMethod<User> implements GetUserMethod<HttpContent>, OAuthMethod
{
    private AccessToken accessToken;
    private Long userId;

    public User buildResponseBody(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, EtsyUser.class);
    }

    @Override
    protected String getURI() {
        return "/application/users/" + requireNonNull(userId);
    }

    @Override
    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public EtsyGetUserMethod withAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public EtsyGetUserMethod withUserId(Long userId) {
        this.userId = userId;
        return this;
    }
}
