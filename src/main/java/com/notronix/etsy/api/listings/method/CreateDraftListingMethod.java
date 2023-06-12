package com.notronix.etsy.api.listings.method;

import com.notronix.etsy.api.common.method.EtsyParameter;
import com.notronix.etsy.api.common.method.Method;
import com.notronix.etsy.api.common.method.ParameterPosition;
import com.notronix.etsy.api.common.model.DimensionUnit;
import com.notronix.etsy.api.common.model.WeightUnit;
import com.notronix.etsy.api.listings.model.Listing;
import com.notronix.etsy.api.listings.model.ListingType;
import com.notronix.etsy.api.listings.model.WhenMade;
import com.notronix.etsy.api.listings.model.WhoMade;

import java.util.List;
import java.util.function.Predicate;

import static java.util.Objects.nonNull;

public interface CreateDraftListingMethod<C> extends Method<Listing, C>
{
    @EtsyParameter(nullable = false, position = ParameterPosition.PATH)
    void setShopId(Long shopId);

    @EtsyParameter(nullable = false)
    void setQuantity(Integer quantity);

    @EtsyParameter(nullable = false)
    void setTitle(String title);

    @EtsyParameter(nullable = false)
    void setDescription(String description);

    @EtsyParameter(nullable = false)
    void setPrice(Float price);

    @EtsyParameter(nullable = false)
    void setWhoMade(WhoMade whoMade);

    @EtsyParameter(nullable = false)
    void setWhenMade(WhenMade whenMade);

    @EtsyParameter(nullable = false)
    void setTaxonomyId(Long taxonomyId);

    @EtsyParameter(nullable = false)
    void setShippingProfileId(Long shippingProfileId);

    @EtsyParameter
    void setReturnPolicyId(Long returnPolicyId);

    @EtsyParameter
    void setMaterials(List<String> materials);

    @EtsyParameter
    void setShopSectionId(Long shopSectionId);

    @EtsyParameter
    void setProcessingMin(Integer processingMin);

    @EtsyParameter
    void setProcessingMax(Integer processingMax);

    @EtsyParameter
    void setTags(List<String> tags);

    @EtsyParameter
    void setStyles(List<String> styles);

    @EtsyParameter
    void setWeight(Float weight);

    @EtsyParameter
    void setLength(Float length);

    @EtsyParameter
    void setWidth(Float width);

    @EtsyParameter
    void setHeight(Float height);

    @EtsyParameter
    void setWeightUnit(WeightUnit weightUnit);

    @EtsyParameter
    void setDimensionUnit(DimensionUnit dimensionUnit);

    @EtsyParameter
    void setPersonalizable(Boolean personalizable);

    @EtsyParameter
    void setPersonalizationRequired(Boolean personalizationRequired);

    @EtsyParameter
    void setMaxPersonalizationCharacterCount(Integer maxPersonalizationCharacterCount);

    @EtsyParameter
    void setPersonalizationInstructions(String personalizationInstructions);

    @EtsyParameter
    void setProductionPartnerIds(List<Long> productionPartnerIds);

    @EtsyParameter
    void setImageIds(List<Long> imageIds);

    @EtsyParameter
    void setSupply(Boolean supply);

    @EtsyParameter
    void setCustomizable(Boolean customizable);

    @EtsyParameter
    void setShouldAutoRenew(Boolean shouldAutoRenew);

    @EtsyParameter
    void setTaxable(Boolean taxable);

    @EtsyParameter
    void setType(ListingType type);

    Predicate<Integer> QUANTITY_VALIDATOR = quantity -> (nonNull(quantity) && quantity > 0);
    Predicate<Float> PRICE_VALIDATOR = price -> (nonNull(price) && price > 0.00);
    Predicate<Long> TAXONOMY_ID_VALIDATOR = taxonomyId -> (nonNull(taxonomyId) && taxonomyId > 0);
}
