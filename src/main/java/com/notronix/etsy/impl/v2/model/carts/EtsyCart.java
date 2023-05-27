package com.notronix.etsy.impl.v2.model.carts;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.v2.model.carts.Cart;

import java.util.List;

public class EtsyCart implements Cart
{
    @SerializedName("cart_id")
    private Long cartId;

    @SerializedName("shop_name")
    private String shopName;

    @SerializedName("message_to_seller")
    private String messageToSeller;

    @SerializedName("destination_country_id")
    private Long destinationCountryId;

    @SerializedName("currency_code")
    private String currencyCode;
    private String total;

    @SerializedName("subtotal")
    private String subTotal;

    @SerializedName("shipping_cost")
    private String shippingCost;

    @SerializedName("tax_cost")
    private String taxCost;

    @SerializedName("discount_amount")
    private String discountAmount;

    @SerializedName("shipping_discount_amount")
    private String shippingDiscountAmount;

    @SerializedName("tax_discount_amount")
    private String taxDiscountAmount;

    private String url;

    private List<EtsyCartListing> listings;

    @SerializedName("is_download_only")
    private Boolean isDownloadOnly;

    @SerializedName("has_vat")
    private Boolean hasVat;

    @SerializedName("shipping_option")
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
