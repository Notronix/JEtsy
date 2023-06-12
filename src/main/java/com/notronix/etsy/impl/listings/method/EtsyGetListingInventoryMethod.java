package com.notronix.etsy.impl.listings.method;

import com.google.api.client.http.HttpContent;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.common.method.OAuthMethod;
import com.notronix.etsy.api.listings.method.GetListingInventoryMethod;
import com.notronix.etsy.api.listings.model.InventoryIncludes;
import com.notronix.etsy.api.listings.model.ListingInventory;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.listings.model.EtsyListingInventory;

import static com.notronix.etsy.api.MethodUtils.addIfProvided;
import static com.notronix.etsy.api.MethodUtils.addIncludes;
import static java.util.Objects.requireNonNull;

public class EtsyGetListingInventoryMethod extends AbstractEtsyMethod<ListingInventory>
        implements GetListingInventoryMethod<HttpContent>, OAuthMethod
{
    private AccessToken accessToken;
    private Long listingId;
    private Boolean showDeleted;
    private InventoryIncludes[] includes;

    @Override
    public EtsyListingInventory buildResponseBody(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, EtsyListingInventory.class);
    }

    @Override
    protected String getURI() {
        String uri = "/application/listings/" + requireNonNull(listingId) + "/inventory";
        uri = addIfProvided(uri, "show_deleted", showDeleted);
        uri = addIncludes(uri, includes);

        return uri;
    }

    public Long getListingId() {
        return listingId;
    }

    @Override
    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public EtsyGetListingInventoryMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }

    public Boolean getShowDeleted() {
        return showDeleted;
    }

    @Override
    public void setShowDeleted(Boolean showDeleted) {
        this.showDeleted = showDeleted;
    }

    public EtsyGetListingInventoryMethod withShowDeleted(Boolean showDeleted) {
        this.showDeleted = showDeleted;
        return this;
    }

    public InventoryIncludes[] getIncludes() {
        return includes;
    }

    @Override
    public void setIncludes(InventoryIncludes[] includes) {
        this.includes = includes;
    }

    public EtsyGetListingInventoryMethod withIncludes(InventoryIncludes[] includes) {
        this.includes = includes;
        return this;
    }

    @Override
    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public EtsyGetListingInventoryMethod withAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
        return this;
    }
}
