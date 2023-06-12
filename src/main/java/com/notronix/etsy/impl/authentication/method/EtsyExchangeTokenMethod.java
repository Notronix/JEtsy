package com.notronix.etsy.impl.authentication.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.notronix.etsy.api.AppKey;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.method.ExchangeTokenMethod;
import com.notronix.etsy.api.authentication.method.GrantType;
import com.notronix.etsy.api.authentication.model.LegacyToken;
import com.notronix.etsy.api.authentication.model.TokenResponse;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.authentication.model.EtsyTokenResponse;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class EtsyExchangeTokenMethod extends AbstractEtsyMethod<TokenResponse> implements ExchangeTokenMethod<HttpContent>
{
    private AppKey appKey;
    private LegacyToken legacyToken;

    @Override
    public EtsyTokenResponse buildResponseBody(Unmarshaller unmarshaller, String payload) {
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
    public HttpContent buildRequestContent(Marshaller marshaller) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("grant_type", GrantType.token_exchange.name());
        parameters.put("client_id", requireNonNull(getAppKey().getValue()));
        parameters.put("legacy_token", requireNonNull(legacyToken.getValue()));

        return new UrlEncodedContent(parameters);
    }

    public AppKey getAppKey() {
        return appKey;
    }

    @Override
    public void setAppKey(AppKey appKey) {
        this.appKey = appKey;
    }

    public EtsyExchangeTokenMethod withAppKey(AppKey appKey) {
        this.appKey = appKey;
        return this;
    }

    public LegacyToken getLegacyToken() {
        return legacyToken;
    }

    @Override
    public void setLegacyToken(LegacyToken legacyToken) {
        this.legacyToken = legacyToken;
    }

    public EtsyExchangeTokenMethod withLegacyToken(LegacyToken legacyToken) {
        this.legacyToken = legacyToken;
        return this;
    }
}
