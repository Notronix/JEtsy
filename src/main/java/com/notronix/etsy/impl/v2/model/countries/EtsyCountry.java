package com.notronix.etsy.impl.v2.model.countries;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.v2.model.countries.Country;

public class EtsyCountry implements Country
{
    @SerializedName(value = "country_id")
    private Long countryId;

    @SerializedName(value = "iso_country_code")
    private String isoCountryCode;

    @SerializedName(value = "world_bank_country_code")
    private String worldBankCountryCode;

    private String name;
    private String slug;
    private Float lat;
    private Float lon;

    @Override
    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    @Override
    public String getIsoCountryCode() {
        return isoCountryCode;
    }

    public void setIsoCountryCode(String isoCountryCode) {
        this.isoCountryCode = isoCountryCode;
    }

    @Override
    public String getWorldBankCountryCode() {
        return worldBankCountryCode;
    }

    public void setWorldBankCountryCode(String worldBankCountryCode) {
        this.worldBankCountryCode = worldBankCountryCode;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    @Override
    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }
}
