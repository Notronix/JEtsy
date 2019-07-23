package com.notronix.etsy.api.model;

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
