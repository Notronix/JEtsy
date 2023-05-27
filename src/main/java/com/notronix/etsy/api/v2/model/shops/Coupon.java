package com.notronix.etsy.api.v2.model.shops;

@Deprecated
public interface Coupon
{
    Long getCouponId();
    String getCouponCode();
    Boolean getSellerActive();
    Float getPctDiscount();
    Boolean getFreeShipping();
    Boolean getDomesticOnly();
    String getCurrencyCode();
    String getFixedDiscount();
    String getMinimumPurchasePrice();
    Long getExpirationDate();
    String getCouponType();
}
