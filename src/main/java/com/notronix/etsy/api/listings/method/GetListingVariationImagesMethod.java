package com.notronix.etsy.api.listings.method;

import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.common.method.EtsyParameter;
import com.notronix.etsy.api.common.method.Method;
import com.notronix.etsy.api.common.method.ParameterPosition;
import com.notronix.etsy.api.listings.model.ListingVariationImage;

public interface GetListingVariationImagesMethod<C> extends Method<PageableResponse<ListingVariationImage>, C>
{
    @EtsyParameter(position = ParameterPosition.PATH)
    void setShopId(Long shopId);

    @EtsyParameter(position = ParameterPosition.PATH)
    void setListingId(Long listingId);
}
