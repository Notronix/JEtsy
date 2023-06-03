package com.notronix.etsy.impl;

import com.notronix.etsy.api.authentication.model.Credentials;

public abstract class EtsyResource
{
    private EtsyMethodExecutor executor;
    private Credentials clientCredentials;

    public EtsyResource(EtsyMethodExecutor executor, Credentials clientCredentials) {
        this.executor = executor;
        this.clientCredentials = clientCredentials;
    }

    public EtsyMethodExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(EtsyMethodExecutor executor) {
        this.executor = executor;
    }

    public Credentials getClientCredentials() {
        return clientCredentials;
    }

    public void setClientCredentials(Credentials clientCredentials) {
        this.clientCredentials = clientCredentials;
    }
}
