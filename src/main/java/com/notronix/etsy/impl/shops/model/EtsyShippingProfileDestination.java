package com.notronix.etsy.impl.shops.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.shops.model.Region;
import com.notronix.etsy.api.shops.model.ShippingProfileDestination;
import com.notronix.etsy.impl.common.model.EtsyPrice;

public class EtsyShippingProfileDestination implements ShippingProfileDestination
{
    @SerializedName("shipping_profile_destination_id")
    private Long id;
    @SerializedName("shipping_profile_id")
    private Long shippingProfileId;
    @SerializedName("origin_country_iso")
    private String originCountryISO;
    @SerializedName("destination_country_iso")
    private String destinationCountryISO;
    @SerializedName("distination_region")
    private Region destinationRegion;
    @SerializedName("primary_cost")
    private EtsyPrice primaryCost;
    @SerializedName("secondary_cost")
    private EtsyPrice secondaryCost;
    @SerializedName("shipping_carrier_id")
    private Long shippingCarrierId;
    @SerializedName("mail_class")
    private String mailClass;
    @SerializedName("min_delivery_days")
    private Integer minDeliveryDays;
    @SerializedName("max_delivery_days")
    private Integer maxDeliveryDays;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getShippingProfileId() {
        return shippingProfileId;
    }

    public void setShippingProfileId(Long shippingProfileId) {
        this.shippingProfileId = shippingProfileId;
    }

    @Override
    public String getOriginCountryISO() {
        return originCountryISO;
    }

    public void setOriginCountryISO(String originCountryISO) {
        this.originCountryISO = originCountryISO;
    }

    @Override
    public String getDestinationCountryISO() {
        return destinationCountryISO;
    }

    public void setDestinationCountryISO(String destinationCountryISO) {
        this.destinationCountryISO = destinationCountryISO;
    }

    @Override
    public Region getDestinationRegion() {
        return destinationRegion;
    }

    public void setDestinationRegion(Region destinationRegion) {
        this.destinationRegion = destinationRegion;
    }

    @Override
    public EtsyPrice getPrimaryCost() {
        return primaryCost;
    }

    public void setPrimaryCost(EtsyPrice primaryCost) {
        this.primaryCost = primaryCost;
    }

    @Override
    public EtsyPrice getSecondaryCost() {
        return secondaryCost;
    }

    public void setSecondaryCost(EtsyPrice secondaryCost) {
        this.secondaryCost = secondaryCost;
    }

    @Override
    public Long getShippingCarrierId() {
        return shippingCarrierId;
    }

    public void setShippingCarrierId(Long shippingCarrierId) {
        this.shippingCarrierId = shippingCarrierId;
    }

    @Override
    public String getMailClass() {
        return mailClass;
    }

    public void setMailClass(String mailClass) {
        this.mailClass = mailClass;
    }

    @Override
    public Integer getMinDeliveryDays() {
        return minDeliveryDays;
    }

    public void setMinDeliveryDays(Integer minDeliveryDays) {
        this.minDeliveryDays = minDeliveryDays;
    }

    @Override
    public Integer getMaxDeliveryDays() {
        return maxDeliveryDays;
    }

    public void setMaxDeliveryDays(Integer maxDeliveryDays) {
        this.maxDeliveryDays = maxDeliveryDays;
    }
}
