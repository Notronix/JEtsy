package com.notronix.etsy.impl;

import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Method;

import static java.util.Objects.requireNonNull;

public abstract class AbstractEtsyMethod<Response> implements Method<Response, HttpContent>
{
    private final Credentials clientCredentials;
    private final Credentials accessCredentials;

    protected abstract String getURI();

    public AbstractEtsyMethod(Credentials clientCredentials) {
        this(clientCredentials, null);
    }

    public AbstractEtsyMethod(Credentials clientCredentials, Credentials accessCredentials) {
        this.clientCredentials = requireNonNull(clientCredentials);
        this.accessCredentials = accessCredentials;
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.GET;
    }

    @Override
    public boolean requiresOAuth() {
        return false;
    }

    @Override
    public HttpContent getContent(Marshaller marshaller) {
        return new EmptyContent();
    }

    @Override
    public Credentials getClientCredentials() {
        return clientCredentials;
    }

    @Override
    public Credentials getAccessCredentials() {
        return accessCredentials;
    }
}
