package com.notronix.etsy.api.v2.model.users;

public interface ShippingTemplate
{
    Long getShippingTemplateId();
    String getTitle();
    Long getUserId();
    Integer getMinProcessingDays();
    Integer getMaxProcessingDays();
    String getProcessingDaysDisplayLabel();
    Long getOriginCountryId();
}
