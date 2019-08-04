package com.notronix.etsy.impl.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.model.ListingVariationImage;
import com.notronix.etsy.impl.model.EtsyListingVariationImage;

import java.util.List;

import static java.util.Collections.singletonMap;
import static java.util.Objects.requireNonNull;

public class UpdateVariationImagesMethod extends AbstractEtsyMethod<List<EtsyListingVariationImage>>
{
    private Long listingId;
    private List<? extends ListingVariationImage> variationImages;

    @Override
    String getURI() {
        return "/listings/" + listingId + "/variation-images";
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.POST;
    }

    @Override
    public HttpContent getContent(Gson gson) {
        return new UrlEncodedContent(singletonMap("variation_images", gson.toJson(requireNonNull(variationImages))));
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

    public UpdateVariationImagesMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }

    public List<? extends ListingVariationImage> getVariationImages() {
        return variationImages;
    }

    public void setVariationImages(List<? extends ListingVariationImage> variationImages) {
        this.variationImages = variationImages;
    }

    public UpdateVariationImagesMethod withVariationImages(List<? extends ListingVariationImage> variationImages) {
        this.variationImages = variationImages;
        return this;
    }
}
