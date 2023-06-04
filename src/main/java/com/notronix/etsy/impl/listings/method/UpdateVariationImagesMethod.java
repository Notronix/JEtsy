package com.notronix.etsy.impl.listings.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.gson.GsonFactory;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.listings.model.ListingVariationImage;
import com.notronix.etsy.impl.EtsyMethod;
import com.notronix.etsy.impl.EtsyPageableResponse;
import com.notronix.etsy.impl.listings.model.EtsyListingVariationImage;

import java.util.List;

import static java.util.Collections.singletonMap;
import static java.util.Objects.requireNonNull;

public class UpdateVariationImagesMethod extends EtsyMethod<PageableResponse<EtsyListingVariationImage>>
{
    private Long shopId;
    private Long listingId;
    private List<? extends ListingVariationImage> variationImages;

    public UpdateVariationImagesMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public PageableResponse<EtsyListingVariationImage> getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload,
                new TypeToken<EtsyPageableResponse<EtsyListingVariationImage>>(){}.getType());
    }

    @Override
    protected String getURI() {
        return "/application/shops/" + requireNonNull(shopId) + "/listings/" + requireNonNull(listingId) + "/variation-images";
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.POST;
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public HttpContent getContent(Marshaller marshaller) {
        return new JsonHttpContent(GsonFactory.getDefaultInstance(),
                singletonMap("variation_images", requireNonNull(variationImages)));
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public UpdateVariationImagesMethod withShopId(Long shopId) {
        this.shopId = shopId;
        return this;
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
