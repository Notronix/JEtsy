package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.CartListing;

import java.util.List;
import java.util.Map;

public class EtsyCartListing implements CartListing
{
    @SerializedName(value = "listing_id")
    private Long listingId;

    @SerializedName(value = "purchase_quantity")
    private Integer purchaseQuantity;

    @SerializedName(value = "purchase_state")
    private String purchaseState;

    @SerializedName(value = "is_digital")
    private Boolean isDigital;

    @SerializedName(value = "file_data")
    private String fileData;

    @SerializedName(value = "listing_customization_id")
    private Long listingCustomizationId;

    @SerializedName(value = "variations_available")
    private Boolean variationsAvailable;

    @SerializedName(value = "has_variations")
    private Boolean hasVariations;

    @SerializedName(value = "selected_variations")
    private List<Map<String, Object>> selectedVariations;

    @Override
    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    @Override
    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Integer purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    @Override
    public String getPurchaseState() {
        return purchaseState;
    }

    public void setPurchaseState(String purchaseState) {
        this.purchaseState = purchaseState;
    }

    @Override
    public Boolean getDigital() {
        return isDigital;
    }

    public void setDigital(Boolean digital) {
        isDigital = digital;
    }

    @Override
    public String getFileData() {
        return fileData;
    }

    public void setFileData(String fileData) {
        this.fileData = fileData;
    }

    @Override
    public Long getListingCustomizationId() {
        return listingCustomizationId;
    }

    public void setListingCustomizationId(Long listingCustomizationId) {
        this.listingCustomizationId = listingCustomizationId;
    }

    @Override
    public Boolean getVariationsAvailable() {
        return variationsAvailable;
    }

    public void setVariationsAvailable(Boolean variationsAvailable) {
        this.variationsAvailable = variationsAvailable;
    }

    @Override
    public Boolean getHasVariations() {
        return hasVariations;
    }

    public void setHasVariations(Boolean hasVariations) {
        this.hasVariations = hasVariations;
    }

    @Override
    public List<Map<String, Object>> getSelectedVariations() {
        return selectedVariations;
    }

    public void setSelectedVariations(List<Map<String, Object>> selectedVariations) {
        this.selectedVariations = selectedVariations;
    }
}
