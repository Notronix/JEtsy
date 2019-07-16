package com.notronix.etsy.api.model;

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
