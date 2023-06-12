package com.notronix.etsy.api.authentication.model;

public interface LegacyToken extends Credential
{
    static LegacyToken forToken(final String token) {
        return () -> token;
    }
}
