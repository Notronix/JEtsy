package com.notronix.etsy.impl.authentication.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.notronix.etsy.api.AppKey;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.method.GrantType;
import com.notronix.etsy.api.authentication.method.RefreshTokenMethod;
import com.notronix.etsy.api.authentication.model.RefreshToken;
import com.notronix.etsy.api.authentication.model.TokenResponse;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.authentication.model.EtsyTokenResponse;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class EtsyRefreshTokenMethod extends AbstractEtsyMethod<TokenResponse> implements RefreshTokenMethod<HttpContent>
{
    private AppKey appKey;
    private RefreshToken refreshToken;

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
        parameters.put("grant_type", GrantType.refresh_token.name());
        parameters.put("client_id", requireNonNull(appKey.getValue()));
        parameters.put("refresh_token", requireNonNull(refreshToken.getValue()));

        return new UrlEncodedContent(parameters);
    }

    public AppKey getAppKey() {
        return appKey;
    }

    @Override
    public void setAppKey(AppKey appKey) {
        this.appKey = appKey;
    }

    public EtsyRefreshTokenMethod withAppKey(AppKey appKey) {
        this.appKey = appKey;
        return this;
    }

    public RefreshToken getRefreshToken() {
        return refreshToken;
    }

    @Override
    public void setRefreshToken(RefreshToken refreshToken) {
        this.refreshToken = refreshToken;
    }

    public EtsyRefreshTokenMethod withRefreshToken(RefreshToken refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }
}
