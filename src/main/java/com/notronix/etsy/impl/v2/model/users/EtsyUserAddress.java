package com.notronix.etsy.impl.v2.model.users;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.v2.model.users.UserAddress;

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

    @SerializedName("country_id")
    private Long countryId;

    @SerializedName("country_name")
    private String countryName;

    @SerializedName("is_default_shipping")
    private Boolean defaultShipping;

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
    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    @Override
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public Boolean getDefaultShipping() {
        return defaultShipping;
    }

    public void setDefaultShipping(Boolean defaultShipping) {
        this.defaultShipping = defaultShipping;
    }
}
