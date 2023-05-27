package com.notronix.etsy.impl.v2.model.authentication;

import com.google.api.client.util.Key;
import com.notronix.etsy.api.Credentials;

public class EtsyOAuthCredentials implements Credentials
{
    @Key("oauth_token")
    public String token;

    @Key("oauth_token_secret")
    public String tokenSecret;

    @Key("oauth_callback_confirmed")
    public Boolean callbackConfirmed;

    @Key("login_url")
    public String loginUrl;

    @Override
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String getTokenSecret() {
        return tokenSecret;
    }

    public void setTokenSecret(String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }

    @Override
    public Boolean getCallbackConfirmed() {
        return callbackConfirmed;
    }

    public void setCallbackConfirmed(Boolean callbackConfirmed) {
        this.callbackConfirmed = callbackConfirmed;
    }

    @Override
    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
}
