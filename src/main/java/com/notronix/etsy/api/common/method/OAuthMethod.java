package com.notronix.etsy.api.common.method;

import com.notronix.etsy.api.authentication.model.AccessToken;

public interface OAuthMethod
{
    AccessToken getAccessToken();
}
