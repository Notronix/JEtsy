package com.notronix.etsy.api.listings.method;

import com.notronix.etsy.api.common.method.EtsyParameter;
import com.notronix.etsy.api.common.method.Method;
import com.notronix.etsy.api.common.method.ParameterPosition;
import com.notronix.etsy.api.listings.model.ListingImage;

public interface GetListingImageMethod<C> extends Method<ListingImage, C>
{
    @EtsyParameter(nullable = false, position = ParameterPosition.PATH)
    void setListingId(Long listingId);
    @EtsyParameter(nullable = false, position = ParameterPosition.PATH)
    void setImageId(Long imageId);
}
