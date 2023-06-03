package com.notronix.etsy.impl.listings;

import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.listings.ListingResource;
import com.notronix.etsy.api.listings.model.ListingIncludes;
import com.notronix.etsy.api.listings.model.ListingState;
import com.notronix.etsy.impl.EtsyMethodExecutor;
import com.notronix.etsy.impl.EtsyResource;
import com.notronix.etsy.impl.listings.method.GetListingMethod;
import com.notronix.etsy.impl.listings.method.GetListingsByShopMethod;
import com.notronix.etsy.impl.listings.model.EtsyListing;
import com.notronix.etsy.impl.listings.model.ListingSort;
import com.notronix.etsy.impl.listings.model.SortOrder;

public class EtsyListingResource extends EtsyResource implements ListingResource
{

    public EtsyListingResource(EtsyMethodExecutor executor, Credentials clientCredentials) {
        super(executor, clientCredentials);
    }

    @Override
    public PageableResponse<EtsyListing> getListingsByShop(Credentials accessCredentials, Long shopId, ListingState state,
                                                           ListingSort sortedBy, SortOrder sortOrder,
                                                           Integer limit, Integer offset, ListingIncludes... includes)
            throws EtsyException {
        return getExecutor().execute(new GetListingsByShopMethod(getClientCredentials(), accessCredentials)
                .withShopId(shopId).withState(state).sortedBy(sortedBy).withSortOrder(sortOrder).withIncludes(includes)
                .withLimit(limit).withOffset(offset));
    }

    @Override
    public EtsyListing getListing(Long listingId, String language, ListingIncludes... includes) throws EtsyException {
        return getExecutor().execute(new GetListingMethod(getClientCredentials()).withListingId(listingId)
                .withLanguage(language).withIncludes(includes));
    }
}
