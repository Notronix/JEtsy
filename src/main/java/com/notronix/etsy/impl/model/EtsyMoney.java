package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.Money;

public class EtsyMoney implements Money
{
    private Long amount;
    private Integer divisor;

    @SerializedName(value = "currency_code")
    private String currencyCode;

    @SerializedName(value = "currency_formatted_raw")
    private String currencyFormattedRaw;

    @SerializedName(value = "currency_formatted_short")
    private String currencyFormattedShort;

    @SerializedName(value = "currency_formatted_long")
    private String currencyFormattedLong;

    @SerializedName(value = "original_currency_code")
    private String originalCurrencyCode;

    @SerializedName(value = "before_conversion")
    private EtsyMoney beforeConversion;

    @Override
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
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
    public String getCurrencyFormattedRaw() {
        return currencyFormattedRaw;
    }

    public void setCurrencyFormattedRaw(String currencyFormattedRaw) {
        this.currencyFormattedRaw = currencyFormattedRaw;
    }

    @Override
    public String getCurrencyFormattedShort() {
        return currencyFormattedShort;
    }

    public void setCurrencyFormattedShort(String currencyFormattedShort) {
        this.currencyFormattedShort = currencyFormattedShort;
    }

    @Override
    public String getCurrencyFormattedLong() {
        return currencyFormattedLong;
    }

    public void setCurrencyFormattedLong(String currencyFormattedLong) {
        this.currencyFormattedLong = currencyFormattedLong;
    }

    @Override
    public String getOriginalCurrencyCode() {
        return originalCurrencyCode;
    }

    public void setOriginalCurrencyCode(String originalCurrencyCode) {
        this.originalCurrencyCode = originalCurrencyCode;
    }

    @Override
    public EtsyMoney getBeforeConversion() {
        return beforeConversion;
    }

    public void setBeforeConversion(EtsyMoney beforeConversion) {
        this.beforeConversion = beforeConversion;
    }
}
