package com.notronix.etsy.impl.v2.method;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.v2.method.Pagination;

public class EtsyPagination implements Pagination
{
    @SerializedName(value = "effective_limit")
    private Integer effectiveLimit;

    @SerializedName(value = "effective_offset")
    private Integer effectiveOffset;

    @SerializedName(value = "next_offset")
    private Integer nextOffset;

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
}
