package com.notronix.etsy.api.authentication.method;

import com.notronix.etsy.api.AppKey;
import com.notronix.etsy.api.Resource;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.authentication.model.LegacyToken;
import com.notronix.etsy.api.authentication.model.OAuthConnector;
import com.notronix.etsy.api.authentication.model.RefreshToken;

public interface AuthResource<C> extends Resource
{
    OAuthConnector createOAuthConnector();

    PingMethod<C> createPingMethod();

    GetAccessTokenMethod<C> createGetAccessTokenMethod(AppKey appKey);

    RefreshTokenMethod<C> createRefreshTokenMethod(AppKey appKey, RefreshToken refreshToken);

    ExchangeTokenMethod<C> createExchangeTokenMethod(AppKey appKey, LegacyToken legacyToken);

    TokenScopesMethod<C> createTokenScopesMethod(AccessToken accessToken);
}
