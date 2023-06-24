package com.notronix.etsy.impl.common.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.common.model.Price;

public class EtsyPrice implements Price
{
    private static final double PRICE_ROUNDER = 100.0;

    private Integer amount;
    private Integer divisor;
    @SerializedName("currency_code")
    private String currencyCode;

    @Override
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public Integer getDivisor() {
        return divisor;
    }

    public void setDivisor(Integer divisor) {
        this.divisor = divisor;
    }

    @Override
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public Float asFloat() {
        if (amount == null || divisor == null) {
            return null;
        }

        double price = (double) amount / (double) divisor;
        double roundedPrice = (double) Math.round(price * PRICE_ROUNDER) / PRICE_ROUNDER;

        return (float) roundedPrice;
    }
}
