package com.notronix.etsy.api.listings;

import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.listings.model.Listing;
import com.notronix.etsy.api.listings.model.ListingIncludes;
import com.notronix.etsy.api.listings.model.ListingState;
import com.notronix.etsy.impl.listings.model.ListingSort;
import com.notronix.etsy.impl.listings.model.SortOrder;

public interface ListingResource
{
    PageableResponse<? extends Listing> getListingsByShop(Credentials accessCredentials, Long shopId, ListingState state,
                                                          ListingSort sortedBy, SortOrder sortOrder,
                                                          Integer limit, Integer offset, ListingIncludes... includes)
            throws EtsyException;

    Listing getListing(Long listingId, String language, ListingIncludes... includes)
            throws EtsyException;
}
