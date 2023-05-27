package com.notronix.etsy.api.v2.model.carts;

import java.util.List;
import java.util.Map;

public interface CartListing
{
    Long getListingId();
    Integer getPurchaseQuantity();
    String getPurchaseState();
    Boolean getDigital();
    String getFileData();
    Long getListingCustomizationId();
    Boolean getVariationsAvailable();
    Boolean getHasVariations();
    List<Map<String, Object>> getSelectedVariations();
}
