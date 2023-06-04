package com.notronix.etsy.impl.listings.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.gson.GsonFactory;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.listings.model.ListingInventory;
import com.notronix.etsy.impl.EtsyMethod;
import com.notronix.etsy.impl.listings.model.EtsyListingInventory;

import static java.util.Objects.requireNonNull;

public class UpdateListingInventoryMethod extends EtsyMethod<EtsyListingInventory>
{
    private Long listingId;
    private ListingInventory inventory;

    public UpdateListingInventoryMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public EtsyListingInventory getResponse(Unmarshaller unmarshaller, String payload) {
        return null;
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
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public HttpContent getContent(Marshaller marshaller) {
        requireNonNull(inventory);
        requireNonNull(inventory.getProducts());

        return new JsonHttpContent(GsonFactory.getDefaultInstance(), inventory);
    }

    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public UpdateListingInventoryMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }

    public ListingInventory getInventory() {
        return inventory;
    }

    public void setInventory(ListingInventory inventory) {
        this.inventory = inventory;
    }

    public UpdateListingInventoryMethod withInventory(ListingInventory inventory) {
        this.inventory = inventory;
        return this;
    }
}
