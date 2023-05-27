package com.notronix.etsy.api.v3.model.authentication;

public interface TokenResponse
{
    String getAccessToken();
    String getTokenType();
    Long getExpiresIn();
    String getRefreshToken();
}
