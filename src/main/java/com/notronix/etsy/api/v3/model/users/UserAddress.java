package com.notronix.etsy.api.v3.model.users;

public interface UserAddress
{
    Long getUserAddressId();
    Long getUserId();
    String getName();
    String getFirstLine();
    String getSecondLine();
    String getCity();
    String getState();
    String getZip();
    String getIsoCountryCode();
    String getCountryName();
    Boolean isDefaultShippingAddress();
}
