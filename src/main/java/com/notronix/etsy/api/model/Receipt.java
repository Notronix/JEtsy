package com.notronix.etsy.api.model;

import java.time.Instant;
import java.util.List;

public interface Receipt
{
    Long getReceiptId();
    Integer getReceiptType();
    Long getOrderId();
    Long getSellerUserId();
    Long getBuyerUserId();
    Instant getCreationTsz();
    Instant getLastModifiedTsz();
    String getName();
    String getFirstLine();
    String getSecondLine();
    String getCity();
    String getState();
    String getZip();
    String getFormattedAddress();
    Long getCountryId();
    String getPaymentMethod();
    String getPaymentEmail();
    String getMessageFromSeller();
    String getMessageFromBuyer();
    Boolean getPaid();
    Float getTotalTaxCost();
    Float getTotalVatCost();
    Float getTotalPrice();
    Float getTotalShippingCost();
    String getCurrencyCode();
    String getMessageFromPayment();
    Boolean getShipped();
    String getBuyerEmail();
    String getSellerEmail();
    Boolean getGift();
    Boolean getNeedsGiftWrap();
    String getGiftMessage();
    Float getGiftWrapPrice();
    Float getDiscountAmt();
    Float getSubTotal();
    Float getGrandTotal();
    Float getAdjustedGrandTotal();
    List<? extends ReceiptShipment> getShipments();
}
