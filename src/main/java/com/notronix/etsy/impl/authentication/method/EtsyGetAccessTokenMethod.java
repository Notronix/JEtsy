package com.notronix.etsy.impl.authentication.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.notronix.etsy.api.AppKey;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.method.GetAccessTokenMethod;
import com.notronix.etsy.api.authentication.method.GrantType;
import com.notronix.etsy.api.authentication.model.TokenResponse;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.authentication.model.EtsyTokenResponse;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class EtsyGetAccessTokenMethod extends AbstractEtsyMethod<TokenResponse>
        implements GetAccessTokenMethod<HttpContent>
{
    private AppKey appKey;
    private String redirectURI;
    private String code;
    private String codeVerifier;

    @Override
    public EtsyTokenResponse buildResponseBody(Unmarshaller unmarshaller, String payload) {
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
    public HttpContent buildRequestContent(Marshaller marshaller) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("grant_type", GrantType.authorization_code.name());
        parameters.put("client_id", requireNonNull(appKey.getValue()));
        parameters.put("redirect_uri", requireNonNull(redirectURI));
        parameters.put("code", requireNonNull(code));
        parameters.put("code_verifier", requireNonNull(codeVerifier));

        return new UrlEncodedContent(parameters);
    }

    public AppKey getAppKey() {
        return appKey;
    }

    @Override
    public void setAppKey(AppKey appKey) {
        this.appKey = appKey;
    }

    public EtsyGetAccessTokenMethod withAppKey(AppKey appKey) {
        this.appKey = appKey;
        return this;
    }

    public String getRedirectURI() {
        return redirectURI;
    }

    @Override
    public void setRedirectURI(String redirectURI) {
        this.redirectURI = redirectURI;
    }

    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeVerifier() {
        return codeVerifier;
    }

    @Override
    public void setCodeVerifier(String codeVerifier) {
        this.codeVerifier = codeVerifier;
    }
}
