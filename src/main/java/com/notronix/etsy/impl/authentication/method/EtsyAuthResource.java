package com.notronix.etsy.impl.authentication.method;

import com.google.api.client.http.HttpContent;
import com.notronix.etsy.api.AppKey;
import com.notronix.etsy.api.authentication.method.*;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.authentication.model.LegacyToken;
import com.notronix.etsy.api.authentication.model.RefreshToken;

public class EtsyAuthResource implements AuthResource<HttpContent>
{
    @Override
    public PingMethod<HttpContent> createPingMethod() {
        return new EtsyPingMethod();
    }

    @Override
    public RefreshTokenMethod<HttpContent> createRefreshTokenMethod(AppKey appKey, RefreshToken refreshToken) {
        return new EtsyRefreshTokenMethod().withAppKey(appKey).withRefreshToken(refreshToken);
    }

    @Override
    public ExchangeTokenMethod<HttpContent> createExchangeTokenMethod(AppKey appKey, LegacyToken legacyToken) {
        return new EtsyExchangeTokenMethod().withAppKey(appKey).withLegacyToken(legacyToken);
    }

    @Override
    public TokenScopesMethod<HttpContent> createTokenScopesMethod(AccessToken accessToken) {
        return new EtsyTokenScopesMethod().withToken(accessToken);
    }
}
