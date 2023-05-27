package com.notronix.etsy.api.v2.model.listings;

import java.util.List;

public interface ListingProduct
{
    Long getProductId();
    List<? extends PropertyValue> getPropertyValues();
    String getSku();
    List<? extends ListingOffering> getOfferings();
    Boolean getDeleted();
}
