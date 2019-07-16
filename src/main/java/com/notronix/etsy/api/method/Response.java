package com.notronix.etsy.api.method;

import java.util.Map;

public interface Response<T>
{
    Integer getCount();
    T getResults();
    Map<String, String> getParams();
    String getType();
    Pagination getPagination();
}
