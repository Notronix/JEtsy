package com.notronix.etsy.api.listings.method;

import com.notronix.etsy.api.Resource;
import com.notronix.etsy.api.authentication.model.AccessToken;

public interface ListingResource<C> extends Resource
{
    CreateDraftListingMethod<C> createCreateDraftListingMethod(AccessToken accessToken);

    GetListingInventoryMethod<C> createGetListingInventoryMethod(AccessToken accessToken);

    GetListingsByShopMethod<C> createGetListingsByShopMethod(AccessToken accessToken);

    GetListingMethod<C> createGetListingMethod();

    UpdateListingInventoryMethod<C> createUpdateListingInventoryMethod(AccessToken accessToken);

    UploadListingImageMethod<C> createUploadListingImageMethod(AccessToken accessToken);

    GetListingImageMethod<C> createGetListingImageMethod();

    GetListingVariationImagesMethod<C> createGetListingVariationImagesMethod();

    UpdateVariationImagesMethod<C> createUpdateVariationImagesMethod(AccessToken accessToken);
}
