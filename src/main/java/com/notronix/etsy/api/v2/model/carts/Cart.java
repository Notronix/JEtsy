package com.notronix.etsy.api.v2.model.carts;

import java.util.List;

public interface Cart
{
    Long getCartId();
    String getShopName();
    String getMessageToSeller();
    Long getDestinationCountryId();
    String getCurrencyCode();
    String getTotal();
    String getSubTotal();
    String getShippingCost();
    String getTaxCost();
    String getDiscountAmount();
    String getShippingDiscountAmount();
    String getTaxDiscountAmount();
    String getUrl();
    List<? extends CartListing> getListings();
    Boolean getDownloadOnly();
    Boolean getHasVat();
    ShippingOption getShippingOption();
}
