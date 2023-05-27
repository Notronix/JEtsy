package com.notronix.etsy.impl.v2.model.listings;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.v2.model.listings.ListingProduct;

import java.util.List;

public class EtsyListingProduct implements ListingProduct
{
    @SerializedName(value = "product_id")
    private Long productId;

    @SerializedName(value = "property_values")
    private List<EtsyPropertyValue> propertyValues;

    private String sku;

    private List<EtsyListingOffering> offerings;

    @SerializedName(value = "is_deleted")
    private Boolean deleted;

    @Override
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public List<EtsyPropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(List<EtsyPropertyValue> propertyValues) {
        this.propertyValues = propertyValues;
    }

    @Override
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public List<EtsyListingOffering> getOfferings() {
        return offerings;
    }

    public void setOfferings(List<EtsyListingOffering> offerings) {
        this.offerings = offerings;
    }

    @Override
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
