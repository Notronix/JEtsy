package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.ShippingInfo;

public class EtsyShippingInfo implements ShippingInfo
{
    @SerializedName(value = "shipping_info_id")
    private Long shippingInfoId;

    @SerializedName(value = "origin_country_id")
    private Long originCountryId;

    @SerializedName(value = "destination_country_id")
    private Long destinationCountryId;

    @SerializedName(value = "currency_code")
    private String currencyCode;

    @SerializedName(value = "primary_cost")
    private Float primaryCost;

    @SerializedName(value = "secondary_cost")
    private Float secondaryCost;

    @SerializedName(value = "listing_id")
    private Long listingId;

    @SerializedName(value = "region_id")
    private Long regionId;

    @SerializedName(value = "origin_country_name")
    private String originCountryName;

    @SerializedName(value = "destination_country_name")
    private String destinationCountryName;

    @Override
    public Long getShippingInfoId() {
        return shippingInfoId;
    }

    public void setShippingInfoId(Long shippingInfoId) {
        this.shippingInfoId = shippingInfoId;
    }

    @Override
    public Long getOriginCountryId() {
        return originCountryId;
    }

    public void setOriginCountryId(Long originCountryId) {
        this.originCountryId = originCountryId;
    }

    @Override
    public Long getDestinationCountryId() {
        return destinationCountryId;
    }

    public void setDestinationCountryId(Long destinationCountryId) {
        this.destinationCountryId = destinationCountryId;
    }

    @Override
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public Float getPrimaryCost() {
        return primaryCost;
    }

    public void setPrimaryCost(Float primaryCost) {
        this.primaryCost = primaryCost;
    }

    @Override
    public Float getSecondaryCost() {
        return secondaryCost;
    }

    public void setSecondaryCost(Float secondaryCost) {
        this.secondaryCost = secondaryCost;
    }

    @Override
    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    @Override
    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    @Override
    public String getOriginCountryName() {
        return originCountryName;
    }

    public void setOriginCountryName(String originCountryName) {
        this.originCountryName = originCountryName;
    }

    @Override
    public String getDestinationCountryName() {
        return destinationCountryName;
    }

    public void setDestinationCountryName(String destinationCountryName) {
        this.destinationCountryName = destinationCountryName;
    }
}
