package com.notronix.etsy.impl.method;

import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.gson.Gson;
import com.notronix.etsy.api.authentication.Credentials;
import com.notronix.etsy.api.method.Method;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static com.notronix.albacore.ContainerUtils.thereAreOneOrMore;
import static java.util.stream.Collectors.toSet;
import static org.apache.commons.lang3.StringUtils.join;

public abstract class AbstractEtsyMethod<Result> implements Method<Result>
{
    private static final String API_URL_BASE = "https://openapi.etsy.com/v2";

    static final Function<List<Enum>, String> ASSOCIATIONS_CONVERTER = list -> {
        Set<String> includes = list.stream().map(Enum::name).collect(toSet());
        return thereAreOneOrMore(includes) ? join(includes, ",") : "";
    };

    private Credentials clientCredentials;
    private Credentials accessCredentials;

    abstract String getURI();

    @Override
    public final String getURL() {
        return API_URL_BASE + getURI();
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
        return new EmptyContent();
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
}
