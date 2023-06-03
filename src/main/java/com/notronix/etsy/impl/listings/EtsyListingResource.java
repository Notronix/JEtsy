package com.notronix.etsy.impl.listings;

import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.common.model.DimensionUnit;
import com.notronix.etsy.api.common.model.WeightUnit;
import com.notronix.etsy.api.listings.ListingResource;
import com.notronix.etsy.api.listings.model.*;
import com.notronix.etsy.impl.EtsyMethodExecutor;
import com.notronix.etsy.impl.EtsyResource;
import com.notronix.etsy.impl.listings.method.CreateDraftListingMethod;
import com.notronix.etsy.impl.listings.method.GetListingMethod;
import com.notronix.etsy.impl.listings.method.GetListingsByShopMethod;
import com.notronix.etsy.impl.listings.model.EtsyListing;
import com.notronix.etsy.impl.listings.model.ListingSort;
import com.notronix.etsy.impl.listings.model.SortOrder;

import java.util.List;

public class EtsyListingResource extends EtsyResource implements ListingResource
{

    public EtsyListingResource(EtsyMethodExecutor executor, Credentials clientCredentials) {
        super(executor, clientCredentials);
    }

    @Override
    public PageableResponse<EtsyListing> getListingsByShop(Credentials accessCredentials, Long shopId, ListingState state,
                                                           ListingSort sortedBy, SortOrder sortOrder,
                                                           Integer limit, Integer offset, ListingIncludes... includes)
            throws EtsyException {
        return getExecutor().execute(new GetListingsByShopMethod(getClientCredentials(), accessCredentials)
                .withShopId(shopId).withState(state).sortedBy(sortedBy).withSortOrder(sortOrder).withIncludes(includes)
                .withLimit(limit).withOffset(offset));
    }

    @Override
    public EtsyListing getListing(Long listingId, String language, ListingIncludes... includes) throws EtsyException {
        return getExecutor().execute(new GetListingMethod(getClientCredentials()).withListingId(listingId)
                .withLanguage(language).withIncludes(includes));
    }

    @Override
    public Listing createDraftListing(Credentials accessCredentials, Long shopId, Integer quantity, String title, String description,
                                      Float price, WhoMade whoMade, WhenMade whenMade, Long taxonomyId, Long shippingProfileId,
                                      Long returnPolicyId, List<String> materials, Long shopSectionId, Integer processingMin,
                                      Integer processingMax, List<String> tags, List<String> styles, Float weight, Float length,
                                      Float width, Float height, WeightUnit weightUnit, DimensionUnit dimensionUnit,
                                      Boolean personalizable, Boolean personalizationRequired, Integer maxPersonalizationCharacterCount,
                                      String personalizationInstructions, List<Long> productionPartnerIds, List<Long> imageIds,
                                      Boolean supply, Boolean customizable, Boolean shouldAutoRenew, Boolean taxable, ListingType type)
            throws EtsyException {
        return getExecutor().execute(new CreateDraftListingMethod(getClientCredentials(), accessCredentials)
                .withShopId(shopId).withQuantity(quantity).withTitle(title).withDescription(description).withPrice(price)
                .withWhoMade(whoMade).withWhenMade(whenMade).withTaxonomyId(taxonomyId).withShippingProfileId(shippingProfileId)
                .withReturnPolicyId(returnPolicyId).withMaterials(materials).withShopSectionId(shopSectionId).withProcessingMin(processingMin)
                .withProcessingMax(processingMax).withTags(tags).withStyles(styles).withWeight(weight).withLength(length)
                .withWidth(width).withHeight(height).withWeightUnit(weightUnit).withDimensionUnit(dimensionUnit)
                .withPersonalizable(personalizable).withPersonalizationRequired(personalizationRequired)
                .withMaxPersonalizationCharacterCount(maxPersonalizationCharacterCount)
                .withPersonalizationInstructions(personalizationInstructions).withProductionPartnerIds(productionPartnerIds)
                .withImageIds(imageIds).withSupply(supply).withCustomizable(customizable).withShouldAutoRenew(shouldAutoRenew)
                .withTaxable(taxable).withType(type));
    }
}
