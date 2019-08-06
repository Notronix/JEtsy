package com.notronix.etsy.api.method;

import java.util.Map;
import java.util.function.Consumer;

public interface Response<T>
{
    Integer getCount();
    T getResults();
    Map<String, Object> getParams();
    String getType();
    Pagination getPagination();

    Consumer<? super Method<? extends Response<T>>> getNextBuilder();

    default <M extends Method<? extends Response<T>>> M buildNextPage(M method) {
        if (getNextBuilder() != null) {
            getNextBuilder().accept(method);
        }

        return method;
    }
}
