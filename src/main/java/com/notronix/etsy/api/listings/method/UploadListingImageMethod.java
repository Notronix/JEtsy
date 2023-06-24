package com.notronix.etsy.api.listings.method;

import com.notronix.etsy.api.common.method.EtsyParameter;
import com.notronix.etsy.api.common.method.Method;
import com.notronix.etsy.api.common.method.ParameterPosition;
import com.notronix.etsy.api.listings.model.ListingImage;

import java.io.File;

public interface UploadListingImageMethod<C> extends Method<ListingImage, C>
{
    Integer MAX_ALT_TEXT_LENGTH = 250;

    @EtsyParameter(nullable = false, position = ParameterPosition.PATH)
    void setShopId(Long shopId);

    @EtsyParameter(nullable = false, position = ParameterPosition.PATH)
    void setListingId(Long listingId);

    @EtsyParameter(nullable = false)
    void setImageFile(File file);

    @EtsyParameter
    void setRank(Integer rank);

    @EtsyParameter
    void setOverwrite(Boolean overwrite);

    @EtsyParameter
    void setWatermarked(Boolean watermarked);

    @EtsyParameter
    void setAltText(String altText);
}
