package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.ShippingTemplate;

public class EtsyShippingTemplate implements ShippingTemplate
{
    @SerializedName(value = "shipping_template_id")
    private Long shippingTemplateId;

    private String title;

    @SerializedName(value = "user_id")
    private Long userId;

    @SerializedName(value = "min_processing_days")
    private Integer minProcessingDays;

    @SerializedName(value = "max_processing_days")
    private Integer maxProcessingDays;

    @SerializedName(value = "processing_days_display_label")
    private String processingDaysDisplayLabel;

    @SerializedName(value = "origin_country_id")
    private Long originCountryId;

    @Override
    public Long getShippingTemplateId() {
        return shippingTemplateId;
    }

    public void setShippingTemplateId(Long shippingTemplateId) {
        this.shippingTemplateId = shippingTemplateId;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public Integer getMinProcessingDays() {
        return minProcessingDays;
    }

    public void setMinProcessingDays(Integer minProcessingDays) {
        this.minProcessingDays = minProcessingDays;
    }

    @Override
    public Integer getMaxProcessingDays() {
        return maxProcessingDays;
    }

    public void setMaxProcessingDays(Integer maxProcessingDays) {
        this.maxProcessingDays = maxProcessingDays;
    }

    @Override
    public String getProcessingDaysDisplayLabel() {
        return processingDaysDisplayLabel;
    }

    public void setProcessingDaysDisplayLabel(String processingDaysDisplayLabel) {
        this.processingDaysDisplayLabel = processingDaysDisplayLabel;
    }

    @Override
    public Long getOriginCountryId() {
        return originCountryId;
    }

    public void setOriginCountryId(Long originCountryId) {
        this.originCountryId = originCountryId;
    }
}
