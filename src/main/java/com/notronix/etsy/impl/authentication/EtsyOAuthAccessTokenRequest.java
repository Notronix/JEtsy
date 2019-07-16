package com.notronix.etsy.impl.authentication;

import com.google.api.client.auth.oauth.OAuthParameters;

public class EtsyOAuthAccessTokenRequest extends EtsyOAuthTokenRequest
{
    private String temporaryToken;
    private String verifier;

    public EtsyOAuthAccessTokenRequest(String serviceURL) {
        super(serviceURL);
    }

    @Override
    public OAuthParameters createParameters() {
        OAuthParameters result = super.createParameters();
        result.token = temporaryToken;
        result.verifier = verifier;

        return result;
    }

    public String getTemporaryToken() {
        return temporaryToken;
    }

    public void setTemporaryToken(String temporaryToken) {
        this.temporaryToken = temporaryToken;
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }
}
