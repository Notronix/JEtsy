package com.notronix.etsy.impl.v2.method;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.v2.method.Response;
import com.notronix.etsy.impl.v2.model.baseline.EtsyApiMethod;
import com.notronix.etsy.impl.v2.model.types.EtsyDataType;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class EtsyResponse<T> implements Response<T>
{
    public static Type METHODS = new TypeToken<EtsyResponse<List<EtsyApiMethod>>>(){}.getType();
    public static Type DATA_TYPES = new TypeToken<EtsyResponse<List<EtsyDataType>>>(){}.getType();

    private Integer count;
    private T results;
    private Map<String, Object> params;
    private String type;
    private EtsyPagination pagination;

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
    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
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
    public EtsyPagination getPagination() {
        return pagination;
    }

    public void setPagination(EtsyPagination pagination) {
        this.pagination = pagination;
    }
}
