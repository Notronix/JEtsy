package com.notronix.etsy.api.v2.method;

import java.util.Map;

public interface Response<T>
{
    Integer getCount();
    T getResults();
    Map<String, Object> getParams();
    String getType();
    Pagination getPagination();
}
