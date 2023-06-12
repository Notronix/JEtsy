package com.notronix.etsy.api.authentication.method;

import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.authentication.model.EtsyScope;
import com.notronix.etsy.api.common.method.Method;

import java.util.List;

public interface TokenScopesMethod<C> extends Method<List<EtsyScope>, C>
{
    void setToken(AccessToken accessToken);
}
