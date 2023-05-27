package com.notronix.etsy.impl.v2.method.listings;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.listings.EtsyListingVariationImage;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class GetVariationImagesMethod extends EtsyMethod<List<EtsyListingVariationImage>>
{
    private Long listingId;

    public GetVariationImagesMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    protected String getURI() {
        return "/listings/" + requireNonNull(listingId) + "/variation-images";
    }

    @Override
    public List<EtsyListingVariationImage> getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyResponse<List<EtsyListingVariationImage>> response =
                unmarshaller.unmarshal(payload, new TypeToken<EtsyResponse<List<EtsyListingVariationImage>>>(){}.getType());

        return response.getResults();
    }

    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public GetVariationImagesMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }
}
