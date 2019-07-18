package com.notronix.etsy.impl.method;

import com.google.api.client.http.HttpContent;
import com.google.gson.Gson;
import com.notronix.etsy.api.authentication.Credentials;

public interface EtsyMethod<Result>
{
    String getURL();
    Result getResponse(Gson gson, String jsonPayload);
    Credentials getClientCredentials();
    Credentials getAccessCredentials();
    String getRequestMethod();
    boolean requiresOAuth();
    HttpContent getContent(Gson gson);
}
