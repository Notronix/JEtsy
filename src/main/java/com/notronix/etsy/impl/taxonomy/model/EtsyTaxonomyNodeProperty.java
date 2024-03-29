package com.notronix.etsy.impl.taxonomy.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.taxonomy.model.TaxonomyNodeProperty;

import java.util.List;

public class EtsyTaxonomyNodeProperty implements TaxonomyNodeProperty
{
    @SerializedName(value = "property_id")
    private Long propertyId;
    private String name;

    @SerializedName("display_name")
    private String displayName;
    private List<EtsyTaxonomyPropertyScale> scales;

    @SerializedName("is_required")
    private Boolean required;

    @SerializedName("supports_attributes")
    private Boolean supportsAttributes;

    @SerializedName("supports_variations")
    private Boolean supportsVariations;

    @SerializedName("is_multivalued")
    private Boolean multiValued;

    @SerializedName("max_values_allowed")
    private Integer maxValuesAllowed;

    @SerializedName("possible_values")
    private List<EtsyTaxonomyPropertyValue> possibleValues;

    @SerializedName("selected_values")
    private List<EtsyTaxonomyPropertyValue> selectedValues;

    @Override
    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public List<EtsyTaxonomyPropertyScale> getScales() {
        return scales;
    }

    public void setScales(List<EtsyTaxonomyPropertyScale> scales) {
        this.scales = scales;
    }

    @Override
    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    @Override
    public Boolean getSupportsAttributes() {
        return supportsAttributes;
    }

    public void setSupportsAttributes(Boolean supportsAttributes) {
        this.supportsAttributes = supportsAttributes;
    }

    @Override
    public Boolean getSupportsVariations() {
        return supportsVariations;
    }

    public void setSupportsVariations(Boolean supportsVariations) {
        this.supportsVariations = supportsVariations;
    }

    @Override
    public Boolean getMultiValued() {
        return multiValued;
    }

    public void setMultiValued(Boolean multiValued) {
        this.multiValued = multiValued;
    }

    @Override
    public Integer getMaxValuesAllowed() {
        return maxValuesAllowed;
    }

    public void setMaxValuesAllowed(Integer maxValuesAllowed) {
        this.maxValuesAllowed = maxValuesAllowed;
    }

    @Override
    public List<EtsyTaxonomyPropertyValue> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(List<EtsyTaxonomyPropertyValue> possibleValues) {
        this.possibleValues = possibleValues;
    }

    @Override
    public List<EtsyTaxonomyPropertyValue> getSelectedValues() {
        return selectedValues;
    }

    public void setSelectedValues(List<EtsyTaxonomyPropertyValue> selectedValues) {
        this.selectedValues = selectedValues;
    }
}
