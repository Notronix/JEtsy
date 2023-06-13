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
import com.notronix.etsy.api.listings.method.CreateDraftListingMethod;
import com.notronix.etsy.api.listings.model.Listing;
import com.notronix.etsy.api.listings.model.ListingType;
import com.notronix.etsy.api.listings.model.WhenMade;
import com.notronix.etsy.api.listings.model.WhoMade;
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

public class EtsyCreateDraftListingMethod extends AbstractEtsyMethod<Listing>
        implements CreateDraftListingMethod<HttpContent>, OAuthMethod
{
    private AccessToken accessToken;
    private Long shopId;
    private Integer quantity;
    private String title;
    private String description;
    private Float price;
    private WhoMade whoMade;
    private WhenMade whenMade;
    private Long taxonomyId;
    private Long shippingProfileId;
    private Long returnPolicyId;
    private List<String> materials;
    private Long shopSectionId;
    private Integer processingMin;
    private Integer processingMax;
    private List<String> tags;
    private List<String> styles;
    private Float weight;
    private Float length;
    private Float width;
    private Float height;
    private WeightUnit weightUnit;
    private DimensionUnit dimensionUnit;
    private Boolean personalizable;
    private Boolean personalizationRequired;
    private Integer maxPersonalizationCharacterCount;
    private String personalizationInstructions;
    private List<Long> productionPartnerIds;
    private List<Long> imageIds;
    private Boolean supply;
    private Boolean customizable;
    private Boolean shouldAutoRenew;
    private Boolean taxable;
    private ListingType type;

    @Override
    public EtsyListing buildResponseBody(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, EtsyListing.class);
    }

    @Override
    protected String getURI() {
        return "/application/shops/" + requireNonNull(shopId) + "/listings";
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.POST;
    }

    @Override
    public HttpContent buildRequestContent(Marshaller marshaller) {
        boolean throwWhenInvalid = true;
        Map<String, Object> params = new HashMap<>();

        putIfProvided(params, "quantity", quantity, QUANTITY_VALIDATOR, throwWhenInvalid);
        params.put("title", requireNonNull(title));
        params.put("description", requireNonNull(description));
        putIfProvided(params, "price", price, PRICE_VALIDATOR, throwWhenInvalid);
        params.put("who_made", requireNonNull(whoMade).toString());
        params.put("when_made", requireNonNull(whenMade).apiValue());
        putIfProvided(params, "taxonomy_id", taxonomyId, TAXONOMY_ID_VALIDATOR, throwWhenInvalid);

        putIfProvided(params, "shipping_profile_id", shippingProfileId);
        putIfProvided(params, "return_policy_id", returnPolicyId);
        putIfProvided(params, "materials", thereAreNo(materials) ? null : String.join(",", materials));
        putIfProvided(params, "shop_section_id", shopSectionId);
        putIfProvided(params, "processing_min", processingMin);
        putIfProvided(params, "processing_max", processingMax);
        putIfProvided(params, "tags", thereAreNo(tags) ? null : String.join(",", tags));
        putIfProvided(params, "styles", thereAreNo(styles) ? null : String.join(",", styles));
        putIfProvided(params, "item_weight", weight);
        putIfProvided(params, "item_length", length);
        putIfProvided(params, "item_width", width);
        putIfProvided(params, "item_height", height);
        putIfProvided(params, "item_weight_unit", weightUnit == null ? null : weightUnit.name());
        putIfProvided(params, "item_dimensions_unit", dimensionUnit == null ? null : dimensionUnit.name());
        putIfProvided(params, "is_personalizable", personalizable);
        putIfProvided(params, "personalization_is_required", personalizationRequired);
        putIfProvided(params, "personalization_char_count_max", maxPersonalizationCharacterCount);
        putIfProvided(params, "personalization_instructions", personalizationInstructions);
        putIfProvided(params, "production_partner_ids", thereAreNo(productionPartnerIds) ? null
                : productionPartnerIds.stream().map(Object::toString).collect(Collectors.joining(",")));
        putIfProvided(params, "image_ids", thereAreNo(imageIds) ? null
                : imageIds.stream().map(Object::toString).collect(Collectors.joining(",")));
        putIfProvided(params, "is_supply", supply);
        putIfProvided(params, "is_customizable", customizable);
        putIfProvided(params, "should_auto_renew", shouldAutoRenew);
        putIfProvided(params, "is_taxable", taxable);
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

    public EtsyCreateDraftListingMethod withAccessToken(AccessToken accessToken) {
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

    public EtsyCreateDraftListingMethod withShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public EtsyCreateDraftListingMethod withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public EtsyCreateDraftListingMethod withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public EtsyCreateDraftListingMethod withDescription(String description) {
        this.description = description;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    @Override
    public void setPrice(Float price) {
        this.price = price;
    }

    public EtsyCreateDraftListingMethod withPrice(Float price) {
        this.price = price;
        return this;
    }

    public WhoMade getWhoMade() {
        return whoMade;
    }

    @Override
    public void setWhoMade(WhoMade whoMade) {
        this.whoMade = whoMade;
    }

    public EtsyCreateDraftListingMethod withWhoMade(WhoMade whoMade) {
        this.whoMade = whoMade;
        return this;
    }

    public WhenMade getWhenMade() {
        return whenMade;
    }

    @Override
    public void setWhenMade(WhenMade whenMade) {
        this.whenMade = whenMade;
    }

    public EtsyCreateDraftListingMethod withWhenMade(WhenMade whenMade) {
        this.whenMade = whenMade;
        return this;
    }

    public Long getTaxonomyId() {
        return taxonomyId;
    }

    @Override
    public void setTaxonomyId(Long taxonomyId) {
        this.taxonomyId = taxonomyId;
    }

    public EtsyCreateDraftListingMethod withTaxonomyId(Long taxonomyId) {
        this.taxonomyId = taxonomyId;
        return this;
    }

    public Long getShippingProfileId() {
        return shippingProfileId;
    }

    @Override
    public void setShippingProfileId(Long shippingProfileId) {
        this.shippingProfileId = shippingProfileId;
    }

    public EtsyCreateDraftListingMethod withShippingProfileId(Long shippingProfileId) {
        this.shippingProfileId = shippingProfileId;
        return this;
    }

    public Long getReturnPolicyId() {
        return returnPolicyId;
    }

    @Override
    public void setReturnPolicyId(Long returnPolicyId) {
        this.returnPolicyId = returnPolicyId;
    }

    public EtsyCreateDraftListingMethod withReturnPolicyId(Long returnPolicyId) {
        this.returnPolicyId = returnPolicyId;
        return this;
    }

    public List<String> getMaterials() {
        return materials;
    }

    @Override
    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    public EtsyCreateDraftListingMethod withMaterials(List<String> materials) {
        this.materials = materials;
        return this;
    }

    public Long getShopSectionId() {
        return shopSectionId;
    }

    @Override
    public void setShopSectionId(Long shopSectionId) {
        this.shopSectionId = shopSectionId;
    }

    public EtsyCreateDraftListingMethod withShopSectionId(Long shopSectionId) {
        this.shopSectionId = shopSectionId;
        return this;
    }

    public Integer getProcessingMin() {
        return processingMin;
    }

    @Override
    public void setProcessingMin(Integer processingMin) {
        this.processingMin = processingMin;
    }

    public EtsyCreateDraftListingMethod withProcessingMin(Integer processingMin) {
        this.processingMin = processingMin;
        return this;
    }

    public Integer getProcessingMax() {
        return processingMax;
    }

    @Override
    public void setProcessingMax(Integer processingMax) {
        this.processingMax = processingMax;
    }

    public EtsyCreateDraftListingMethod withProcessingMax(Integer processingMax) {
        this.processingMax = processingMax;
        return this;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public EtsyCreateDraftListingMethod withTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public List<String> getStyles() {
        return styles;
    }

    @Override
    public void setStyles(List<String> styles) {
        this.styles = styles;
    }

    public EtsyCreateDraftListingMethod withStyles(List<String> styles) {
        this.styles = styles;
        return this;
    }

    public Float getWeight() {
        return weight;
    }

    @Override
    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public EtsyCreateDraftListingMethod withWeight(Float weight) {
        this.weight = weight;
        return this;
    }

    public Float getLength() {
        return length;
    }

    @Override
    public void setLength(Float length) {
        this.length = length;
    }

    public EtsyCreateDraftListingMethod withLength(Float length) {
        this.length = length;
        return this;
    }

    public Float getWidth() {
        return width;
    }

    @Override
    public void setWidth(Float width) {
        this.width = width;
    }

    public EtsyCreateDraftListingMethod withWidth(Float width) {
        this.width = width;
        return this;
    }

    public Float getHeight() {
        return height;
    }

    @Override
    public void setHeight(Float height) {
        this.height = height;
    }

    public EtsyCreateDraftListingMethod withHeight(Float height) {
        this.height = height;
        return this;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    @Override
    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }

    public EtsyCreateDraftListingMethod withWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
        return this;
    }

    public DimensionUnit getDimensionUnit() {
        return dimensionUnit;
    }

    @Override
    public void setDimensionUnit(DimensionUnit dimensionUnit) {
        this.dimensionUnit = dimensionUnit;
    }

    public EtsyCreateDraftListingMethod withDimensionUnit(DimensionUnit dimensionUnit) {
        this.dimensionUnit = dimensionUnit;
        return this;
    }

    public Boolean getPersonalizable() {
        return personalizable;
    }

    @Override
    public void setPersonalizable(Boolean personalizable) {
        this.personalizable = personalizable;
    }

    public EtsyCreateDraftListingMethod withPersonalizable(Boolean personalizable) {
        this.personalizable = personalizable;
        return this;
    }

    public Boolean getPersonalizationRequired() {
        return personalizationRequired;
    }

    @Override
    public void setPersonalizationRequired(Boolean personalizationRequired) {
        this.personalizationRequired = personalizationRequired;
    }

    public EtsyCreateDraftListingMethod withPersonalizationRequired(Boolean personalizationRequired) {
        this.personalizationRequired = personalizationRequired;
        return this;
    }

    public Integer getMaxPersonalizationCharacterCount() {
        return maxPersonalizationCharacterCount;
    }

    @Override
    public void setMaxPersonalizationCharacterCount(Integer maxPersonalizationCharacterCount) {
        this.maxPersonalizationCharacterCount = maxPersonalizationCharacterCount;
    }

    public EtsyCreateDraftListingMethod withMaxPersonalizationCharacterCount(Integer maxPersonalizationCharacterCount) {
        this.maxPersonalizationCharacterCount = maxPersonalizationCharacterCount;
        return this;
    }

    public String getPersonalizationInstructions() {
        return personalizationInstructions;
    }

    @Override
    public void setPersonalizationInstructions(String personalizationInstructions) {
        this.personalizationInstructions = personalizationInstructions;
    }

    public EtsyCreateDraftListingMethod withPersonalizationInstructions(String personalizationInstructions) {
        this.personalizationInstructions = personalizationInstructions;
        return this;
    }

    public List<Long> getProductionPartnerIds() {
        return productionPartnerIds;
    }

    @Override
    public void setProductionPartnerIds(List<Long> productionPartnerIds) {
        this.productionPartnerIds = productionPartnerIds;
    }

    public EtsyCreateDraftListingMethod withProductionPartnerIds(List<Long> productionPartnerIds) {
        this.productionPartnerIds = productionPartnerIds;
        return this;
    }

    public List<Long> getImageIds() {
        return imageIds;
    }

    @Override
    public void setImageIds(List<Long> imageIds) {
        this.imageIds = imageIds;
    }

    public EtsyCreateDraftListingMethod withImageIds(List<Long> imageIds) {
        this.imageIds = imageIds;
        return this;
    }

    public Boolean getSupply() {
        return supply;
    }

    @Override
    public void setSupply(Boolean supply) {
        this.supply = supply;
    }

    public EtsyCreateDraftListingMethod withSupply(Boolean supply) {
        this.supply = supply;
        return this;
    }

    public Boolean getCustomizable() {
        return customizable;
    }

    @Override
    public void setCustomizable(Boolean customizable) {
        this.customizable = customizable;
    }

    public EtsyCreateDraftListingMethod withCustomizable(Boolean customizable) {
        this.customizable = customizable;
        return this;
    }

    public Boolean getShouldAutoRenew() {
        return shouldAutoRenew;
    }

    @Override
    public void setShouldAutoRenew(Boolean shouldAutoRenew) {
        this.shouldAutoRenew = shouldAutoRenew;
    }

    public EtsyCreateDraftListingMethod withShouldAutoRenew(Boolean shouldAutoRenew) {
        this.shouldAutoRenew = shouldAutoRenew;
        return this;
    }

    public Boolean getTaxable() {
        return taxable;
    }

    @Override
    public void setTaxable(Boolean taxable) {
        this.taxable = taxable;
    }

    public EtsyCreateDraftListingMethod withTaxable(Boolean taxable) {
        this.taxable = taxable;
        return this;
    }

    public ListingType getType() {
        return type;
    }

    @Override
    public void setType(ListingType type) {
        this.type = type;
    }

    public EtsyCreateDraftListingMethod withType(ListingType type) {
        this.type = type;
        return this;
    }
}
