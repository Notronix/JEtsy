package com.notronix.etsy.api.v2.model.listings;

public interface ShippingUpgrade
{
    Long getShippingProfileId();
    Long getValueId();
    String getValue();
    Float getPrice();
    Float getSecondaryPrice();
    String getCurrencyCode();
    Integer getType();
    Integer getOrder();
    Integer getLanguage();
}
