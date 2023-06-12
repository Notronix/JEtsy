package com.notronix.etsy.impl.listings.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.gson.GsonFactory;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.common.method.OAuthMethod;
import com.notronix.etsy.api.listings.method.UpdateListingInventoryMethod;
import com.notronix.etsy.api.listings.model.ListingInventory;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.listings.model.EtsyListingInventory;

import static java.util.Objects.requireNonNull;

public class EtsyUpdateListingInventoryMethod extends AbstractEtsyMethod<ListingInventory>
    implements UpdateListingInventoryMethod<HttpContent>, OAuthMethod
{
    private AccessToken accessToken;
    private Long listingId;
    private ListingInventory inventory;

    @Override
    public EtsyListingInventory buildResponseBody(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, EtsyListingInventory.class);
    }

    @Override
    protected String getURI() {
        return "/application/listings/" + requireNonNull(listingId) + "/inventory";
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.PUT;
    }

    @Override
    public HttpContent buildRequestContent(Marshaller marshaller) {
        requireNonNull(inventory.getProducts());

        return new JsonHttpContent(GsonFactory.getDefaultInstance(), inventory);
    }

    @Override
    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public EtsyUpdateListingInventoryMethod withAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public Long getListingId() {
        return listingId;
    }

    @Override
    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public EtsyUpdateListingInventoryMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }

    public ListingInventory getInventory() {
        return inventory;
    }

    @Override
    public void setInventory(ListingInventory inventory) {
        this.inventory = inventory;
    }

    public EtsyUpdateListingInventoryMethod withInventory(ListingInventory inventory) {
        this.inventory = inventory;
        return this;
    }
}
