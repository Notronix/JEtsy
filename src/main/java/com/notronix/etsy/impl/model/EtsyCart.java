package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.Cart;

import java.util.List;

public class EtsyCart implements Cart
{
    @SerializedName(value = "cart_id")
    private Long cartId;

    @SerializedName(value = "shop_name")
    private String shopName;

    @SerializedName(value = "message_to_seller")
    private String messageToSeller;

    @SerializedName(value = "destination_country_id")
    private Long destinationCountryId;

    @SerializedName(value = "currency_code")
    private String currencyCode;
    private String total;

    @SerializedName(value = "subtotal")
    private String subTotal;

    @SerializedName(value = "shipping_cost")
    private String shippingCost;

    @SerializedName(value = "tax_cost")
    private String taxCost;

    @SerializedName(value = "discount_amount")
    private String discountAmount;

    @SerializedName(value = "shipping_discount_amount")
    private String shippingDiscountAmount;

    @SerializedName(value = "tax_discount_amount")
    private String taxDiscountAmount;

    private String url;

    private List<EtsyCartListing> listings;

    @SerializedName(value = "is_download_only")
    private Boolean isDownloadOnly;

    @SerializedName(value = "has_vat")
    private Boolean hasVat;

    @SerializedName(value = "shipping_option")
    private EtsyShippingOption shippingOption;

    @Override
    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    @Override
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String getMessageToSeller() {
        return messageToSeller;
    }

    public void setMessageToSeller(String messageToSeller) {
        this.messageToSeller = messageToSeller;
    }

    @Override
    public Long getDestinationCountryId() {
        return destinationCountryId;
    }

    public void setDestinationCountryId(Long destinationCountryId) {
        this.destinationCountryId = destinationCountryId;
    }

    @Override
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(String shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public String getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(String taxCost) {
        this.taxCost = taxCost;
    }

    @Override
    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public String getShippingDiscountAmount() {
        return shippingDiscountAmount;
    }

    public void setShippingDiscountAmount(String shippingDiscountAmount) {
        this.shippingDiscountAmount = shippingDiscountAmount;
    }

    @Override
    public String getTaxDiscountAmount() {
        return taxDiscountAmount;
    }

    public void setTaxDiscountAmount(String taxDiscountAmount) {
        this.taxDiscountAmount = taxDiscountAmount;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public List<EtsyCartListing> getListings() {
        return listings;
    }

    public void setListings(List<EtsyCartListing> listings) {
        this.listings = listings;
    }

    @Override
    public Boolean getDownloadOnly() {
        return isDownloadOnly;
    }

    public void setDownloadOnly(Boolean downloadOnly) {
        isDownloadOnly = downloadOnly;
    }

    @Override
    public Boolean getHasVat() {
        return hasVat;
    }

    public void setHasVat(Boolean hasVat) {
        this.hasVat = hasVat;
    }

    @Override
    public EtsyShippingOption getShippingOption() {
        return shippingOption;
    }

    public void setShippingOption(EtsyShippingOption shippingOption) {
        this.shippingOption = shippingOption;
    }
}
