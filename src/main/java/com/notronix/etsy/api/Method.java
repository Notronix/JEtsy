package com.notronix.etsy.api;

import com.notronix.etsy.api.authentication.model.Credentials;

public interface Method<Response, Content>
{
    String getURL();
    Response getResponse(Unmarshaller unmarshaller, String payload);
    Credentials getClientCredentials();
    Credentials getAccessCredentials();
    String getRequestMethod();
    boolean requiresOAuth();
    Content getContent(Marshaller marshaller);
}
