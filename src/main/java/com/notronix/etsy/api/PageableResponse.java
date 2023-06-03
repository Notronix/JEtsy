package com.notronix.etsy.api;

import java.util.List;

public interface PageableResponse<T>
{
    Long getCount();

    List<T> getResults();
}
