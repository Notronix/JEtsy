package com.notronix.etsy.api.v2.model.countries;

public interface Country
{
    Long getCountryId();
    String getIsoCountryCode();
    String getWorldBankCountryCode();
    String getName();
    String getSlug();
    Float getLat();
    Float getLon();
}
