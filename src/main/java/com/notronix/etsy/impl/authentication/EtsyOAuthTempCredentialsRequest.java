package com.notronix.etsy.impl.authentication;

import com.google.api.client.auth.oauth.OAuthParameters;

public class EtsyOAuthTempCredentialsRequest extends EtsyOAuthTokenRequest
{
    private String callback;

    public EtsyOAuthTempCredentialsRequest(String serviceURL) {
        super(serviceURL);
    }

    @Override
    public OAuthParameters createParameters() {
        OAuthParameters result = super.createParameters();
        result.callback = callback;

        return result;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }
}
