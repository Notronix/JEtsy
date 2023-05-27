package com.notronix.etsy.impl.v2.method.authentication;

import com.google.api.client.auth.oauth.OAuthParameters;

public class EtsyOAuthTempCredentialsRequest extends EtsyOAuthTokenRequest
{
    private String callback;

    public EtsyOAuthTempCredentialsRequest(String serviceURL) {
        super(serviceURL);
    }

    @Override
    public OAuthParameters createParameters() {
        OAuthParameters oAuthParameters = super.createParameters();
        oAuthParameters.callback = callback;

        return oAuthParameters;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }
}
