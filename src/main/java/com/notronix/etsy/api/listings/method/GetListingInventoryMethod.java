package com.notronix.etsy.api.listings.method;

import com.notronix.etsy.api.common.method.EtsyParameter;
import com.notronix.etsy.api.common.method.Method;
import com.notronix.etsy.api.common.method.ParameterPosition;
import com.notronix.etsy.api.listings.model.InventoryIncludes;
import com.notronix.etsy.api.listings.model.ListingInventory;

public interface GetListingInventoryMethod<C> extends Method<ListingInventory, C>
{
    @EtsyParameter(nullable = false, position = ParameterPosition.PATH)
    void setListingId(Long listingId);

    @EtsyParameter(position = ParameterPosition.QUERY)
    void setShowDeleted(Boolean showDeleted);

    @EtsyParameter(position = ParameterPosition.QUERY)
    void setIncludes(InventoryIncludes[] includes);
}
