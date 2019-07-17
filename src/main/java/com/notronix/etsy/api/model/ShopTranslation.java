package com.notronix.etsy.api.model;

public interface ShopTranslation
{
    Long getShopId();
    String getLanguage();
    String getAnnouncement();
    String getPolicyWelcome();
    String getPolicyPayment();
    String getPolicyShipping();
    String getPolicyRefunds();
    String getPolicyAdditional();
    String getPolicyPrivacy();
    String getPolicySellerInfo();
    String getSaleMessage();
    String getDigitalSaleMessage();
    String getTitle();
    String getVacationAutoReply();
    String getVacationMessage();
}