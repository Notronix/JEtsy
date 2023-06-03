package com.notronix.etsy.api.shops.model;

import com.notronix.etsy.api.common.model.Price;

public interface ShippingProfileUpgrade
{
    Long getId();
    Long getShippingProfileId();
    String getName();
    ShippingUpgradeType getType();
    Integer getRank();
    String getLanguage();
    Price getPrice();
    Price getSecondaryPrice();
    Long getShippingCarrierId();
    String getMailClass();
    Integer getMinDeliveryDays();
    Integer getMaxDeliveryDays();
}
