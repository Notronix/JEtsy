package com.notronix.etsy.api.v2.method;

import java.util.List;

public interface PageableResponse<T> extends Response<List<T>>
{
    default boolean hasNext() {
        Pagination pager = getPagination();
        return pager != null && pager.getNextOffset() != null
                && !pager.getNextOffset().equals(pager.getEffectiveOffset());
    }
}
