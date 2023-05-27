package com.notronix.etsy.api.v2.model.listings;

public interface ListingOffering
{
    Long getOfferingId();
    Money getPrice();
    Integer getQuantity();
    Boolean getEnabled();
    Boolean getDeleted();
}
