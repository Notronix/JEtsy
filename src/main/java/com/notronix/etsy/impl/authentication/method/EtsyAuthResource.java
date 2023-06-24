package com.notronix.etsy.impl.authentication.method;

import com.google.api.client.http.HttpContent;
import com.notronix.etsy.api.AppKey;
import com.notronix.etsy.api.authentication.method.AuthResource;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.authentication.model.LegacyToken;
import com.notronix.etsy.api.authentication.model.OAuthConnector;
import com.notronix.etsy.api.authentication.model.RefreshToken;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.SecureRandom;
import java.util.Base64;

public class EtsyAuthResource implements AuthResource<HttpContent>
{
    private static final int STATE_LENGTH = 10;
    private static final int VERIFIER_LENGTH = 32;

    @Override
    public OAuthConnector createOAuthConnector() {
        String state = buildRandomString(STATE_LENGTH);
        String verifier = buildRandomString(VERIFIER_LENGTH);
        String challenge = buildChallenge(verifier);

        return OAuthConnector.withValues(state, verifier, challenge);
    }

    @Override
    public EtsyGetAccessTokenMethod createGetAccessTokenMethod(AppKey appKey) {
        return new EtsyGetAccessTokenMethod().withAppKey(appKey);
    }

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

    private static String buildRandomString(int length) {
        byte[] bytes = new byte[length];
        new SecureRandom().nextBytes(bytes);

        return urlEncode(bytes);
    }

    private static String buildChallenge(String verifier) {
        return urlEncode(DigestUtils.sha256(verifier));
    }

    private static String urlEncode(byte[] src) {
        return Base64.getUrlEncoder().encodeToString(src).replace("=", "");
    }
}
