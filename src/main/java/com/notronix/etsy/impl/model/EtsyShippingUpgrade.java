package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.ShippingUpgrade;

public class EtsyShippingUpgrade implements ShippingUpgrade
{
    @SerializedName(value = "shipping_profile_id")
    private Long shippingProfileId;

    @SerializedName(value = "value_id")
    private Long valueId;
    private String value;
    private Float price;

    @SerializedName(value = "secondary_price")
    private Float secondaryPrice;

    @SerializedName(value = "currency_code")
    private String currencyCode;

    private Integer type;
    private Integer order;
    private Integer language;

    @Override
    public Long getShippingProfileId() {
        return shippingProfileId;
    }

    public void setShippingProfileId(Long shippingProfileId) {
        this.shippingProfileId = shippingProfileId;
    }

    @Override
    public Long getValueId() {
        return valueId;
    }

    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public Float getSecondaryPrice() {
        return secondaryPrice;
    }

    public void setSecondaryPrice(Float secondaryPrice) {
        this.secondaryPrice = secondaryPrice;
    }

    @Override
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }
}
