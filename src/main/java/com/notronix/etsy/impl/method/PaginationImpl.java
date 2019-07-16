package com.notronix.etsy.impl.method;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.method.Pagination;

public class PaginationImpl implements Pagination
{
    @SerializedName(value = "effective_limit")
    private Integer effectiveLimit;

    @SerializedName(value = "effective_offset")
    private Integer effectiveOffset;

    @SerializedName(value = "next_offset")
    private Integer nextOffset;

    @SerializedName(value = "effective_page")
    private Integer effectivePage;

    @SerializedName(value = "next_page")
    private Integer nextPage;

    @Override
    public Integer getEffectiveLimit() {
        return effectiveLimit;
    }

    public void setEffectiveLimit(Integer effectiveLimit) {
        this.effectiveLimit = effectiveLimit;
    }

    @Override
    public Integer getEffectiveOffset() {
        return effectiveOffset;
    }

    public void setEffectiveOffset(Integer effectiveOffset) {
        this.effectiveOffset = effectiveOffset;
    }

    @Override
    public Integer getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(Integer nextOffset) {
        this.nextOffset = nextOffset;
    }

    @Override
    public Integer getEffectivePage() {
        return effectivePage;
    }

    public void setEffectivePage(Integer effectivePage) {
        this.effectivePage = effectivePage;
    }

    @Override
    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }
}
