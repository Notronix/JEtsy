package com.notronix.etsy.api.common.method;

import java.util.function.Predicate;

import static com.notronix.etsy.api.MethodUtils.addIfProvided;

public interface PageableMethod
{
    Integer getOffset();

    @EtsyParameter(position = ParameterPosition.QUERY)
    void setOffset(Integer offset);

    Integer getLimit();

    @EtsyParameter(position = ParameterPosition.QUERY)
    void setLimit(Integer limit);

    Predicate<Integer> OFFSET_VALIDATOR = offset -> offset == null || offset >= 0;
    Predicate<Integer> LIMIT_VALIDATOR = limit -> limit == null || (limit >= 1 && limit <= 100);

    default String addPageableParameters(String uri, PageableMethod method, boolean throwWhenInvalid)
            throws IllegalArgumentException {
        String baseUri = addIfProvided(uri, "offset", method.getOffset(), OFFSET_VALIDATOR, throwWhenInvalid);
        baseUri = addIfProvided(baseUri, "limit", method.getLimit(), LIMIT_VALIDATOR, throwWhenInvalid);

        return baseUri;
    }
}
