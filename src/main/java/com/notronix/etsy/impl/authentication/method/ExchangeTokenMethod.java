package com.notronix.etsy.impl.authentication.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.EtsyMethod;
import com.notronix.etsy.impl.authentication.model.EtsyTokenResponse;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class ExchangeTokenMethod extends EtsyMethod<EtsyTokenResponse>
{
    private String legacyToken;

    public ExchangeTokenMethod(Credentials clientCredentials) {
        super(clientCredentials, null);
    }

    @Override
    public EtsyTokenResponse getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, EtsyTokenResponse.class);
    }

    @Override
    protected String getURI() {
        return "/public/oauth/token";
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.POST;
    }

    @Override
    public HttpContent getContent(Marshaller marshaller) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("grant_type", "token_exchange");
        parameters.put("client_id", requireNonNull(getClientCredentials().getToken()));
        parameters.put("legacy_token", requireNonNull(legacyToken));

        return new UrlEncodedContent(parameters);
    }

    public String getLegacyToken() {
        return legacyToken;
    }

    public void setLegacyToken(String legacyToken) {
        this.legacyToken = legacyToken;
    }

    public ExchangeTokenMethod withLegacyToken(String legacyToken) {
        this.legacyToken = legacyToken;
        return this;
    }
}
