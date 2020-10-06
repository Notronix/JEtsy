package com.notronix.etsy.impl.authentication;

import com.google.api.client.auth.oauth.OAuthParameters;
import com.google.api.client.auth.oauth.OAuthSigner;
import com.google.api.client.http.*;

import java.io.IOException;

public abstract class EtsyOAuthTokenRequest extends GenericUrl
{
    private HttpTransport transport;
    private String consumerKey;
    private OAuthSigner signer;

    EtsyOAuthTokenRequest(String serviceURL) {
        super(serviceURL);
    }

    public EtsyOAuthCredentials execute() throws IOException {
        HttpRequestFactory requestFactory = transport.createRequestFactory();
        HttpRequest request = requestFactory.buildGetRequest(this);
        createParameters().intercept(request);
        HttpResponse response = request.execute();
        response.setContentLoggingLimit(0);
        EtsyOAuthCredentials credentials = new EtsyOAuthCredentials();

        try {
            UrlEncodedParser.parse(response.parseAsString(), credentials);
        }
        finally {
            response.disconnect();
        }

        return credentials;
    }

    public OAuthParameters createParameters() {
        OAuthParameters oAuthParameters = new OAuthParameters();
        oAuthParameters.consumerKey = consumerKey;
        oAuthParameters.signer = signer;

        return oAuthParameters;
    }

    public HttpTransport getTransport() {
        return transport;
    }

    public void setTransport(HttpTransport transport) {
        this.transport = transport;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public OAuthSigner getSigner() {
        return signer;
    }

    public void setSigner(OAuthSigner signer) {
        this.signer = signer;
    }
}
