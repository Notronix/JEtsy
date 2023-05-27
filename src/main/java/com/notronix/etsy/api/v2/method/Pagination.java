package com.notronix.etsy.api.v2.method;

public interface Pagination
{
    Integer getEffectiveLimit();
    Integer getEffectiveOffset();
    Integer getNextOffset();
}
