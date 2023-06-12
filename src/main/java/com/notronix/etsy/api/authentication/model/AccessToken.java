package com.notronix.etsy.api.authentication.model;

public interface AccessToken extends Credential
{
    static AccessToken forToken(final String token) {
        return () -> token;
    }
}
