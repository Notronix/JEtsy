package com.notronix.etsy.impl.shops.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.shops.model.ProfileType;
import com.notronix.etsy.api.shops.model.ShippingProfile;

import java.util.List;

public class EtsyShippingProfile implements ShippingProfile
{
    @SerializedName("shipping_profile_id")
    private Long id;
    private String title;
    @SerializedName("user_id")
    private Long userId;
    @SerializedName("min_processing_days")
    private Integer minProcessingDays;
    @SerializedName("max_processing_days")
    private Integer maxProcessingDays;
    @SerializedName("processing_days_display_label")
    private String processingDaysDisplayLabel;
    @SerializedName("origin_country_iso")
    private String originCountryISO;
    @SerializedName("is_deleted")
    private Boolean deleted;

    @SerializedName("shipping_profile_destinations")
    private List<EtsyShippingProfileDestination> shippingProfileDestinations;

    @SerializedName("shipping_profile_upgrades")
    private List<EtsyShippingProfileUpgrade> shippingProfileUpgrades;
    @SerializedName("origin_postal_code")
    private String originPostalCode;
    @SerializedName("profile_type")
    private ProfileType profileType;
    @SerializedName("domestic_handling_fee")
    private Float domesticHandlingFee;
    @SerializedName("international_handling_fee")
    private Float internationalHandlingFee;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String getOriginCountryISO() {
        return originCountryISO;
    }

    public void setOriginCountryISO(String originCountryISO) {
        this.originCountryISO = originCountryISO;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    @Override
    public Boolean isDeleted() {
        return null;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public List<EtsyShippingProfileDestination> getShippingProfileDestinations() {
        return shippingProfileDestinations;
    }

    public void setShippingProfileDestinations(List<EtsyShippingProfileDestination> shippingProfileDestinations) {
        this.shippingProfileDestinations = shippingProfileDestinations;
    }

    @Override
    public List<EtsyShippingProfileUpgrade> getShippingProfileUpgrades() {
        return shippingProfileUpgrades;
    }

    public void setShippingProfileUpgrades(List<EtsyShippingProfileUpgrade> shippingProfileUpgrades) {
        this.shippingProfileUpgrades = shippingProfileUpgrades;
    }

    @Override
    public String getOriginPostalCode() {
        return originPostalCode;
    }

    public void setOriginPostalCode(String originPostalCode) {
        this.originPostalCode = originPostalCode;
    }

    @Override
    public ProfileType getProfileType() {
        return profileType;
    }

    public void setProfileType(ProfileType profileType) {
        this.profileType = profileType;
    }

    @Override
    public Float getDomesticHandlingFee() {
        return domesticHandlingFee;
    }

    public void setDomesticHandlingFee(Float domesticHandlingFee) {
        this.domesticHandlingFee = domesticHandlingFee;
    }

    @Override
    public Float getInternationalHandlingFee() {
        return internationalHandlingFee;
    }

    public void setInternationalHandlingFee(Float internationalHandlingFee) {
        this.internationalHandlingFee = internationalHandlingFee;
    }
}
