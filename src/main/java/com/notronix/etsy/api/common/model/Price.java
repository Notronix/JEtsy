package com.notronix.etsy.api.common.model;

public interface Price
{
    Integer getAmount();

    Integer getDivisor();

    String getCurrencyCode();
}
