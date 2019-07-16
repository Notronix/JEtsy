package com.notronix.etsy.api.method;

public interface Pagination
{
    Integer getEffectiveLimit();
    Integer getEffectiveOffset();
    Integer getNextOffset();
    Integer getEffectivePage();
    Integer getNextPage();
}
