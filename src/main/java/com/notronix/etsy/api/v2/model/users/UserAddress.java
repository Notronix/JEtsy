package com.notronix.etsy.api.v2.model.users;

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
    Long getCountryId();
    String getCountryName();
    Boolean getDefaultShipping();
}
