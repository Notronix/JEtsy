package com.notronix.etsy.impl.listings.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.gson.GsonFactory;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.common.method.OAuthMethod;
import com.notronix.etsy.api.listings.method.UpdateVariationImagesMethod;
import com.notronix.etsy.api.listings.model.ListingVariationImage;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.EtsyPageableResponse;
import com.notronix.etsy.impl.listings.model.EtsyListingVariationImage;

import java.util.List;

import static java.util.Collections.singletonMap;
import static java.util.Objects.requireNonNull;

public class EtsyUpdateVariationImagesMethod extends AbstractEtsyMethod<PageableResponse<ListingVariationImage>>
        implements UpdateVariationImagesMethod<HttpContent>, OAuthMethod
{
    private AccessToken accessToken;
    private Long shopId;
    private Long listingId;
    private List<? extends ListingVariationImage> variationImages;

    @Override
    public PageableResponse<ListingVariationImage> buildResponseBody(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload,
                new TypeToken<EtsyPageableResponse<EtsyListingVariationImage>>(){}.getType());
    }

    @Override
    protected String getURI() {
        return "/application/shops/" + requireNonNull(shopId) + "/listings/"
                + requireNonNull(listingId) + "/variation-images";
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.POST;
    }

    @Override
    public HttpContent buildRequestContent(Marshaller marshaller) {
        return new JsonHttpContent(GsonFactory.getDefaultInstance(),
                singletonMap("variation_images", requireNonNull(variationImages)));
    }

    @Override
    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public EtsyUpdateVariationImagesMethod withAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public Long getShopId() {
        return shopId;
    }

    @Override
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public EtsyUpdateVariationImagesMethod withShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }

    public Long getListingId() {
        return listingId;
    }

    @Override
    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public EtsyUpdateVariationImagesMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }

    public List<? extends ListingVariationImage> getVariationImages() {
        return variationImages;
    }

    @Override
    public void setVariationImages(List<? extends ListingVariationImage> variationImages) {
        this.variationImages = variationImages;
    }

    public EtsyUpdateVariationImagesMethod withVariationImages(List<? extends ListingVariationImage> variationImages) {
        this.variationImages = variationImages;
        return this;
    }
}
