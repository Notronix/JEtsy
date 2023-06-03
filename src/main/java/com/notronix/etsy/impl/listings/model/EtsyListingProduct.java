package com.notronix.etsy.impl.listings.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.listings.model.ListingProduct;

import java.util.List;

public class EtsyListingProduct implements ListingProduct
{
    @SerializedName("product_id")
    private Long id;
    private String sku;
    @SerializedName("is_deleted")
    private Boolean deleted;
    private List<EtsyListingOffering> offerings;
    @SerializedName("property_values")
    private List<EtsyPropertyValue> propertyValues;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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
    public List<EtsyListingOffering> getOfferings() {
        return offerings;
    }

    public void setOfferings(List<EtsyListingOffering> offerings) {
        this.offerings = offerings;
    }

    @Override
    public List<EtsyPropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(List<EtsyPropertyValue> propertyValues) {
        this.propertyValues = propertyValues;
    }
}
