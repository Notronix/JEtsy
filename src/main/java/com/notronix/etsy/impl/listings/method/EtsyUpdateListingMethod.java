package com.notronix.etsy.impl.listings.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.common.method.OAuthMethod;
import com.notronix.etsy.api.common.model.DimensionUnit;
import com.notronix.etsy.api.common.model.WeightUnit;
import com.notronix.etsy.api.listings.method.UpdateListingMethod;
import com.notronix.etsy.api.listings.model.*;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.listings.model.EtsyListing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.notronix.albacore.ContainerUtils.thereAreNo;
import static com.notronix.etsy.api.MethodUtils.putIfProvided;
import static com.notronix.etsy.api.listings.method.ListingResource.*;
import static java.util.Objects.requireNonNull;

public class EtsyUpdateListingMethod extends AbstractEtsyMethod<Listing>
    implements UpdateListingMethod<HttpContent>, OAuthMethod
{
    private AccessToken accessToken;
    private Long shopId;
    private Long listingId;
    private List<Long> imageIds;
    private String title;
    private String description;
    private List<String> materials;
    private Boolean shouldAutoRenew;
    private Long shippingProfileId;
    private Long returnPolicyId;
    private Long shopSectionId;
    private Float weight;
    private Float length;
    private Float width;
    private Float height;
    private WeightUnit weightUnit;
    private DimensionUnit dimensionUnit;
    private Boolean taxable;
    private Long taxonomyId;
    private List<String> tags;
    private WhoMade whoMade;
    private WhenMade whenMade;
    private Integer featuredRank;
    private Boolean personalizable;
    private Boolean personalizationRequired;
    private Integer maxPersonalizationCharacterCount;
    private String personalizationInstructions;
    private ListingState state;
    private Boolean supply;
    private List<Long> productionPartnerIds;
    private ListingType type;

    @Override
    public Listing buildResponseBody(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, EtsyListing.class);
    }

    @Override
    protected String getURI() {
        return "/application/shops/" + requireNonNull(shopId) + "/listings/" + requireNonNull(listingId);
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.PATCH;
    }

    @Override
    public HttpContent buildRequestContent(Marshaller marshaller) {
        boolean throwWhenInvalid = false;
        Map<String, Object> params = new HashMap<>();

        putIfProvided(params, "image_ids", thereAreNo(imageIds) ? null
                : imageIds.stream().map(Object::toString).collect(Collectors.joining(",")));
        putIfProvided(params, "title", title);
        putIfProvided(params, "description", description);
        putIfProvided(params, "materials", thereAreNo(materials) ? null : String.join(",", materials));
        putIfProvided(params, "should_auto_renew", shouldAutoRenew);
        putIfProvided(params, "shipping_profile_id", shippingProfileId);
        putIfProvided(params, "return_policy_id", returnPolicyId);
        putIfProvided(params, "shop_section_id", shopSectionId);
        putIfProvided(params, "item_weight", weight);
        putIfProvided(params, "item_length", length);
        putIfProvided(params, "item_width", width);
        putIfProvided(params, "item_height", height);
        putIfProvided(params, "item_weight_unit", weightUnit == null ? null : weightUnit.name());
        putIfProvided(params, "item_dimensions_unit", dimensionUnit == null ? null : dimensionUnit.name());
        putIfProvided(params, "is_taxable", taxable);
        putIfProvided(params, "taxonomy_id", taxonomyId, TAXONOMY_ID_VALIDATOR, throwWhenInvalid);
        putIfProvided(params, "tags", thereAreNo(tags) ? null : String.join(",", tags));
        putIfProvided(params, "who_made", whoMade == null ? null : whoMade.name());
        putIfProvided(params, "when_made", whenMade == null ? null : whenMade.apiValue());
        putIfProvided(params, "featured_rank", featuredRank);
        putIfProvided(params, "is_personalizable", personalizable);
        putIfProvided(params, "personalization_is_required", personalizationRequired);
        putIfProvided(params, "personalization_char_count_max", maxPersonalizationCharacterCount);
        putIfProvided(params, "personalization_instructions", personalizationInstructions);
        putIfProvided(params, "state", state == null ? null : state.name());
        putIfProvided(params, "is_supply", supply);
        putIfProvided(params, "production_partner_ids", thereAreNo(productionPartnerIds) ? null
                : productionPartnerIds.stream().map(Object::toString).collect(Collectors.joining(",")));
        putIfProvided(params, "type", type == null ? null : type.name());

        return new UrlEncodedContent(params);
    }

    @Override
    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public EtsyUpdateListingMethod withAccessToken(AccessToken accessToken) {
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

    public Long getListingId() {
        return listingId;
    }

    @Override
    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public List<Long> getImageIds() {
        return imageIds;
    }

    @Override
    public void setImageIds(List<Long> imageIds) {
        this.imageIds = imageIds;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getMaterials() {
        return materials;
    }

    @Override
    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    public Boolean getShouldAutoRenew() {
        return shouldAutoRenew;
    }

    @Override
    public void setShouldAutoRenew(Boolean shouldAutoRenew) {
        this.shouldAutoRenew = shouldAutoRenew;
    }

    public Long getShippingProfileId() {
        return shippingProfileId;
    }

    @Override
    public void setShippingProfileId(Long shippingProfileId) {
        this.shippingProfileId = shippingProfileId;
    }

    public Long getReturnPolicyId() {
        return returnPolicyId;
    }

    @Override
    public void setReturnPolicyId(Long returnPolicyId) {
        this.returnPolicyId = returnPolicyId;
    }

    public Long getShopSectionId() {
        return shopSectionId;
    }

    @Override
    public void setShopSectionId(Long shopSectionId) {
        this.shopSectionId = shopSectionId;
    }

    public Float getWeight() {
        return weight;
    }

    @Override
    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getLength() {
        return length;
    }

    @Override
    public void setLength(Float length) {
        this.length = length;
    }

    public Float getWidth() {
        return width;
    }

    @Override
    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    @Override
    public void setHeight(Float height) {
        this.height = height;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    @Override
    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }

    public DimensionUnit getDimensionUnit() {
        return dimensionUnit;
    }

    @Override
    public void setDimensionUnit(DimensionUnit dimensionUnit) {
        this.dimensionUnit = dimensionUnit;
    }

    public Boolean getTaxable() {
        return taxable;
    }

    @Override
    public void setTaxable(Boolean taxable) {
        this.taxable = taxable;
    }

    public Long getTaxonomyId() {
        return taxonomyId;
    }

    @Override
    public void setTaxonomyId(Long taxonomyId) {
        this.taxonomyId = taxonomyId;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public WhoMade getWhoMade() {
        return whoMade;
    }

    @Override
    public void setWhoMade(WhoMade whoMade) {
        this.whoMade = whoMade;
    }

    public WhenMade getWhenMade() {
        return whenMade;
    }

    @Override
    public void setWhenMade(WhenMade whenMade) {
        this.whenMade = whenMade;
    }

    public Integer getFeaturedRank() {
        return featuredRank;
    }

    @Override
    public void setFeaturedRank(Integer featuredRank) {
        this.featuredRank = featuredRank;
    }

    public Boolean getPersonalizable() {
        return personalizable;
    }

    @Override
    public void setPersonalizable(Boolean personalizable) {
        this.personalizable = personalizable;
    }

    public Boolean getPersonalizationRequired() {
        return personalizationRequired;
    }

    @Override
    public void setPersonalizationRequired(Boolean personalizationRequired) {
        this.personalizationRequired = personalizationRequired;
    }

    public Integer getMaxPersonalizationCharacterCount() {
        return maxPersonalizationCharacterCount;
    }

    @Override
    public void setMaxPersonalizationCharacterCount(Integer maxPersonalizationCharacterCount) {
        this.maxPersonalizationCharacterCount = maxPersonalizationCharacterCount;
    }

    public String getPersonalizationInstructions() {
        return personalizationInstructions;
    }

    @Override
    public void setPersonalizationInstructions(String personalizationInstructions) {
        this.personalizationInstructions = personalizationInstructions;
    }

    public ListingState getState() {
        return state;
    }

    @Override
    public void setState(ListingState state) {
        this.state = state;
    }

    public Boolean getSupply() {
        return supply;
    }

    @Override
    public void setSupply(Boolean supply) {
        this.supply = supply;
    }

    public List<Long> getProductionPartnerIds() {
        return productionPartnerIds;
    }

    @Override
    public void setProductionPartnerIds(List<Long> productionPartnerIds) {
        this.productionPartnerIds = productionPartnerIds;
    }

    public ListingType getType() {
        return type;
    }

    @Override
    public void setType(ListingType type) {
        this.type = type;
    }
}
