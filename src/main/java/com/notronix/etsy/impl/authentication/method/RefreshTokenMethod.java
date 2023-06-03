package com.notronix.etsy.impl.authentication.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.EtsyMethod;
import com.notronix.etsy.impl.authentication.model.EtsyTokenResponse;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class RefreshTokenMethod extends EtsyMethod<EtsyTokenResponse>
{
    private String refreshToken;

    public RefreshTokenMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    public EtsyTokenResponse getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, EtsyTokenResponse.class);
    }

    @Override
    protected String getURI() {
        return "/public/oauth/token";
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.POST;
    }

    @Override
    public HttpContent getContent(Marshaller marshaller) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("grant_type", "refresh_token");
        parameters.put("client_id", requireNonNull(getClientCredentials().getToken()));
        parameters.put("refresh_token", requireNonNull(refreshToken));

        return new UrlEncodedContent(parameters);
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public RefreshTokenMethod withRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }
}
