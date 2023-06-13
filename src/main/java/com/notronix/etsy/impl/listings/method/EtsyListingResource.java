package com.notronix.etsy.impl.listings.method;

import com.google.api.client.http.HttpContent;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.listings.method.*;

public class EtsyListingResource implements ListingResource<HttpContent>
{
    @Override
    public EtsyCreateDraftListingMethod createCreateDraftListingMethod(AccessToken accessToken) {
        return new EtsyCreateDraftListingMethod().withAccessToken(accessToken);
    }

    @Override
    public EtsyGetListingInventoryMethod createGetListingInventoryMethod(AccessToken accessToken) {
        return new EtsyGetListingInventoryMethod().withAccessToken(accessToken);
    }

    @Override
    public EtsyGetListingsByShopMethod createGetListingsByShopMethod(AccessToken accessToken) {
        return new EtsyGetListingsByShopMethod().withAccessToken(accessToken);
    }

    @Override
    public EtsyGetListingMethod createGetListingMethod() {
        return new EtsyGetListingMethod();
    }

    @Override
    public EtsyUpdateListingInventoryMethod createUpdateListingInventoryMethod(AccessToken accessToken) {
        return new EtsyUpdateListingInventoryMethod().withAccessToken(accessToken);
    }

    @Override
    public EtsyUploadListingImageMethod createUploadListingImageMethod(AccessToken accessToken) {
        return new EtsyUploadListingImageMethod().withAccessToken(accessToken);
    }

    @Override
    public EtsyGetListingImageMethod createGetListingImageMethod() {
        return new EtsyGetListingImageMethod();
    }

    @Override
    public EtsyGetListingVariationImagesMethod createGetListingVariationImagesMethod() {
        return new EtsyGetListingVariationImagesMethod();
    }

    @Override
    public EtsyUpdateVariationImagesMethod createUpdateVariationImagesMethod(AccessToken accessToken) {
        return new EtsyUpdateVariationImagesMethod().withAccessToken(accessToken);
    }

    @Override
    public UpdateListingMethod<HttpContent> createUpdateListingMethod(AccessToken accessToken) {
        return new EtsyUpdateListingMethod().withAccessToken(accessToken);
    }
}
