package com.notronix.etsy.api.authentication;

import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.authentication.model.EtsyScope;
import com.notronix.etsy.api.authentication.model.TokenResponse;

import java.util.List;

public interface AuthResource
{
    Long ping() throws EtsyException;

    TokenResponse exchangeToken(String legacyToken) throws EtsyException;

    TokenResponse refreshToken(String refreshToken) throws EtsyException;

    List<EtsyScope> getTokenScopes(String token) throws EtsyException;

}
