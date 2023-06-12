package com.notronix.etsy.impl;

import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.common.method.Method;

public abstract class AbstractEtsyMethod<B> implements Method<B, HttpContent>
{
    private static final String API_URL_BASE = "https://api.etsy.com/v3";

    protected abstract String getURI();

    @Override
    public String getRequestMethod() {
        return HttpMethods.GET;
    }

    @Override
    public HttpContent buildRequestContent(Marshaller marshaller) {
        return new EmptyContent();
    }

    @Override
    public final String getURL() {
        return API_URL_BASE + getURI();
    }
}
