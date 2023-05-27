package com.notronix.etsy.impl.v2.model.shops;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.v2.model.shops.ShopTranslation;

public class EtsyShopTranslation implements ShopTranslation
{
    @SerializedName("shop_id")
    private Long shopId;
    private String language;
    private String announcement;

    @SerializedName("policy_welcome")
    private String policyWelcome;

    @SerializedName("policy_payment")
    private String policyPayment;

    @SerializedName("policy_shipping")
    private String policyShipping;

    @SerializedName("policy_refunds")
    private String policyRefunds;

    @SerializedName("policy_additional")
    private String policyAdditional;

    @SerializedName("policy_privacy")
    private String policyPrivacy;

    @SerializedName("policy_seller_info")
    private String policySellerInfo;

    @SerializedName("sale_message")
    private String saleMessage;

    @SerializedName("digital_sale_message")
    private String digitalSaleMessage;

    private String title;

    @SerializedName("vacation_autoreply")
    private String vacationAutoReply;

    @SerializedName("vacation_message")
    private String vacationMessage;

    @Override
    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    @Override
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    @Override
    public String getPolicyWelcome() {
        return policyWelcome;
    }

    public void setPolicyWelcome(String policyWelcome) {
        this.policyWelcome = policyWelcome;
    }

    @Override
    public String getPolicyPayment() {
        return policyPayment;
    }

    public void setPolicyPayment(String policyPayment) {
        this.policyPayment = policyPayment;
    }

    @Override
    public String getPolicyShipping() {
        return policyShipping;
    }

    public void setPolicyShipping(String policyShipping) {
        this.policyShipping = policyShipping;
    }

    @Override
    public String getPolicyRefunds() {
        return policyRefunds;
    }

    public void setPolicyRefunds(String policyRefunds) {
        this.policyRefunds = policyRefunds;
    }

    @Override
    public String getPolicyAdditional() {
        return policyAdditional;
    }

    public void setPolicyAdditional(String policyAdditional) {
        this.policyAdditional = policyAdditional;
    }

    @Override
    public String getPolicyPrivacy() {
        return policyPrivacy;
    }

    public void setPolicyPrivacy(String policyPrivacy) {
        this.policyPrivacy = policyPrivacy;
    }

    @Override
    public String getPolicySellerInfo() {
        return policySellerInfo;
    }

    public void setPolicySellerInfo(String policySellerInfo) {
        this.policySellerInfo = policySellerInfo;
    }

    @Override
    public String getSaleMessage() {
        return saleMessage;
    }

    public void setSaleMessage(String saleMessage) {
        this.saleMessage = saleMessage;
    }

    @Override
    public String getDigitalSaleMessage() {
        return digitalSaleMessage;
    }

    public void setDigitalSaleMessage(String digitalSaleMessage) {
        this.digitalSaleMessage = digitalSaleMessage;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getVacationAutoReply() {
        return vacationAutoReply;
    }

    public void setVacationAutoReply(String vacationAutoReply) {
        this.vacationAutoReply = vacationAutoReply;
    }

    @Override
    public String getVacationMessage() {
        return vacationMessage;
    }

    public void setVacationMessage(String vacationMessage) {
        this.vacationMessage = vacationMessage;
    }
}
