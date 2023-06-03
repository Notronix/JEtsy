package com.notronix.etsy.api.shops.model;

import java.util.List;

public interface ShippingProfile
{
    Long getId();
    String getTitle();
    Long getUserId();
    Integer getMinProcessingDays();
    Integer getMaxProcessingDays();
    String getProcessingDaysDisplayLabel();
    String getOriginCountryISO();
    Boolean isDeleted();
    List<? extends ShippingProfileDestination> getShippingProfileDestinations();
    List<? extends ShippingProfileUpgrade> getShippingProfileUpgrades();
    String getOriginPostalCode();
    ProfileType getProfileType();
    Float getDomesticHandlingFee();
    Float getInternationalHandlingFee();
}
