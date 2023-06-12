package com.notronix.etsy.impl.authentication.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.method.TokenScopesMethod;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.authentication.model.EtsyScope;
import com.notronix.etsy.impl.AbstractEtsyMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class EtsyTokenScopesMethod extends AbstractEtsyMethod<List<EtsyScope>> implements TokenScopesMethod<HttpContent>
{
    private AccessToken token;

    public List<EtsyScope> buildResponseBody(Unmarshaller unmarshaller, String payload) {
        Map<String, List<EtsyScope>> response = unmarshaller.unmarshal(payload,
                new TypeToken<HashMap<String, List<EtsyScope>>>(){}.getType());

        return response.get("scopes");
    }

    @Override
    protected String getURI() {
        return "/application/scopes";
    }

    public HttpContent buildRequestContent(Marshaller marshaller) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("token", requireNonNull(token.getValue()));

        return new UrlEncodedContent(parameters);
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.POST;
    }

    public AccessToken getToken() {
        return token;
    }

    @Override
    public void setToken(AccessToken token) {
        this.token = token;
    }

    public EtsyTokenScopesMethod withToken(AccessToken token) {
        this.token = token;
        return this;
    }
}
