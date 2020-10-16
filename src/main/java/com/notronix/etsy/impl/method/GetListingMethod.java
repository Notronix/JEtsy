package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.authentication.Credentials;
import com.notronix.etsy.api.model.ListingAssociations;
import com.notronix.etsy.impl.model.EtsyListing;

import java.util.List;

import static com.notronix.etsy.impl.method.MethodUtils.addIfProvided;
import static com.notronix.etsy.impl.method.MethodUtils.safeList;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.joining;

public class GetListingMethod extends AbstractEtsyMethod<List<EtsyListing>>
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
    public List<EtsyListing> getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyListing>> response
                = gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyListing>>>(){}.getType());

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
