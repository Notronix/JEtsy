package com.notronix.etsy.impl.v2.method.listings;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.v2.model.listings.ListingAssociations;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.listings.EtsyListing;

import java.util.List;

import static com.notronix.etsy.impl.EtsyMethodUtils.addIfProvided;
import static com.notronix.etsy.impl.EtsyMethodUtils.safeList;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.joining;

public class GetListingMethod extends EtsyMethod<List<EtsyListing>>
{
    private List<Long> listingIds;
    private ListingAssociations[] associations;

    public GetListingMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public String getURI() {
        String uri = "/listings/"
                + requireNonNull(listingIds).stream().map(Object::toString).distinct().collect(joining(","));
        uri = addIfProvided(uri, "includes", safeList(associations), ASSOCIATIONS_CONVERTER);

        return uri;
    }

    @Override
    public List<EtsyListing> getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyResponse<List<EtsyListing>> response
                = unmarshaller.unmarshal(payload, new TypeToken<EtsyResponse<List<EtsyListing>>>(){}.getType());

        return response.getResults();
    }

    public List<Long> getListingIds() {
        return listingIds;
    }

    public void setListingIds(List<Long> listingIds) {
        this.listingIds = listingIds;
    }

    public GetListingMethod withListingIds(List<Long> listingIds) {
        this.listingIds = listingIds;
        return this;
    }

    public ListingAssociations[] getAssociations() {
        return associations;
    }

    public void setAssociations(ListingAssociations[] associations) {
        this.associations = associations;
    }

    public GetListingMethod withAssociations(ListingAssociations[] associations) {
        this.associations = associations;
        return this;
    }
}
