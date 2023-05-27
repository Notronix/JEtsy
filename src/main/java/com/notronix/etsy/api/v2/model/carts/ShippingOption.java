package com.notronix.etsy.api.v2.model.carts;

public interface ShippingOption
{
    String getOptionId();
    String getName();
    Integer getOptionType();
    String getCost();
    String getCurrencyCode();
}
