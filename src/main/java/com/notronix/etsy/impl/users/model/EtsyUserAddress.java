package com.notronix.etsy.impl.users.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.users.model.UserAddress;

public class EtsyUserAddress implements UserAddress
{
    @SerializedName("user_address_id")
    private Long userAddressId;

    @SerializedName("user_id")
    private Long userId;
    private String name;

    @SerializedName("first_line")
    private String firstLine;

    @SerializedName("second_line")
    private String secondLine;
    private String city;
    private String state;
    private String zip;

    @SerializedName("iso_country_code")
    private String isoCountryCode;

    @SerializedName("country_name")
    private String countryName;

    @SerializedName("is_default_shipping_address")
    private Boolean isDefaultShippingAddress;

    @Override
    public Long getUserAddressId() {
        return userAddressId;
    }

    public void setUserAddressId(Long userAddressId) {
        this.userAddressId = userAddressId;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    @Override
    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    @Override
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String getIsoCountryCode() {
        return isoCountryCode;
    }

    public void setIsoCountryCode(String isoCountryCode) {
        this.isoCountryCode = isoCountryCode;
    }

    @Override
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Boolean getDefaultShippingAddress() {
        return isDefaultShippingAddress;
    }

    @Override
    public Boolean isDefaultShippingAddress() {
        return isDefaultShippingAddress;
    }

    public void setDefaultShippingAddress(Boolean defaultShippingAddress) {
        isDefaultShippingAddress = defaultShippingAddress;
    }
}
