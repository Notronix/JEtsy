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
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toSet;
import static org.apache.commons.lang3.StringUtils.join;

public abstract class AbstractEtsyMethod<Result> implements Method<Result>
{
    private static final String API_URL_BASE = "https://openapi.etsy.com/v2";

    static final Function<List<Enum>, String> ASSOCIATIONS_CONVERTER = list -> {
        Set<String> includes = list.stream().map(Enum::name).collect(toSet());
        return thereAreOneOrMore(includes) ? join(includes, ",") : "";
    };

    private final Credentials clientCredentials;
    private final Credentials accessCredentials;

    abstract String getURI();

    public AbstractEtsyMethod(Credentials clientCredentials) {
        this(clientCredentials, null);
    }

    public AbstractEtsyMethod(Credentials clientCredentials, Credentials accessCredentials) {
        this.clientCredentials = requireNonNull(clientCredentials);
        this.accessCredentials = accessCredentials;
    }

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

    @Override
    public Credentials getAccessCredentials() {
        return accessCredentials;
    }
}
