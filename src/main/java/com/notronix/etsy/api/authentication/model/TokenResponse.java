package com.notronix.etsy.api.authentication.model;

public interface TokenResponse
{
    AccessToken getAccessToken();
    String getTokenType();
    Long getExpiresIn();
    RefreshToken getRefreshToken();
}
