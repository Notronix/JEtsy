package com.notronix.etsy.api.authentication.method;

import com.notronix.etsy.api.AppKey;
import com.notronix.etsy.api.authentication.model.TokenResponse;
import com.notronix.etsy.api.common.method.Method;

public interface GetAccessTokenMethod<C> extends Method<TokenResponse, C>
{
    void setAppKey(AppKey appKey);
    void setRedirectURI(String redirectURI);
    void setCode(String code);
    void setCodeVerifier(String codeVerifier);
}
