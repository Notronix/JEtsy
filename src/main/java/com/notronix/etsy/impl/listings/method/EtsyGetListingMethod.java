package com.notronix.etsy.impl.listings.method;

import com.google.api.client.http.HttpContent;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.listings.method.GetListingMethod;
import com.notronix.etsy.api.listings.model.Listing;
import com.notronix.etsy.api.listings.model.ListingIncludes;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.listings.model.EtsyListing;

import static com.notronix.etsy.api.MethodUtils.addIncludes;
import static com.notronix.etsy.api.MethodUtils.addIfProvided;
import static java.util.Objects.requireNonNull;

public class EtsyGetListingMethod extends AbstractEtsyMethod<Listing> implements GetListingMethod<HttpContent>
{
    private Long listingId;
    private String language;
    private ListingIncludes[] includes;

    public EtsyListing buildResponseBody(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, EtsyListing.class);
    }

    @Override
    protected String getURI() {
        String uri = "/application/listings/" + requireNonNull(listingId);
        uri = addIfProvided(uri, "language", language);
        uri = addIncludes(uri, includes);

        return uri;
    }

    public Long getListingId() {
        return listingId;
    }

    public EtsyGetListingMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public EtsyGetListingMethod withLanguage(String language) {
        this.language = language;
        return this;
    }

    public ListingIncludes[] getIncludes() {
        return includes;
    }

    public void setIncludes(ListingIncludes[] includes) {
        this.includes = includes;
    }

    public EtsyGetListingMethod withIncludes(ListingIncludes[] includes) {
        this.includes = includes;
        return this;
    }
}
