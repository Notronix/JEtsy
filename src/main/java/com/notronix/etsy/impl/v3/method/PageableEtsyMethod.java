package com.notronix.etsy.impl.v3.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.UrlEncodedContent;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.v3.PageableResponse;

import java.util.HashMap;
import java.util.Map;

import static com.notronix.albacore.ContainerUtils.thereAreNo;
import static com.notronix.etsy.impl.EtsyMethodUtils.putIfProvided;

public abstract class PageableEtsyMethod<R> extends EtsyMethod<PageableResponse<R>>
{
    private Integer limit;
    private Integer offset;

    public PageableEtsyMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    public PageableEtsyMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public HttpContent getContent(Marshaller marshaller) throws IllegalArgumentException {
        Map<String, Object> parameters = new HashMap<>();
        putIfProvided(parameters, "limit", limit, l -> l == null || (l >= 1 && l <= 100), true);
        putIfProvided(parameters, "offset", offset, o -> o == null || o >= 0, true);

        return thereAreNo(parameters) ? super.getContent(marshaller) : new UrlEncodedContent(parameters);
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public PageableEtsyMethod<R> withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public PageableEtsyMethod<R> withOffset(Integer offset) {
        this.offset = offset;
        return this;
    }
}
