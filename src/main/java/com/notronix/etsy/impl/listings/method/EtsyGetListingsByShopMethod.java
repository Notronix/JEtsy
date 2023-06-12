package com.notronix.etsy.impl.listings.method;

import com.google.api.client.http.HttpContent;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.common.method.OAuthMethod;
import com.notronix.etsy.api.common.method.PageableMethod;
import com.notronix.etsy.api.listings.method.GetListingsByShopMethod;
import com.notronix.etsy.api.listings.model.*;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.EtsyPageableResponse;
import com.notronix.etsy.impl.listings.model.EtsyListing;

import static com.notronix.etsy.api.MethodUtils.addIfProvided;
import static com.notronix.etsy.api.MethodUtils.addIncludes;
import static java.util.Objects.requireNonNull;

public class EtsyGetListingsByShopMethod extends AbstractEtsyMethod<PageableResponse<Listing>>
        implements GetListingsByShopMethod<HttpContent>, OAuthMethod, PageableMethod
{
    private AccessToken accessToken;
    private Long shopId;
    private ListingState state;
    private ListingSort sortBy;
    private SortOrder sortOrder;
    private ListingIncludes[] includes;
    private Integer limit;
    private Integer offset;

    @Override
    public PageableResponse<Listing> buildResponseBody(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload,
                new TypeToken<EtsyPageableResponse<EtsyListing>>(){}.getType());
    }

    @Override
    protected String getURI() {
        String baseURI = "/application/shops/" + requireNonNull(shopId) + "/listings";
        baseURI = addIfProvided(baseURI, "state", state);
        baseURI = addIfProvided(baseURI, "sort_on", sortBy);
        baseURI = addIfProvided(baseURI, "sort_order", sortOrder);
        baseURI = addPageableParameters(baseURI, this, true);
        baseURI = addIncludes(baseURI, includes);

        return baseURI;
    }

    @Override
    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public EtsyGetListingsByShopMethod withAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public Long getShopId() {
        return shopId;
    }

    @Override
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public EtsyGetListingsByShopMethod withShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }

    public ListingState getState() {
        return state;
    }

    @Override
    public void setState(ListingState state) {
        this.state = state;
    }

    public EtsyGetListingsByShopMethod withState(ListingState state) {
        this.state = state;
        return this;
    }

    public ListingSort getSortBy() {
        return sortBy;
    }

    @Override
    public void setSortBy(ListingSort sortBy) {
        this.sortBy = sortBy;
    }

    public EtsyGetListingsByShopMethod sortedBy(ListingSort sortBy) {
        this.sortBy = sortBy;
        return this;
    }

    public SortOrder getSortOrder() {
        return sortOrder;
    }

    @Override
    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    public EtsyGetListingsByShopMethod withSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public EtsyGetListingsByShopMethod ascending() {
        this.sortOrder = SortOrder.ascending;
        return this;
    }

    public EtsyGetListingsByShopMethod descending() {
        this.sortOrder = SortOrder.descending;
        return this;
    }

    public ListingIncludes[] getIncludes() {
        return includes;
    }

    @Override
    public void setIncludes(ListingIncludes[] includes) {
        this.includes = includes;
    }

    public EtsyGetListingsByShopMethod withIncludes(ListingIncludes[] includes) {
        this.includes = includes;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    @Override
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public EtsyGetListingsByShopMethod withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    @Override
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public EtsyGetListingsByShopMethod withOffset(Integer offset) {
        this.offset = offset;
        return this;
    }
}
