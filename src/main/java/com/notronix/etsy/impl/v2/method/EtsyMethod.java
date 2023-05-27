package com.notronix.etsy.impl.v2.method;

import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.impl.AbstractEtsyMethod;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static com.notronix.albacore.ContainerUtils.thereAreOneOrMore;
import static com.notronix.etsy.impl.EtsyMethodUtils.addIfProvided;
import static com.notronix.etsy.impl.EtsyMethodUtils.safeList;
import static java.util.stream.Collectors.toSet;
import static org.apache.commons.lang3.StringUtils.join;

public abstract class EtsyMethod<Response> extends AbstractEtsyMethod<Response>
{
    private static final String API_URL_BASE = "https://openapi.etsy.com/v2";

    protected static final Function<List<Enum<?>>, String> ASSOCIATIONS_CONVERTER = list -> {
        Set<String> includes = list.stream().map(Enum::name).collect(toSet());
        return thereAreOneOrMore(includes) ? join(includes, ",") : "";
    };

    public EtsyMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    public EtsyMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    protected String addAssociations(String uri, Enum<?>[] associations) {
        return addIfProvided(uri, "includes", safeList(associations), ASSOCIATIONS_CONVERTER);
    }

    @Override
    public final String getURL() {
        return API_URL_BASE + getURI();
    }
}
