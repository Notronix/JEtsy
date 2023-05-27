package com.notronix.etsy.impl.model.taxonomy;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.taxonomy.TaxonomyPropertyScale;

public class EtsyTaxonomyPropertyScale implements TaxonomyPropertyScale
{
    @SerializedName(value = "scale_id")
    private Long scaleId;

    @SerializedName(value = "display_name")
    private String displayName;
    private String description;

    @Override
    public Long getScaleId() {
        return scaleId;
    }

    public void setScaleId(Long scaleId) {
        this.scaleId = scaleId;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
