package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.PropertyValue;

import java.util.List;

public class EtsyPropertyValue implements PropertyValue
{
    @SerializedName(value = "property_id")
    private Long propertyId;

    @SerializedName(value = "property_name")
    private String propertyName;

    @SerializedName(value = "scale_id")
    private Long scaleId;

    @SerializedName(value = "scale_name")
    private String scaleName;

    @SerializedName(value = "value_ids")
    private List<Long> valueIds;

    private List<String> values;

    @Override
    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    @Override
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    @Override
    public Long getScaleId() {
        return scaleId;
    }

    public void setScaleId(Long scaleId) {
        this.scaleId = scaleId;
    }

    @Override
    public String getScaleName() {
        return scaleName;
    }

    public void setScaleName(String scaleName) {
        this.scaleName = scaleName;
    }

    @Override
    public List<Long> getValueIds() {
        return valueIds;
    }

    public void setValueIds(List<Long> valueIds) {
        this.valueIds = valueIds;
    }

    @Override
    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
