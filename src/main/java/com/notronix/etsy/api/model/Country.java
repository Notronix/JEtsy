package com.notronix.etsy.api.model;

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
