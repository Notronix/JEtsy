package com.notronix.etsy.api;

import com.notronix.etsy.api.authentication.model.Credential;

public interface AppKey extends Credential
{
    static AppKey forKeyString(final String keyString) {
        return () -> keyString;
    }
}
