package com.notronix.etsy.impl.v2.method.shops;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.shops.EtsyReceipt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.notronix.etsy.impl.EtsyMethodUtils.putIfProvided;
import static java.util.Objects.requireNonNull;

public class SubmitTrackingMethod extends EtsyMethod<EtsyResponse<List<EtsyReceipt>>>
{
    private Long shopId;
    private Long receiptId;
    private String trackingCode;
    private String carrierName;
    private Boolean sendBcc;

    public SubmitTrackingMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    protected String getURI() {
        return "/shops/" + requireNonNull(shopId) + "/receipts/" + requireNonNull(receiptId) + "/tracking";
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.POST;
    }

    @Override
    public HttpContent getContent(Marshaller marshaller) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("tracking_code", requireNonNull(trackingCode));
        parameters.put("carrier_name", requireNonNull(carrierName));
        putIfProvided(parameters, "send_bcc", sendBcc);

        return new UrlEncodedContent(parameters);
    }

    @Override
    public EtsyResponse<List<EtsyReceipt>> getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, new TypeToken<EtsyResponse<List<EtsyReceipt>>>(){}.getType());
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public SubmitTrackingMethod withShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public SubmitTrackingMethod withReceiptId(Long receiptId) {
        this.receiptId = receiptId;
        return this;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public SubmitTrackingMethod withTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
        return this;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public SubmitTrackingMethod withCarrierName(String carrierName) {
        this.carrierName = carrierName;
        return this;
    }

    public Boolean getSendBcc() {
        return sendBcc;
    }

    public void setSendBcc(Boolean sendBcc) {
        this.sendBcc = sendBcc;
    }

    public SubmitTrackingMethod withSendBcc(Boolean sendBcc) {
        this.sendBcc = sendBcc;
        return this;
    }
}
