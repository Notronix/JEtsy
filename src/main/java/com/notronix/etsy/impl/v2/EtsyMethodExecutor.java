package com.notronix.etsy.impl.v2;

import com.google.api.client.auth.oauth.OAuthHmacSigner;
import com.google.api.client.auth.oauth.OAuthParameters;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.util.Data;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.AbstractEtsyMethodExecutor;

import java.util.Map;

import static com.notronix.etsy.impl.EtsyMethodUtils.addIfProvided;
import static java.util.Objects.nonNull;
import static java.util.Optional.ofNullable;

public class EtsyMethodExecutor extends AbstractEtsyMethodExecutor
{
    public EtsyMethodExecutor(Marshaller marshaller, Unmarshaller unmarshaller) {
        super(marshaller, unmarshaller);
    }

    @Override
    protected GenericUrl conditionUrl(String baseUrl, Credentials clientCreds, Credentials accessCreds) {
        baseUrl = addIfProvided(baseUrl, "api_key", nonNull(accessCreds) ? null : clientCreds.getToken());

        return new GenericUrl(baseUrl);
    }

    @Override
    protected HttpRequest buildRequest(String method, GenericUrl url, HttpContent content, Credentials clientCreds)
            throws EtsyException {
        try {
            return getRequestFactory().buildRequest(method, url, content);
        }
        catch (Exception ex) {
            throw new EtsyException("An error occurred trying to build request.", ex);
        }
    }

    @Override
    protected void handleAccess(HttpRequest request, HttpContent content, GenericUrl url, Credentials clientCreds, Credentials accessCreds)
        throws EtsyException {
        OAuthHmacSigner signer = new OAuthHmacSigner();
        signer.clientSharedSecret = clientCreds.getTokenSecret();
        signer.tokenSharedSecret = accessCreds.getTokenSecret();

        OAuthParameters parameters = new OAuthParameters();
        parameters.consumerKey = clientCreds.getToken();
        parameters.signer = signer;
        parameters.token = accessCreds.getToken();

        Map<String, Object> urlEncodedParams = null;

        if (content instanceof UrlEncodedContent) {
            urlEncodedParams = Data.mapOf(((UrlEncodedContent) content).getData());
            url.putAll(urlEncodedParams);
        }

        try {
            parameters.intercept(request);
            ofNullable(urlEncodedParams)
                    .ifPresent(contentParams -> contentParams.forEach((key, value) -> url.remove(key)));
        }
        catch (Exception e) {
            EtsyException ex = new EtsyException("An error occurred computing method signature", e);
            ex.initCause(e);
            throw ex;
        }
    }
}
