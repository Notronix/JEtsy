package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.ReceiptShipment;

public class EtsyReceiptShipment implements ReceiptShipment
{
    @SerializedName(value = "carrier_name")
    private String carrierName;

    @SerializedName(value = "receipt_shipping_id")
    private Long receiptShippingId;

    @SerializedName(value = "tracking_code")
    private String trackingCode;

    @SerializedName(value = "tracking_url")
    private String trackingUrl;

    @SerializedName(value = "buyer_note")
    private String buyerNote;

    @SerializedName(value = "notification_date")
    private Integer notificationDate;

    @Override
    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    @Override
    public Long getReceiptShippingId() {
        return receiptShippingId;
    }

    public void setReceiptShippingId(Long receiptShippingId) {
        this.receiptShippingId = receiptShippingId;
    }

    @Override
    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    @Override
    public String getTrackingUrl() {
        return trackingUrl;
    }

    public void setTrackingUrl(String trackingUrl) {
        this.trackingUrl = trackingUrl;
    }

    @Override
    public String getBuyerNote() {
        return buyerNote;
    }

    public void setBuyerNote(String buyerNote) {
        this.buyerNote = buyerNote;
    }

    @Override
    public Integer getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Integer notificationDate) {
        this.notificationDate = notificationDate;
    }
}
