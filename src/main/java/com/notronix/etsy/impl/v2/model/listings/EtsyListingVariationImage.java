package com.notronix.etsy.impl.v2.model.listings;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.v2.model.listings.ListingVariationImage;

public class EtsyListingVariationImage implements ListingVariationImage
{
    @SerializedName(value = "property_id")
    private Long propertyId;

    @SerializedName(value = "value_id")
    private Long valueId;

    @SerializedName(value = "image_id")
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
