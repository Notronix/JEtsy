package com.notronix.etsy.api.model;

public interface ShippingOption
{
    String getOptionId();
    String getName();
    Integer getOptionType();
    String getCost();
    String getCurrencyCode();
}
