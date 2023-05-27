package com.notronix.etsy.api.v2.model.shops;

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