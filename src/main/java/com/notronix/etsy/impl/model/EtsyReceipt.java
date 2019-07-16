package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.Receipt;

import java.util.List;

public class EtsyReceipt implements Receipt
{
    @SerializedName(value = "receipt_id")
    private Long receiptId;

    @SerializedName(value = "receipt_type")
    private Integer receiptType;

    @SerializedName(value = "order_id")
    private Long orderId;

    @SerializedName(value = "seller_user_id")
    private Long sellerUserId;

    @SerializedName(value = "buyer_user_id")
    private Long buyerUserId;

    @SerializedName(value = "creation_tsz")
    private Float creationTsz;

    @SerializedName(value = "last_modified_tsz")
    private Float lastModifiedTsz;
    private String name;

    @SerializedName(value = "first_line")
    private String firstLine;

    @SerializedName(value = "second_line")
    private String secondLine;
    private String city;
    private String state;
    private String zip;

    @SerializedName(value = "formatted_address")
    private String formattedAddress;

    @SerializedName(value = "country_id")
    private Long countryId;

    @SerializedName(value = "payment_method")
    private String paymentMethod;

    @SerializedName(value = "payment_email")
    private String paymentEmail;

    @SerializedName(value = "message_from_seller")
    private String messageFromSeller;

    @SerializedName(value = "message_from_buyer")
    private String messageFromBuyer;

    @SerializedName(value = "was_paid")
    private Boolean paid;

    @SerializedName(value = "total_tax_cost")
    private Float totalTaxCost;

    @SerializedName(value = "total_vat_cost")
    private Float totalVatCost;

    @SerializedName(value = "total_price")
    private Float totalPrice;

    @SerializedName(value = "total_shipping_cost")
    private Float totalShippingCost;

    @SerializedName(value = "currency_code")
    private String currencyCode;

    @SerializedName(value = "message_from_payment")
    private String messageFromPayment;

    @SerializedName(value = "was_shipped")
    private Boolean shipped;

    @SerializedName(value = "buyer_email")
    private String buyerEmail;

    @SerializedName(value = "seller_email")
    private String sellerEmail;

    @SerializedName(value = "is_gift")
    private Boolean gift;

    @SerializedName(value = "needs_gift_wrap")
    private Boolean needsGiftWrap;

    @SerializedName(value = "gift_message")
    private String giftMessage;

    @SerializedName(value = "gift_wrap_price")
    private Float giftWrapPrice;

    @SerializedName(value = "discount_amt")
    private Float discountAmt;

    @SerializedName(value = "subtotal")
    private Float subTotal;

    @SerializedName(value = "grandtotal")
    private Float grandTotal;

    @SerializedName(value = "adjusted_grandtotal")
    private Float adjustedGrandTotal;
    private List<EtsyReceiptShipment> shipments;

    @Override
    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    @Override
    public Integer getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(Integer receiptType) {
        this.receiptType = receiptType;
    }

    @Override
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public Long getSellerUserId() {
        return sellerUserId;
    }

    public void setSellerUserId(Long sellerUserId) {
        this.sellerUserId = sellerUserId;
    }

    @Override
    public Long getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(Long buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    @Override
    public Float getCreationTsz() {
        return creationTsz;
    }

    public void setCreationTsz(Float creationTsz) {
        this.creationTsz = creationTsz;
    }

    @Override
    public Float getLastModifiedTsz() {
        return lastModifiedTsz;
    }

    public void setLastModifiedTsz(Float lastModifiedTsz) {
        this.lastModifiedTsz = lastModifiedTsz;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    @Override
    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    @Override
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    @Override
    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    @Override
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String getPaymentEmail() {
        return paymentEmail;
    }

    public void setPaymentEmail(String paymentEmail) {
        this.paymentEmail = paymentEmail;
    }

    @Override
    public String getMessageFromSeller() {
        return messageFromSeller;
    }

    public void setMessageFromSeller(String messageFromSeller) {
        this.messageFromSeller = messageFromSeller;
    }

    @Override
    public String getMessageFromBuyer() {
        return messageFromBuyer;
    }

    public void setMessageFromBuyer(String messageFromBuyer) {
        this.messageFromBuyer = messageFromBuyer;
    }

    @Override
    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    @Override
    public Float getTotalTaxCost() {
        return totalTaxCost;
    }

    public void setTotalTaxCost(Float totalTaxCost) {
        this.totalTaxCost = totalTaxCost;
    }

    @Override
    public Float getTotalVatCost() {
        return totalVatCost;
    }

    public void setTotalVatCost(Float totalVatCost) {
        this.totalVatCost = totalVatCost;
    }

    @Override
    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public Float getTotalShippingCost() {
        return totalShippingCost;
    }

    public void setTotalShippingCost(Float totalShippingCost) {
        this.totalShippingCost = totalShippingCost;
    }

    @Override
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String getMessageFromPayment() {
        return messageFromPayment;
    }

    public void setMessageFromPayment(String messageFromPayment) {
        this.messageFromPayment = messageFromPayment;
    }

    @Override
    public Boolean getShipped() {
        return shipped;
    }

    public void setShipped(Boolean shipped) {
        this.shipped = shipped;
    }

    @Override
    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    @Override
    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    @Override
    public Boolean getGift() {
        return gift;
    }

    public void setGift(Boolean gift) {
        this.gift = gift;
    }

    @Override
    public Boolean getNeedsGiftWrap() {
        return needsGiftWrap;
    }

    public void setNeedsGiftWrap(Boolean needsGiftWrap) {
        this.needsGiftWrap = needsGiftWrap;
    }

    @Override
    public String getGiftMessage() {
        return giftMessage;
    }

    public void setGiftMessage(String giftMessage) {
        this.giftMessage = giftMessage;
    }

    @Override
    public Float getGiftWrapPrice() {
        return giftWrapPrice;
    }

    public void setGiftWrapPrice(Float giftWrapPrice) {
        this.giftWrapPrice = giftWrapPrice;
    }

    @Override
    public Float getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(Float discountAmt) {
        this.discountAmt = discountAmt;
    }

    @Override
    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public Float getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Float grandTotal) {
        this.grandTotal = grandTotal;
    }

    @Override
    public Float getAdjustedGrandTotal() {
        return adjustedGrandTotal;
    }

    public void setAdjustedGrandTotal(Float adjustedGrandTotal) {
        this.adjustedGrandTotal = adjustedGrandTotal;
    }

    @Override
    public List<EtsyReceiptShipment> getShipments() {
        return shipments;
    }

    public void setShipments(List<EtsyReceiptShipment> shipments) {
        this.shipments = shipments;
    }
}
