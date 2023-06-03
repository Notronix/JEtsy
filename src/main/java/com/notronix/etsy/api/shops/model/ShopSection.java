package com.notronix.etsy.api.shops.model;

public interface ShopSection
{
    Long getId();
    String getTitle();
    Integer getRank();
    Long getUserId();
    Integer getActiveListingCount();
}
