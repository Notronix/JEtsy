package com.notronix.etsy.impl.listings.method;

import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.listings.model.ListingIncludes;
import com.notronix.etsy.impl.EtsyMethod;
import com.notronix.etsy.impl.listings.model.EtsyListing;

import static com.notronix.etsy.impl.EtsyMethodUtils.addIncludes;
import static com.notronix.etsy.impl.EtsyMethodUtils.addIfProvided;
import static java.util.Objects.requireNonNull;

public class GetListingMethod extends EtsyMethod<EtsyListing>
{
    private Long listingId;
    private String language;
    private ListingIncludes[] includes;

    public GetListingMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    public EtsyListing getResponse(Unmarshaller unmarshaller, String payload) {
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

    public GetListingMethod withListingId(Long listingId) {
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

    public GetListingMethod withLanguage(String language) {
        this.language = language;
        return this;
    }

    public ListingIncludes[] getIncludes() {
        return includes;
    }

    public void setIncludes(ListingIncludes[] includes) {
        this.includes = includes;
    }

    public GetListingMethod withIncludes(ListingIncludes[] includes) {
        this.includes = includes;
        return this;
    }
}
