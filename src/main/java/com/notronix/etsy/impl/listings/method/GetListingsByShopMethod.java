package com.notronix.etsy.impl.listings.method;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.listings.model.ListingIncludes;
import com.notronix.etsy.api.listings.model.ListingState;
import com.notronix.etsy.impl.EtsyPageableResponse;
import com.notronix.etsy.impl.PageableEtsyMethod;
import com.notronix.etsy.impl.listings.model.EtsyListing;
import com.notronix.etsy.impl.listings.model.ListingSort;
import com.notronix.etsy.impl.listings.model.SortOrder;

import static com.notronix.etsy.impl.EtsyMethodUtils.*;
import static java.util.Objects.requireNonNull;

public class GetListingsByShopMethod extends PageableEtsyMethod<EtsyListing>
{
    private Long shopId;
    private ListingState state;
    private ListingSort sortBy;
    private SortOrder sortOrder;
    private ListingIncludes[] includes;

    public GetListingsByShopMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public PageableResponse<EtsyListing> getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload,
                new TypeToken<EtsyPageableResponse<EtsyListing>>(){}.getType());
    }

    @Override
    protected String getURI() {
        String baseURI = "/application/shops/" + requireNonNull(shopId) + "/listings";
        baseURI = addIfProvided(baseURI, "state", state);
        baseURI = addIfProvided(baseURI, "sort_on", sortBy);
        baseURI = addIfProvided(baseURI, "sort_order", sortOrder);
        baseURI = addIfProvided(baseURI, "limit", getLimit(), l -> l == null || (l >= 1 && l <= 100), true);
        baseURI = addIfProvided(baseURI, "offset", getOffset(), o -> o == null || o >= 0, true);
        baseURI = addIncludes(baseURI, includes);

        return baseURI;
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public GetListingsByShopMethod withShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }

    public ListingState getState() {
        return state;
    }

    public void setState(ListingState state) {
        this.state = state;
    }

    public GetListingsByShopMethod withState(ListingState state) {
        this.state = state;
        return this;
    }

    public ListingSort getSortBy() {
        return sortBy;
    }

    public void setSortBy(ListingSort sortBy) {
        this.sortBy = sortBy;
    }

    public GetListingsByShopMethod sortedBy(ListingSort sortBy) {
        this.sortBy = sortBy;
        return this;
    }

    public SortOrder getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    public GetListingsByShopMethod withSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public GetListingsByShopMethod ascending() {
        this.sortOrder = SortOrder.ascending;
        return this;
    }

    public GetListingsByShopMethod descending() {
        this.sortOrder = SortOrder.descending;
        return this;
    }

    public ListingIncludes[] getIncludes() {
        return includes;
    }

    public void setIncludes(ListingIncludes[] includes) {
        this.includes = includes;
    }

    public GetListingsByShopMethod withIncludes(ListingIncludes[] includes) {
        this.includes = includes;
        return this;
    }
}
