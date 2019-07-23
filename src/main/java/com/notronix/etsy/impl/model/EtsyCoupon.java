package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.Coupon;

public class EtsyCoupon implements Coupon
{
    @SerializedName(value = "coupon_id")
    private Long couponId;

    @SerializedName(value = "coupon_code")
    private String couponCode;

    @SerializedName(value = "seller_active")
    private Boolean sellerActive;

    @SerializedName(value = "pct_discount")
    private Float pctDiscount;

    @SerializedName(value = "free_shipping")
    private Boolean freeShipping;

    @SerializedName(value = "domestic_only")
    private Boolean domesticOnly;

    @SerializedName(value = "currency_code")
    private String currencyCode;

    @SerializedName(value = "fixed_discount")
    private String fixedDiscount;

    @SerializedName(value = "minimum_purchase_price")
    private String minimumPurchasePrice;

    @SerializedName(value = "expiration_date")
    private Long expirationDate;

    @SerializedName(value = "coupon_type")
    private String couponType;

    @Override
    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    @Override
    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    @Override
    public Boolean getSellerActive() {
        return sellerActive;
    }

    public void setSellerActive(Boolean sellerActive) {
        this.sellerActive = sellerActive;
    }

    @Override
    public Float getPctDiscount() {
        return pctDiscount;
    }

    public void setPctDiscount(Float pctDiscount) {
        this.pctDiscount = pctDiscount;
    }

    @Override
    public Boolean getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(Boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    @Override
    public Boolean getDomesticOnly() {
        return domesticOnly;
    }

    public void setDomesticOnly(Boolean domesticOnly) {
        this.domesticOnly = domesticOnly;
    }

    @Override
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String getFixedDiscount() {
        return fixedDiscount;
    }

    public void setFixedDiscount(String fixedDiscount) {
        this.fixedDiscount = fixedDiscount;
    }

    @Override
    public String getMinimumPurchasePrice() {
        return minimumPurchasePrice;
    }

    public void setMinimumPurchasePrice(String minimumPurchasePrice) {
        this.minimumPurchasePrice = minimumPurchasePrice;
    }

    @Override
    public Long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Long expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }
}
