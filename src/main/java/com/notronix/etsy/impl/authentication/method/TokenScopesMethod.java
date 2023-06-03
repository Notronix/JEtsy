package com.notronix.etsy.impl.authentication.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.EtsyScope;
import com.notronix.etsy.impl.EtsyMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class TokenScopesMethod extends EtsyMethod<List<EtsyScope>>
{
    private String token;

    public TokenScopesMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    public List<EtsyScope> getResponse(Unmarshaller unmarshaller, String payload) {
        Map<String, List<EtsyScope>> response = unmarshaller.unmarshal(payload,
                new TypeToken<HashMap<String, List<EtsyScope>>>(){}.getType());

        return response.get("scopes");
    }

    @Override
    protected String getURI() {
        return "/application/scopes";
    }

    @Override
    public HttpContent getContent(Marshaller marshaller) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("token", requireNonNull(token));

        return new UrlEncodedContent(parameters);
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.POST;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TokenScopesMethod withToken(String token) {
        this.token = token;
        return this;
    }
}
