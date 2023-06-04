package com.notronix.etsy.api.listings;

import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.common.model.DimensionUnit;
import com.notronix.etsy.api.common.model.WeightUnit;
import com.notronix.etsy.api.listings.model.*;

import java.io.File;
import java.util.List;

public interface ListingResource
{
    PageableResponse<? extends Listing> getListingsByShop(Credentials accessCredentials, Long shopId, ListingState state,
                                                          ListingSort sortedBy, SortOrder sortOrder,
                                                          Integer limit, Integer offset, ListingIncludes... includes)
            throws EtsyException;

    Listing getListing(Long listingId, String language, ListingIncludes... includes)
            throws EtsyException;

    Listing createDraftListing(Credentials accessCredentials, Long shopId, Integer quantity, String title, String description,
                               Float price, WhoMade whoMade, WhenMade whenMade, Long taxonomyId, Long shippingProfileId,
                               Long returnPolicyId, List<String> materials, Long shopSectionId, Integer processingMin,
                               Integer processingMax, List<String> tags, List<String> styles, Float weight, Float length,
                               Float width, Float height, WeightUnit weightUnit, DimensionUnit dimensionUnit,
                               Boolean personalizable, Boolean personalizationRequired, Integer maxPersonalizationCharacterCount,
                               String personalizationInstructions, List<Long> productionPartnerIds, List<Long> imageIds,
                               Boolean supply, Boolean customizable, Boolean shouldAutoRenew, Boolean taxable, ListingType type)
            throws EtsyException;

    ListingInventory updateListingInventory(Credentials accessCredentials, Long listingId, ListingInventory inventory)
            throws EtsyException;

    ListingInventory getListingInventory(Credentials accessCredentials, Long listingId, Boolean showDeleted, InventoryIncludes... includes)
            throws EtsyException;

    ListingImage uploadListingImage(Credentials accessCredentials, Long shopId, Long listingId, File imageFile, Integer rank,
                                    Boolean overwrite, Boolean watermarked, String altText)
            throws EtsyException;

    ListingImage getListingImage(Long listingId, Long imageId) throws EtsyException;
}
