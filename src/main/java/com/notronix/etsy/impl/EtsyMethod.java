package com.notronix.etsy.impl;

import com.notronix.etsy.api.authentication.model.Credentials;

public abstract class EtsyMethod<Response> extends AbstractEtsyMethod<Response>
{
    private static final String API_URL_BASE = "https://api.etsy.com/v3";

    public EtsyMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    public EtsyMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public final String getURL() {
        return API_URL_BASE + getURI();
    }
}
