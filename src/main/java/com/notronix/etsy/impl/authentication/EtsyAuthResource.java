package com.notronix.etsy.impl.authentication;

import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.authentication.AuthResource;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.authentication.model.EtsyScope;
import com.notronix.etsy.impl.EtsyResource;
import com.notronix.etsy.impl.authentication.method.ExchangeTokenMethod;
import com.notronix.etsy.impl.authentication.method.PingMethod;
import com.notronix.etsy.impl.authentication.method.RefreshTokenMethod;
import com.notronix.etsy.impl.authentication.method.TokenScopesMethod;
import com.notronix.etsy.impl.authentication.model.EtsyTokenResponse;
import com.notronix.etsy.impl.EtsyMethodExecutor;

import java.util.List;

public class EtsyAuthResource extends EtsyResource implements AuthResource
{
    public EtsyAuthResource(EtsyMethodExecutor executor, Credentials clientCredentials) {
        super(executor, clientCredentials);
    }

    @Override
    public Long ping() throws EtsyException {
        return getExecutor().execute(new PingMethod(getClientCredentials()));
    }

    @Override
    public EtsyTokenResponse exchangeToken(String legacyToken) throws EtsyException {
        return getExecutor().execute(new ExchangeTokenMethod(getClientCredentials())
                .withLegacyToken(legacyToken));
    }

    @Override
    public EtsyTokenResponse refreshToken(String refreshToken) throws EtsyException {
        return getExecutor().execute(new RefreshTokenMethod(getClientCredentials())
                .withRefreshToken(refreshToken));
    }

    @Override
    public List<EtsyScope> getTokenScopes(String token) throws EtsyException {
        return getExecutor().execute(new TokenScopesMethod(getClientCredentials())
                .withToken(token));
    }
}
