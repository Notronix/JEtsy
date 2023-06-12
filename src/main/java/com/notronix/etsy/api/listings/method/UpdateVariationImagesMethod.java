package com.notronix.etsy.api.listings.method;

import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.common.method.EtsyParameter;
import com.notronix.etsy.api.common.method.Method;
import com.notronix.etsy.api.common.method.ParameterPosition;
import com.notronix.etsy.api.listings.model.ListingVariationImage;

import java.util.List;

public interface UpdateVariationImagesMethod<C> extends Method<PageableResponse<ListingVariationImage>, C>
{
    @EtsyParameter(nullable = false, position = ParameterPosition.PATH)
    void setShopId(Long shopId);

    @EtsyParameter(nullable = false, position = ParameterPosition.PATH)
    void setListingId(Long listingId);

    @EtsyParameter(nullable = false)
    void setVariationImages(List<? extends ListingVariationImage> variationImages);
}
