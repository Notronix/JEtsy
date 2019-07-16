package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.PaymentTemplate;

public class EtsyPaymentTemplate implements PaymentTemplate
{
    @SerializedName(value = "payment_template_id")
    private Long paymentTemplateId;

    @SerializedName(value = "allow_bt")
    private Boolean allowBt;

    @SerializedName(value = "allow_check")
    private Boolean allowCheck;

    @SerializedName(value = "allow_mo")
    private Boolean allowMo;

    @SerializedName(value = "allow_other")
    private Boolean allowOther;

    @SerializedName(value = "allow_paypal")
    private Boolean allowPayPal;

    @SerializedName(value = "allow_cc")
    private Boolean allowCc;

    @SerializedName(value = "paypal_email")
    private String payPalEmail;

    private String name;

    @SerializedName(value = "first_line")
    private String firstLine;

    @SerializedName(value = "second_line")
    private String secondLine;
    private String city;
    private String state;
    private String zip;
    @SerializedName(value = "country_id")
    private Long countryId;

    @SerializedName(value = "user_id")
    private Long userId;

    @SerializedName(value = "listing_payment_id")
    private Long listingPaymentId;

    @Override
    public Long getPaymentTemplateId() {
        return paymentTemplateId;
    }

    public void setPaymentTemplateId(Long paymentTemplateId) {
        this.paymentTemplateId = paymentTemplateId;
    }

    @Override
    public Boolean getAllowBt() {
        return allowBt;
    }

    public void setAllowBt(Boolean allowBt) {
        this.allowBt = allowBt;
    }

    @Override
    public Boolean getAllowCheck() {
        return allowCheck;
    }

    public void setAllowCheck(Boolean allowCheck) {
        this.allowCheck = allowCheck;
    }

    @Override
    public Boolean getAllowMo() {
        return allowMo;
    }

    public void setAllowMo(Boolean allowMo) {
        this.allowMo = allowMo;
    }

    @Override
    public Boolean getAllowOther() {
        return allowOther;
    }

    public void setAllowOther(Boolean allowOther) {
        this.allowOther = allowOther;
    }

    @Override
    public Boolean getAllowPayPal() {
        return allowPayPal;
    }

    public void setAllowPayPal(Boolean allowPayPal) {
        this.allowPayPal = allowPayPal;
    }

    @Override
    public Boolean getAllowCc() {
        return allowCc;
    }

    public void setAllowCc(Boolean allowCc) {
        this.allowCc = allowCc;
    }

    @Override
    public String getPayPalEmail() {
        return payPalEmail;
    }

    public void setPayPalEmail(String payPalEmail) {
        this.payPalEmail = payPalEmail;
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
    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public Long getListingPaymentId() {
        return listingPaymentId;
    }

    public void setListingPaymentId(Long listingPaymentId) {
        this.listingPaymentId = listingPaymentId;
    }
}
