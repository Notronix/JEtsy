package com.notronix.etsy.impl;

import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.authentication.model.Credentials;

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
