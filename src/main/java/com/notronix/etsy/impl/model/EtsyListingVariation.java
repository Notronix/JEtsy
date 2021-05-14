package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.ListingVariation;

public class EtsyListingVariation implements ListingVariation
{
    @SerializedName(value = "property_id")
    private Long propertyId;

    @SerializedName(value = "value_id")
    private Long valueId;

    @SerializedName(value = "formatted_name")
    private String formattedName;

    @SerializedName(value = "formatted_value")
    private String formattedValue;

    @Override
    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    @Override
    public Long getValueId() {
        return valueId;
    }

    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }

    @Override
    public String getFormattedName() {
        return formattedName;
    }

    public void setFormattedName(String formattedName) {
        this.formattedName = formattedName;
    }

    @Override
    public String getFormattedValue() {
        return formattedValue;
    }

    public void setFormattedValue(String formattedValue) {
        this.formattedValue = formattedValue;
    }
}
