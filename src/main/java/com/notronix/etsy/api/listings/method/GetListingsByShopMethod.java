package com.notronix.etsy.api.listings.method;

import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.common.method.EtsyParameter;
import com.notronix.etsy.api.common.method.Method;
import com.notronix.etsy.api.common.method.ParameterPosition;
import com.notronix.etsy.api.listings.model.*;

public interface GetListingsByShopMethod<C> extends Method<PageableResponse<Listing>, C>
{
    @EtsyParameter(nullable = false, position = ParameterPosition.PATH)
    void setShopId(Long shopId);

    @EtsyParameter
    void setState(ListingState state);

    @EtsyParameter
    void setSortBy(ListingSort sortBy);

    @EtsyParameter
    void setSortOrder(SortOrder order);

    @EtsyParameter
    void setIncludes(ListingIncludes[] includes);
}
