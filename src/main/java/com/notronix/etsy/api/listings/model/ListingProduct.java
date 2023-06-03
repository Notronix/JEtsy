package com.notronix.etsy.api.listings.model;

import java.util.List;

public interface ListingProduct
{
    Long getId();
    String getSku();
    Boolean isDeleted();
    List<? extends ListingOffering> getOfferings();
    List<? extends PropertyValue> getPropertyValues();
}
