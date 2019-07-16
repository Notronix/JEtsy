package com.notronix.etsy.api.model;

public interface PaymentTemplate
{
    Long getPaymentTemplateId();
    Boolean getAllowBt();
    Boolean getAllowCheck();
    Boolean getAllowMo();
    Boolean getAllowOther();
    Boolean getAllowPayPal();
    Boolean getAllowCc();
    String getPayPalEmail();
    String getName();
    String getFirstLine();
    String getSecondLine();
    String getCity();
    String getState();
    String getZip();
    Long getCountryId();
    Long getUserId();
    Long getListingPaymentId();
}
