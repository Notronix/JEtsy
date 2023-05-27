package com.notronix.etsy.api.v3;

import java.util.List;

public interface PageableResponse<T>
{
    Long getCount();
    List<T> getResults();
}
