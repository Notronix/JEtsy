package com.notronix.etsy.impl.listings.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.listings.model.PropertyValue;

import java.util.List;

public class EtsyPropertyValue implements PropertyValue
{
    @SerializedName("property_id")
    private Long id;

    @SerializedName("property_name")
    private String propertyName;

    @SerializedName("scale_id")
    private Long scaleId;

    @SerializedName("scale_name")
    private String scaleName;

    @SerializedName("value_ids")
    private List<Long> valueIds;

    private List<String> values;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
