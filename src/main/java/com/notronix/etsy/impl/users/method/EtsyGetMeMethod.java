package com.notronix.etsy.impl.users.method;

import com.google.api.client.http.HttpContent;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.common.method.OAuthMethod;
import com.notronix.etsy.api.users.method.GetMeMethod;
import com.notronix.etsy.api.users.model.GetMeResponse;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.users.model.EtsyGetMeResponse;

public class EtsyGetMeMethod extends AbstractEtsyMethod<GetMeResponse> implements GetMeMethod<HttpContent>, OAuthMethod
{
    private AccessToken accessToken;

    @Override
    public GetMeResponse buildResponseBody(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, EtsyGetMeResponse.class);
    }

    @Override
    protected String getURI() {
        return "/application/users/me";
    }

    @Override
    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public EtsyGetMeMethod withAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
        return this;
    }
}
