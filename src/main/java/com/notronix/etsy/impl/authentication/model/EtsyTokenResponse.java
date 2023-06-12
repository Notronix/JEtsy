package com.notronix.etsy.impl.authentication.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.authentication.model.RefreshToken;
import com.notronix.etsy.api.authentication.model.TokenResponse;

public class EtsyTokenResponse implements TokenResponse
{
    private String access_token;
    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private Long expiresIn;

    private String refresh_token;

    @Override
    public AccessToken getAccessToken() {
        return AccessToken.forToken(access_token);
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    @Override
    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @Override
    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public RefreshToken getRefreshToken() {
        return RefreshToken.forToken(refresh_token);
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}
