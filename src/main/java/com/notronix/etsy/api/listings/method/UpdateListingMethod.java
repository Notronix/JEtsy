package com.notronix.etsy.api.listings.method;

import com.notronix.etsy.api.common.method.EtsyParameter;
import com.notronix.etsy.api.common.method.Method;
import com.notronix.etsy.api.common.method.ParameterPosition;
import com.notronix.etsy.api.common.model.DimensionUnit;
import com.notronix.etsy.api.common.model.WeightUnit;
import com.notronix.etsy.api.listings.model.*;

import java.util.List;

public interface UpdateListingMethod<C> extends Method<Listing, C>
{
    @EtsyParameter(nullable = false, position = ParameterPosition.PATH)
    void setShopId(Long shopId);

    @EtsyParameter(nullable = false, position = ParameterPosition.PATH)
    void setListingId(Long listingId);

    @EtsyParameter
    void setImageIds(List<Long> imageIds);

    @EtsyParameter
    void setTitle(String title);

    @EtsyParameter
    void setDescription(String description);

    @EtsyParameter
    void setMaterials(List<String> materials);

    @EtsyParameter
    void setShouldAutoRenew(Boolean shouldAutoRenew);

    @EtsyParameter
    void setShippingProfileId(Long shippingProfileId);

    @EtsyParameter
    void setReturnPolicyId(Long returnPolicyId);

    @EtsyParameter
    void setShopSectionId(Long shopSectionId);

    @EtsyParameter
    void setWeight(Float itemWeight);

    @EtsyParameter
    void setLength(Float itemLength);

    @EtsyParameter
    void setWidth(Float itemWidth);

    @EtsyParameter
    void setHeight(Float itemHeight);

    @EtsyParameter
    void setWeightUnit(WeightUnit itemWeightUnit);

    @EtsyParameter
    void setDimensionUnit(DimensionUnit itemDimensionUnit);

    @EtsyParameter
    void setTaxable(Boolean taxable);

    @EtsyParameter
    void setTaxonomyId(Long taxonomyId);

    @EtsyParameter
    void setTags(List<String> tags);

    @EtsyParameter
    void setWhoMade(WhoMade whoMade);

    @EtsyParameter
    void setWhenMade(WhenMade whenMade);

    @EtsyParameter
    void setFeaturedRank(Integer featuredRank);

    @EtsyParameter
    void setPersonalizable(Boolean personalizable);

    @EtsyParameter
    void setPersonalizationRequired(Boolean personalizationRequired);

    @EtsyParameter
    void setMaxPersonalizationCharacterCount(Integer maxPersonalizationCharacterCount);

    @EtsyParameter
    void setPersonalizationInstructions(String personalizationInstructions);

    @EtsyParameter
    void setState(ListingState state);

    @EtsyParameter
    void setSupply(Boolean supply);

    @EtsyParameter
    void setProductionPartnerIds(List<Long> productionPartnerIds);

    @EtsyParameter
    void setType(ListingType type);
}
