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
    public EtsyPingMethod createPingMethod() {
        return new EtsyPingMethod();
    }

    @Override
    public EtsyRefreshTokenMethod createRefreshTokenMethod(AppKey appKey, RefreshToken refreshToken) {
        return new EtsyRefreshTokenMethod().withAppKey(appKey).withRefreshToken(refreshToken);
    }

    @Override
    public EtsyExchangeTokenMethod createExchangeTokenMethod(AppKey appKey, LegacyToken legacyToken) {
        return new EtsyExchangeTokenMethod().withAppKey(appKey).withLegacyToken(legacyToken);
    }

    @Override
    public EtsyTokenScopesMethod createTokenScopesMethod(AccessToken accessToken) {
        return new EtsyTokenScopesMethod().withToken(accessToken);
    }
}
