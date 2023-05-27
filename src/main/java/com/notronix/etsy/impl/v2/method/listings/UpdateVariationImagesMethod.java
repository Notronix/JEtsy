package com.notronix.etsy.impl.v2.method.listings;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.v2.model.listings.ListingVariationImage;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.listings.EtsyListingVariationImage;

import java.util.List;

import static java.util.Collections.singletonMap;
import static java.util.Objects.requireNonNull;

public class UpdateVariationImagesMethod extends EtsyMethod<List<EtsyListingVariationImage>>
{
    private Long listingId;
    private List<? extends ListingVariationImage> variationImages;

    public UpdateVariationImagesMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    protected String getURI() {
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
    public HttpContent getContent(Marshaller marshaller) {
        return new UrlEncodedContent(singletonMap("variation_images",
                marshaller.marshal(requireNonNull(variationImages))));
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
