package com.notronix.etsy.api.authentication.method;

import com.notronix.etsy.api.AppKey;
import com.notronix.etsy.api.common.method.Method;
import com.notronix.etsy.api.authentication.model.RefreshToken;
import com.notronix.etsy.api.authentication.model.TokenResponse;

public interface RefreshTokenMethod<Content> extends Method<TokenResponse, Content>
{
    void setAppKey(AppKey appKey);
    void setRefreshToken(RefreshToken refreshToken);
}
