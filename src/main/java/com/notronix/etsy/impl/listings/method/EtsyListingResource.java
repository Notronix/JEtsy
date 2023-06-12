package com.notronix.etsy.impl.listings.method;

import com.google.api.client.http.HttpContent;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.listings.method.*;

public class EtsyListingResource implements ListingResource<HttpContent>
{
    @Override
    public CreateDraftListingMethod<HttpContent> createCreateDraftListingMethod(AccessToken accessToken) {
        return new EtsyCreateDraftListingMethod().withAccessToken(accessToken);
    }

    @Override
    public GetListingInventoryMethod<HttpContent> createGetListingInventoryMethod(AccessToken accessToken) {
        return new EtsyGetListingInventoryMethod().withAccessToken(accessToken);
    }

    @Override
    public GetListingsByShopMethod<HttpContent> createGetListingsByShopMethod(AccessToken accessToken) {
        return new EtsyGetListingsByShopMethod().withAccessToken(accessToken);
    }

    @Override
    public GetListingMethod<HttpContent> createGetListingMethod() {
        return new EtsyGetListingMethod();
    }

    @Override
    public UpdateListingInventoryMethod<HttpContent> createUpdateListingInventoryMethod(AccessToken accessToken) {
        return new EtsyUpdateListingInventoryMethod().withAccessToken(accessToken);
    }

    @Override
    public UploadListingImageMethod<HttpContent> createUploadListingImageMethod(AccessToken accessToken) {
        return new EtsyUploadListingImageMethod().withAccessToken(accessToken);
    }

    @Override
    public GetListingImageMethod<HttpContent> createGetListingImageMethod() {
        return new EtsyGetListingImageMethod();
    }

    @Override
    public GetListingVariationImagesMethod<HttpContent> createGetListingVariationImagesMethod() {
        return new EtsyGetListingVariationImagesMethod();
    }

    @Override
    public UpdateVariationImagesMethod<HttpContent> createUpdateVariationImagesMethod(AccessToken accessToken) {
        return new EtsyUpdateVariationImagesMethod().withAccessToken(accessToken);
    }
}
