package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.impl.model.EtsyListingVariationImage;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class GetVariationImagesMethod extends AbstractEtsyMethod<List<EtsyListingVariationImage>>
{
    private Long listingId;

    @Override
    String getURI() {
        return "/listings/" + requireNonNull(listingId) + "/variation-images";
    }

    @Override
    public List<EtsyListingVariationImage> getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyListingVariationImage>> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyListingVariationImage>>>(){}.getType());

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
