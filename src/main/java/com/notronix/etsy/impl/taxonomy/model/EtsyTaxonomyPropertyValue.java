package com.notronix.etsy.impl.taxonomy.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.taxonomy.model.TaxonomyPropertyValue;

import java.util.List;

public class EtsyTaxonomyPropertyValue implements TaxonomyPropertyValue
{
    @SerializedName(value = "value_id")
    private Long valueId;
    private String name;

    @SerializedName(value = "scale_id")
    private Long scaleId;

    @SerializedName(value = "equal_to")
    private List<Long> equalTo;

    @Override
    public Long getValueId() {
        return valueId;
    }

    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getScaleId() {
        return scaleId;
    }

    public void setScaleId(Long scaleId) {
        this.scaleId = scaleId;
    }

    @Override
    public List<Long> getEqualTo() {
        return equalTo;
    }

    public void setEqualTo(List<Long> equalTo) {
        this.equalTo = equalTo;
    }
}
