package com.notronix.etsy.api.listings.method;

import com.notronix.etsy.api.Resource;
import com.notronix.etsy.api.authentication.model.AccessToken;

import java.util.function.Predicate;

import static java.util.Objects.nonNull;

public interface ListingResource<C> extends Resource
{
    Predicate<Integer> QUANTITY_VALIDATOR = quantity -> (nonNull(quantity) && quantity > 0);
    Predicate<Float> PRICE_VALIDATOR = price -> (nonNull(price) && price > 0.00);
    Predicate<Long> TAXONOMY_ID_VALIDATOR = taxonomyId -> (nonNull(taxonomyId) && taxonomyId > 0);

    CreateDraftListingMethod<C> createCreateDraftListingMethod(AccessToken accessToken);

    GetListingInventoryMethod<C> createGetListingInventoryMethod(AccessToken accessToken);

    GetListingsByShopMethod<C> createGetListingsByShopMethod(AccessToken accessToken);

    GetListingMethod<C> createGetListingMethod();

    UpdateListingInventoryMethod<C> createUpdateListingInventoryMethod(AccessToken accessToken);

    UploadListingImageMethod<C> createUploadListingImageMethod(AccessToken accessToken);

    GetListingImageMethod<C> createGetListingImageMethod();

    GetListingVariationImagesMethod<C> createGetListingVariationImagesMethod();

    UpdateVariationImagesMethod<C> createUpdateVariationImagesMethod(AccessToken accessToken);

    UpdateListingMethod<C> createUpdateListingMethod(AccessToken accessToken);
}
