package com.notronix.etsy.api.authentication.model;

public interface RefreshToken extends Credential
{
    static RefreshToken forToken(final String token) {
        return () -> token;
    }
}
