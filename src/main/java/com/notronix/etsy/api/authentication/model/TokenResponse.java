package com.notronix.etsy.api.authentication.model;

public interface TokenResponse
{
    String getAccessToken();
    String getTokenType();
    Long getExpiresIn();
    String getRefreshToken();
}
