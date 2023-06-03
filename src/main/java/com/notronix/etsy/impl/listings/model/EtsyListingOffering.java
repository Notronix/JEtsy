package com.notronix.etsy.impl.listings.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.listings.model.ListingOffering;
import com.notronix.etsy.impl.common.model.EtsyPrice;

public class EtsyListingOffering implements ListingOffering
{
    @SerializedName("offering_id")
    private Long id;
    private Integer quantity;
    @SerializedName("is_enabled")
    private Boolean enabled;
    @SerializedName("is_deleted")
    private Boolean deleted;
    private EtsyPrice price;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public Boolean isEnabled() {
        return enabled;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Boolean isDeleted() {
        return deleted;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public EtsyPrice getPrice() {
        return price;
    }

    public void setPrice(EtsyPrice price) {
        this.price = price;
    }
}
