package com.notronix.etsy.api.model;

public interface ListingOffering
{
    Long getOfferingId();
    Money getPrice();
    Integer getQuantity();
    Boolean getEnabled();
    Boolean getDeleted();
}
