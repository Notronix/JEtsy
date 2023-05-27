package com.notronix.etsy.impl.v3;

import com.notronix.etsy.api.v3.PageableResponse;

import java.util.List;

public class EtsyPageableResponse<T> implements PageableResponse<T>
{
    private Long count;
    private List<T> results;

    @Override
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
