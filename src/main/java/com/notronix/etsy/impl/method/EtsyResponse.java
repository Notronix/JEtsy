package com.notronix.etsy.impl.method;

import com.notronix.etsy.api.method.Response;

import java.util.Map;

public class EtsyResponse<T> implements Response<T>
{
    private Integer count;
    private T results;
    private Map<String, String> params;
    private String type;
    private PaginationImpl pagination;

    @Override
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public PaginationImpl getPagination() {
        return pagination;
    }

    public void setPagination(PaginationImpl pagination) {
        this.pagination = pagination;
    }
}
