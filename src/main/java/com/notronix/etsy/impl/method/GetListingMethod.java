package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.model.ListingAssociations;
import com.notronix.etsy.impl.model.EtsyListing;

import java.util.List;

import static com.notronix.etsy.impl.method.MethodUtils.addIfProvided;
import static com.notronix.etsy.impl.method.MethodUtils.safeList;

public class GetListingMethod extends AbstractEtsyMethod<EtsyListing>
{
    private Long listingId;
    private ListingAssociations[] associations;

    @Override
    public String getURI() {
        String uri = "/listings/" + listingId;
        uri = addIfProvided(uri, "includes", safeList(associations), ASSOCIATIONS_CONVERTER);

        return uri;
    }

    @Override
    public EtsyListing getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyListing>> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyListing>>>(){}.getType());

        return response.getResults().stream().findAny().orElse(null);
    }

    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public GetListingMethod withListingId(Long listingId) {
        this.listingId = listingId;
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
