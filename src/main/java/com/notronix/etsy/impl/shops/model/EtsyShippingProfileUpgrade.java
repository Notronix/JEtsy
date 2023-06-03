package com.notronix.etsy.impl.shops.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.shops.model.ShippingProfileUpgrade;
import com.notronix.etsy.api.shops.model.ShippingUpgradeType;
import com.notronix.etsy.impl.common.model.EtsyPrice;

public class EtsyShippingProfileUpgrade implements ShippingProfileUpgrade
{
    @SerializedName("upgrade_id")
    private Long id;
    @SerializedName("shipping_profile_id")
    private Long shippingProfileId;
    @SerializedName("upgrade_name")
    private String name;
    private ShippingUpgradeType type;
    private Integer rank;
    private String language;
    private EtsyPrice price;
    @SerializedName("secondary_price")
    private EtsyPrice secondaryPrice;
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ShippingUpgradeType getType() {
        return type;
    }

    public void setType(ShippingUpgradeType type) {
        this.type = type;
    }

    @Override
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public EtsyPrice getPrice() {
        return price;
    }

    public void setPrice(EtsyPrice price) {
        this.price = price;
    }

    @Override
    public EtsyPrice getSecondaryPrice() {
        return secondaryPrice;
    }

    public void setSecondaryPrice(EtsyPrice secondaryPrice) {
        this.secondaryPrice = secondaryPrice;
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
