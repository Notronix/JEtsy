package com.notronix.etsy.api.model;

public interface Money
{
    Long getAmount();
    Integer getDivisor();
    String getCurrencyCode();
    String getCurrencyFormattedRaw();
    String getCurrencyFormattedShort();
    String getCurrencyFormattedLong();
    String getOriginalCurrencyCode();
    Money getBeforeConversion();
}
