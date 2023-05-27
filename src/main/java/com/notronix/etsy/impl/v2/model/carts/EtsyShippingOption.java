package com.notronix.etsy.impl.v2.model.carts;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.v2.model.carts.ShippingOption;

public class EtsyShippingOption implements ShippingOption
{
    @SerializedName("option_id")
    private String optionId;
    private String name;

    @SerializedName("option_type")
    private Integer optionType;
    private String cost;

    @SerializedName("currency_code")
    private String currencyCode;

    @Override
    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getOptionType() {
        return optionType;
    }

    public void setOptionType(Integer optionType) {
        this.optionType = optionType;
    }

    @Override
    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
