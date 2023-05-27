package com.notronix.etsy.api.v2.model.listings;

public interface ShippingInfo
{
    Long getShippingInfoId();
    Long getOriginCountryId();
    Long getDestinationCountryId();
    String getCurrencyCode();
    Float getPrimaryCost();
    Float getSecondaryCost();
    Long getListingId();
    Long getRegionId();
    String getOriginCountryName();
    String getDestinationCountryName();
}
