package com.notronix.etsy.api.v2.model.shops;

public interface ReceiptShipment
{
    String getCarrierName();
    Long getReceiptShippingId();
    String getTrackingCode();
    String getTrackingUrl();
    String getBuyerNote();
    Integer getNotificationDate();
}
