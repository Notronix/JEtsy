package com.notronix.etsy.api.shops.model;

import com.notronix.etsy.api.common.model.Price;

public interface ShippingProfileDestination
{
    Long getId();
    Long getShippingProfileId();
    String getOriginCountryISO();
    String getDestinationCountryISO();
    Region getDestinationRegion();
    Price getPrimaryCost();
    Price getSecondaryCost();
    Long getShippingCarrierId();
    String getMailClass();
    Integer getMinDeliveryDays();
    Integer getMaxDeliveryDays();
}
