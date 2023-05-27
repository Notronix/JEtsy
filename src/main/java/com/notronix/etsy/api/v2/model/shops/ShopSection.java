package com.notronix.etsy.api.v2.model.shops;

public interface ShopSection
{
    Long getShopSectionId();
    String getTitle();
    Integer getRank();
    Long getUserId();
    Integer getActiveListingCount();
}
