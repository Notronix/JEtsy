package com.notronix.etsy.impl.listings.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.listings.model.ListingVariationImage;

public class EtsyListingVariationImage implements ListingVariationImage
{
    @SerializedName("property_id")
    private Long propertyId;

    @SerializedName("value_id")
    private Long valueId;

    @SerializedName("image_id")
    private Long imageId;

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
    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }
}
