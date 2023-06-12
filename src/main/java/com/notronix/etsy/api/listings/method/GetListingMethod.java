package com.notronix.etsy.api.listings.method;

import com.notronix.etsy.api.common.method.EtsyParameter;
import com.notronix.etsy.api.common.method.Method;
import com.notronix.etsy.api.common.method.ParameterPosition;
import com.notronix.etsy.api.listings.model.Listing;
import com.notronix.etsy.api.listings.model.ListingIncludes;

public interface GetListingMethod<C> extends Method<Listing, C>
{
    @EtsyParameter(nullable = false, position = ParameterPosition.PATH)
    void setListingId(Long listingId);

    @EtsyParameter(position = ParameterPosition.QUERY)
    void setLanguage(String language);

    @EtsyParameter(position = ParameterPosition.QUERY)
    void setIncludes(ListingIncludes[] includes);
}
