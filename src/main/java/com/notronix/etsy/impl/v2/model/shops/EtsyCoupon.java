package com.notronix.etsy.impl.v2.model.shops;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.v2.model.shops.Coupon;

@Deprecated
public class EtsyCoupon implements Coupon
{
    @SerializedName("coupon_id")
    private Long couponId;

    @SerializedName("coupon_code")
    private String couponCode;

    @SerializedName("seller_active")
    private Boolean sellerActive;

    @SerializedName("pct_discount")
    private Float pctDiscount;

    @SerializedName("free_shipping")
    private Boolean freeShipping;

    @SerializedName("domestic_only")
    private Boolean domesticOnly;

    @SerializedName("currency_code")
    private String currencyCode;

    @SerializedName("fixed_discount")
    private String fixedDiscount;

    @SerializedName("minimum_purchase_price")
    private String minimumPurchasePrice;

    @SerializedName("expiration_date")
    private Long expirationDate;

    @SerializedName("coupon_type")
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
