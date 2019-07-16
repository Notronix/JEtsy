package com.notronix.etsy.api.model;

public interface ReceiptShipment
{
    String getCarrierName();
    Long getReceiptShippingId();
    String getTrackingCode();
    String getTrackingUrl();
    String getBuyerNote();
    Integer getNotificationDate();
}
