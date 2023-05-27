package com.notronix.etsy.api.v2.model.listings;

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
