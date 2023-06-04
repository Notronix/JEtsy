package com.notronix.etsy.impl.listings.method;

import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.listings.model.InventoryIncludes;
import com.notronix.etsy.impl.EtsyMethod;
import com.notronix.etsy.impl.listings.model.EtsyListingInventory;

import static com.notronix.etsy.impl.EtsyMethodUtils.addIfProvided;
import static com.notronix.etsy.impl.EtsyMethodUtils.addIncludes;
import static java.util.Objects.requireNonNull;

public class GetListingInventoryMethod extends EtsyMethod<EtsyListingInventory>
{
    private Long listingId;
    private Boolean showDeleted;
    private InventoryIncludes[] includes;

    public GetListingInventoryMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public EtsyListingInventory getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, EtsyListingInventory.class);
    }

    @Override
    protected String getURI() {
        String uri = "/application/listings/" + requireNonNull(listingId) + "/inventory";
        uri = addIfProvided(uri, "show_deleted", showDeleted);
        uri = addIncludes(uri, includes);

        return uri;
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public GetListingInventoryMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }

    public Boolean getShowDeleted() {
        return showDeleted;
    }

    public void setShowDeleted(Boolean showDeleted) {
        this.showDeleted = showDeleted;
    }

    public GetListingInventoryMethod withShowDeleted(Boolean showDeleted) {
        this.showDeleted = showDeleted;
        return this;
    }

    public InventoryIncludes[] getIncludes() {
        return includes;
    }

    public void setIncludes(InventoryIncludes[] includes) {
        this.includes = includes;
    }

    public GetListingInventoryMethod withIncludes(InventoryIncludes[] includes) {
        this.includes = includes;
        return this;
    }
}
