package com.notronix.etsy.impl.listings.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.common.model.DimensionUnit;
import com.notronix.etsy.api.common.model.WeightUnit;
import com.notronix.etsy.api.listings.model.ListingType;
import com.notronix.etsy.api.listings.model.WhenMade;
import com.notronix.etsy.api.listings.model.WhoMade;
import com.notronix.etsy.impl.EtsyMethod;
import com.notronix.etsy.impl.listings.model.EtsyListing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.notronix.albacore.ContainerUtils.thereAreNo;
import static com.notronix.etsy.impl.EtsyMethodUtils.putIfProvided;
import static java.util.Objects.requireNonNull;

public class CreateDraftListingMethod extends EtsyMethod<EtsyListing>
{
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

    public CreateDraftListingMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public EtsyListing getResponse(Unmarshaller unmarshaller, String payload) {
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
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public HttpContent getContent(Marshaller marshaller) {
        Map<String, Object> params = new HashMap<>();
        params.put("quantity", requireNonNull(quantity));
        params.put("title", requireNonNull(title));
        params.put("description", requireNonNull(description));
        params.put("price", requireNonNull(price));
        params.put("who_made", requireNonNull(whoMade));
        params.put("when_made", requireNonNull(whenMade).apiValue());
        params.put("taxonomy_id", requireNonNull(taxonomyId));

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
        putIfProvided(params, "item_weight_unit", weightUnit);
        putIfProvided(params, "item_dimensions_unit", dimensionUnit);
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
        putIfProvided(params, "type", type);

        return new UrlEncodedContent(params);
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public CreateDraftListingMethod withShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CreateDraftListingMethod withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CreateDraftListingMethod withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CreateDraftListingMethod withDescription(String description) {
        this.description = description;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public CreateDraftListingMethod withPrice(Float price) {
        this.price = price;
        return this;
    }

    public WhoMade getWhoMade() {
        return whoMade;
    }

    public void setWhoMade(WhoMade whoMade) {
        this.whoMade = whoMade;
    }

    public CreateDraftListingMethod withWhoMade(WhoMade whoMade) {
        this.whoMade = whoMade;
        return this;
    }

    public WhenMade getWhenMade() {
        return whenMade;
    }

    public void setWhenMade(WhenMade whenMade) {
        this.whenMade = whenMade;
    }

    public CreateDraftListingMethod withWhenMade(WhenMade whenMade) {
        this.whenMade = whenMade;
        return this;
    }

    public Long getTaxonomyId() {
        return taxonomyId;
    }

    public void setTaxonomyId(Long taxonomyId) {
        this.taxonomyId = taxonomyId;
    }

    public CreateDraftListingMethod withTaxonomyId(Long taxonomyId) {
        this.taxonomyId = taxonomyId;
        return this;
    }

    public Long getShippingProfileId() {
        return shippingProfileId;
    }

    public void setShippingProfileId(Long shippingProfileId) {
        this.shippingProfileId = shippingProfileId;
    }

    public CreateDraftListingMethod withShippingProfileId(Long shippingProfileId) {
        this.shippingProfileId = shippingProfileId;
        return this;
    }

    public Long getReturnPolicyId() {
        return returnPolicyId;
    }

    public void setReturnPolicyId(Long returnPolicyId) {
        this.returnPolicyId = returnPolicyId;
    }

    public CreateDraftListingMethod withReturnPolicyId(Long returnPolicyId) {
        this.returnPolicyId = returnPolicyId;
        return this;
    }

    public List<String> getMaterials() {
        return materials;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    public CreateDraftListingMethod withMaterials(List<String> materials) {
        this.materials = materials;
        return this;
    }

    public Long getShopSectionId() {
        return shopSectionId;
    }

    public void setShopSectionId(Long shopSectionId) {
        this.shopSectionId = shopSectionId;
    }

    public CreateDraftListingMethod withShopSectionId(Long shopSectionId) {
        this.shopSectionId = shopSectionId;
        return this;
    }

    public Integer getProcessingMin() {
        return processingMin;
    }

    public void setProcessingMin(Integer processingMin) {
        this.processingMin = processingMin;
    }

    public CreateDraftListingMethod withProcessingMin(Integer processingMin) {
        this.processingMin = processingMin;
        return this;
    }

    public Integer getProcessingMax() {
        return processingMax;
    }

    public void setProcessingMax(Integer processingMax) {
        this.processingMax = processingMax;
    }

    public CreateDraftListingMethod withProcessingMax(Integer processingMax) {
        this.processingMax = processingMax;
        return this;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public CreateDraftListingMethod withTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public List<String> getStyles() {
        return styles;
    }

    public void setStyles(List<String> styles) {
        this.styles = styles;
    }

    public CreateDraftListingMethod withStyles(List<String> styles) {
        this.styles = styles;
        return this;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public CreateDraftListingMethod withWeight(Float weight) {
        this.weight = weight;
        return this;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public CreateDraftListingMethod withLength(Float length) {
        this.length = length;
        return this;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public CreateDraftListingMethod withWidth(Float width) {
        this.width = width;
        return this;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public CreateDraftListingMethod withHeight(Float height) {
        this.height = height;
        return this;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }

    public CreateDraftListingMethod withWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
        return this;
    }

    public DimensionUnit getDimensionUnit() {
        return dimensionUnit;
    }

    public void setDimensionUnit(DimensionUnit dimensionUnit) {
        this.dimensionUnit = dimensionUnit;
    }

    public CreateDraftListingMethod withDimensionUnit(DimensionUnit dimensionUnit) {
        this.dimensionUnit = dimensionUnit;
        return this;
    }

    public Boolean getPersonalizable() {
        return personalizable;
    }

    public void setPersonalizable(Boolean personalizable) {
        this.personalizable = personalizable;
    }

    public CreateDraftListingMethod withPersonalizable(Boolean personalizable) {
        this.personalizable = personalizable;
        return this;
    }

    public Boolean getPersonalizationRequired() {
        return personalizationRequired;
    }

    public void setPersonalizationRequired(Boolean personalizationRequired) {
        this.personalizationRequired = personalizationRequired;
    }

    public CreateDraftListingMethod withPersonalizationRequired(Boolean personalizationRequired) {
        this.personalizationRequired = personalizationRequired;
        return this;
    }

    public Integer getMaxPersonalizationCharacterCount() {
        return maxPersonalizationCharacterCount;
    }

    public void setMaxPersonalizationCharacterCount(Integer maxPersonalizationCharacterCount) {
        this.maxPersonalizationCharacterCount = maxPersonalizationCharacterCount;
    }

    public CreateDraftListingMethod withMaxPersonalizationCharacterCount(Integer maxPersonalizationCharacterCount) {
        this.maxPersonalizationCharacterCount = maxPersonalizationCharacterCount;
        return this;
    }

    public String getPersonalizationInstructions() {
        return personalizationInstructions;
    }

    public void setPersonalizationInstructions(String personalizationInstructions) {
        this.personalizationInstructions = personalizationInstructions;
    }

    public CreateDraftListingMethod withPersonalizationInstructions(String personalizationInstructions) {
        this.personalizationInstructions = personalizationInstructions;
        return this;
    }

    public List<Long> getProductionPartnerIds() {
        return productionPartnerIds;
    }

    public void setProductionPartnerIds(List<Long> productionPartnerIds) {
        this.productionPartnerIds = productionPartnerIds;
    }

    public CreateDraftListingMethod withProductionPartnerIds(List<Long> productionPartnerIds) {
        this.productionPartnerIds = productionPartnerIds;
        return this;
    }

    public List<Long> getImageIds() {
        return imageIds;
    }

    public void setImageIds(List<Long> imageIds) {
        this.imageIds = imageIds;
    }

    public CreateDraftListingMethod withImageIds(List<Long> imageIds) {
        this.imageIds = imageIds;
        return this;
    }

    public Boolean getSupply() {
        return supply;
    }

    public void setSupply(Boolean supply) {
        this.supply = supply;
    }

    public CreateDraftListingMethod withSupply(Boolean supply) {
        this.supply = supply;
        return this;
    }

    public Boolean getCustomizable() {
        return customizable;
    }

    public void setCustomizable(Boolean customizable) {
        this.customizable = customizable;
    }

    public CreateDraftListingMethod withCustomizable(Boolean customizable) {
        this.customizable = customizable;
        return this;
    }

    public Boolean getShouldAutoRenew() {
        return shouldAutoRenew;
    }

    public void setShouldAutoRenew(Boolean shouldAutoRenew) {
        this.shouldAutoRenew = shouldAutoRenew;
    }

    public CreateDraftListingMethod withShouldAutoRenew(Boolean shouldAutoRenew) {
        this.shouldAutoRenew = shouldAutoRenew;
        return this;
    }

    public Boolean getTaxable() {
        return taxable;
    }

    public void setTaxable(Boolean taxable) {
        this.taxable = taxable;
    }

    public CreateDraftListingMethod withTaxable(Boolean taxable) {
        this.taxable = taxable;
        return this;
    }

    public ListingType getType() {
        return type;
    }

    public void setType(ListingType type) {
        this.type = type;
    }

    public CreateDraftListingMethod withType(ListingType type) {
        this.type = type;
        return this;
    }
}
