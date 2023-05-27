package com.notronix.etsy.impl.v2.model.listings;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.v2.model.listings.ListingOffering;

public class EtsyListingOffering implements ListingOffering
{
    @SerializedName(value = "offering_id")
    private Long offeringId;
    private EtsyMoney price;
    private Integer quantity;

    @SerializedName(value = "is_enabled")
    private Boolean enabled;

    @SerializedName(value = "is_deleted")
    private Boolean deleted;

    @Override
    public Long getOfferingId() {
        return offeringId;
    }

    public void setOfferingId(Long offeringId) {
        this.offeringId = offeringId;
    }

    @Override
    public EtsyMoney getPrice() {
        return price;
    }

    public void setPrice(EtsyMoney price) {
        this.price = price;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

   public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
