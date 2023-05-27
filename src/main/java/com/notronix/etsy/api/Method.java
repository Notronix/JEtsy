package com.notronix.etsy.api;

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
