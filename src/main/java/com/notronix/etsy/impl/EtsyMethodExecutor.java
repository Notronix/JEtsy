package com.notronix.etsy.impl;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.Credentials;

import java.util.Collections;

public class EtsyMethodExecutor extends AbstractEtsyMethodExecutor
{
    public EtsyMethodExecutor(Marshaller marshaller, Unmarshaller unmarshaller) {
        super(marshaller, unmarshaller);
    }

    @Override
    protected GenericUrl conditionUrl(String baseUrl, Credentials clientCreds, Credentials accessCreds) {
        return new GenericUrl(baseUrl);
    }

    @Override
    protected HttpRequest buildRequest(String method, GenericUrl url, HttpContent content, Credentials clientCreds)
            throws EtsyException {
        try {
            HttpRequest request = getRequestFactory().buildRequest(method, url, content);
            request.getHeaders().set("x-api-key", clientCreds.getToken());
            return request;
        }
        catch (Exception ex) {
            throw new EtsyException("An error occurred trying to build request.", ex);
        }
    }

    @Override
    protected void handleAccess(HttpRequest request, HttpContent content, GenericUrl url, Credentials clientCreds, Credentials accessCreds) {
        request.getHeaders().setAuthorization(Collections.singletonList("Bearer " + accessCreds.getToken()));
    }
}
