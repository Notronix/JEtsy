package com.notronix.etsy.impl.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.gson.Gson;
import com.notronix.etsy.api.authentication.Credentials;

import java.util.Collection;
import java.util.Map;

import static com.notronix.albacore.ContainerUtils.thereAreNo;
import static org.apache.commons.lang3.StringUtils.isBlank;

public abstract class AbstractEtsyMethod<Result> implements EtsyMethod<Result>
{
    private static final String API_URL_BASE = "https://openapi.etsy.com/v2";

    private Credentials clientCredentials;
    private Credentials accessCredentials;

    abstract String getURI(String apiKey);

    @Override
    public final String getURL(String apiKey) {
        return API_URL_BASE + getURI(apiKey);
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.GET;
    }

    @Override
    public boolean requiresOAuth() {
        return false;
    }

    @Override
    public HttpContent getContent(Gson gson) {
        return null;
    }

    @Override
    public Credentials getClientCredentials() {
        return clientCredentials;
    }

    public AbstractEtsyMethod<Result> withClientCredentials(Credentials clientCredentials) {
        this.clientCredentials = clientCredentials;
        return this;
    }

    public void setClientCredentials(Credentials clientCredentials) {
        this.clientCredentials = clientCredentials;
    }

    @Override
    public Credentials getAccessCredentials() {
        return accessCredentials;
    }

    public void setAccessCredentials(Credentials accessCredentials) {
        this.accessCredentials = accessCredentials;
    }

    public AbstractEtsyMethod<Result> withAccessCredentials(Credentials accessCredentials) {
        this.accessCredentials = accessCredentials;
        return this;
    }

    void putIfProvided(Map<String, Object> parameters, String key, Object value) {
        if (value == null) {
            return;
        }

        if (value instanceof CharSequence && isBlank((CharSequence) value)) {
            return;
        }

        if ((value instanceof Collection) && thereAreNo((Collection<?>) value)) {
            return;
        }

        if (value instanceof Map && thereAreNo((Map<?, ?>) value)) {
            return;
        }

        parameters.put(key, value);
    }
}
