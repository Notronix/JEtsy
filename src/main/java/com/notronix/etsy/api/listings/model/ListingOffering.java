package com.notronix.etsy.api.listings.model;

import com.notronix.etsy.api.common.model.Price;

public interface ListingOffering
{
    Long getId();
    Integer getQuantity();
    Boolean isEnabled();
    Boolean isDeleted();
    Price getPrice();
}
