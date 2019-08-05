package com.notronix.etsy.impl.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.model.DimensionUnit;
import com.notronix.etsy.api.model.ListingState;
import com.notronix.etsy.api.model.WeightUnit;
import com.notronix.etsy.impl.model.EtsyListing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.notronix.albacore.ContainerUtils.thereAreNo;
import static com.notronix.etsy.impl.method.MethodUtils.putIfProvided;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.join;

public class UpdateListingMethod extends AbstractEtsyMethod<EtsyListing>
{
    private Long listingId;
    private String title;
    private String description;
    private List<String> materials;
    private Boolean renew;
    private Long shippingTemplateId;
    private Long shopSectionId;
    private ListingState state;
    private List<Long> imageIds;
    private Boolean isCustomizable;
    private Float itemWeight;
    private Float itemLength;
    private Float itemWidth;
    private Float itemHeight;
    private WeightUnit weightUnit;
    private DimensionUnit dimensionUnit;
    private Boolean nonTaxable;
    private Long categoryId;
    private Long taxonomyId;
    private List<String> tags;
    private String whoMade;
    private Boolean isSupply;
    private String whenMade;
    private String recipient;
    private String occasion;
    private List<String> style;
    private Integer processingMin;
    private Integer processingMax;
    private String featuredRank;

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.PUT;
    }

    @Override
    public String getURI() {
        return "/listings/" + requireNonNull(listingId);
    }

    @Override
    public HttpContent getContent(Gson gson) {
        Map<String, Object> params = new HashMap<>();
        putIfProvided(params, "title", title);
        putIfProvided(params, "description", description);
        putIfProvided(params, "materials", thereAreNo(materials) ? null : join(materials, ","));
        putIfProvided(params, "renew", renew);
        putIfProvided(params, "shipping_template_id", shippingTemplateId);
        putIfProvided(params, "shop_section_id", shopSectionId);
        putIfProvided(params, "state", state == null ? null : state.apiValue());
        putIfProvided(params, "image_ids", thereAreNo(imageIds) ? null : join(imageIds, ","));
        putIfProvided(params, "is_customizable", isCustomizable);
        putIfProvided(params, "item_weight", itemWeight);
        putIfProvided(params, "item_length", itemLength);
        putIfProvided(params, "item_width", itemWidth);
        putIfProvided(params, "item_height", itemHeight);
        putIfProvided(params, "item_weight_unit", weightUnit == null ? null : weightUnit.name());
        putIfProvided(params, "item_dimensions_unit", dimensionUnit == null ? null : dimensionUnit.name());
        putIfProvided(params, "non_taxable", nonTaxable);
        putIfProvided(params, "category_id", categoryId);
        putIfProvided(params, "taxonomy_id", taxonomyId);
        putIfProvided(params, "tags", thereAreNo(tags) ? null : join(tags, ","));
        putIfProvided(params, "who_made", whoMade);
        putIfProvided(params, "is_supply", isSupply);
        putIfProvided(params, "when_made", whenMade);
        putIfProvided(params, "recipient", recipient);
        putIfProvided(params, "occasion", occasion);
        putIfProvided(params, "style", thereAreNo(style) ? null : join(style, ","));
        putIfProvided(params, "processing_min", processingMin);
        putIfProvided(params, "processing_max", processingMax);
        putIfProvided(params, "featured_rank", featuredRank);

        return new UrlEncodedContent(params);
    }

    @Override
    public EtsyListing getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyListing>> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyListing>>>(){}.getType());

        return response.getResults().stream().findAny().orElse(null);
    }

    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public UpdateListingMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UpdateListingMethod withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UpdateListingMethod withDescription(String description) {
        this.description = description;
        return this;
    }

    public List<String> getMaterials() {
        return materials;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    public UpdateListingMethod withMaterials(List<String> materials) {
        this.materials = materials;
        return this;
    }

    public Boolean getRenew() {
        return renew;
    }

    public void setRenew(Boolean renew) {
        this.renew = renew;
    }

    public UpdateListingMethod withRenew(Boolean renew) {
        this.renew = renew;
        return this;
    }

    public Long getShippingTemplateId() {
        return shippingTemplateId;
    }

    public void setShippingTemplateId(Long shippingTemplateId) {
        this.shippingTemplateId = shippingTemplateId;
    }

    public UpdateListingMethod withShippingTemplateId(Long shippingTemplateId) {
        this.shippingTemplateId = shippingTemplateId;
        return this;
    }

    public Long getShopSectionId() {
        return shopSectionId;
    }

    public void setShopSectionId(Long shopSectionId) {
        this.shopSectionId = shopSectionId;
    }

    public UpdateListingMethod withShopSectionId(Long shopSectionId) {
        this.shopSectionId = shopSectionId;
        return this;
    }

    public ListingState getState() {
        return state;
    }

    public void setState(ListingState state) {
        this.state = state;
    }

    public UpdateListingMethod withState(ListingState state) {
        this.state = state;
        return this;
    }

    public List<Long> getImageIds() {
        return imageIds;
    }

    public void setImageIds(List<Long> imageIds) {
        this.imageIds = imageIds;
    }

    public UpdateListingMethod withImageIds(List<Long> imageIds) {
        this.imageIds = imageIds;
        return this;
    }

    public Boolean getIsCustomizable() {
        return isCustomizable;
    }

    public void setIsCustomizable(Boolean isCustomizable) {
        this.isCustomizable = isCustomizable;
    }

    public UpdateListingMethod withIsCustomizable(Boolean isCustomizable) {
        this.isCustomizable = isCustomizable;
        return this;
    }

    public Float getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(Float itemWeight) {
        this.itemWeight = itemWeight;
    }

    public UpdateListingMethod withItemWeight(Float itemWeight) {
        this.itemWeight = itemWeight;
        return this;
    }

    public Float getItemLength() {
        return itemLength;
    }

    public void setItemLength(Float itemLength) {
        this.itemLength = itemLength;
    }

    public UpdateListingMethod withItemLength(Float itemLength) {
        this.itemLength = itemLength;
        return this;
    }

    public Float getItemWidth() {
        return itemWidth;
    }

    public void setItemWidth(Float itemWidth) {
        this.itemWidth = itemWidth;
    }

    public UpdateListingMethod withItemWidth(Float itemWidth) {
        this.itemWidth = itemWidth;
        return this;
    }

    public Float getItemHeight() {
        return itemHeight;
    }

    public void setItemHeight(Float itemHeight) {
        this.itemHeight = itemHeight;
    }

    public UpdateListingMethod withItemHeight(Float itemHeight) {
        this.itemHeight = itemHeight;
        return this;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }

    public UpdateListingMethod withWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
        return this;
    }

    public DimensionUnit getDimensionUnit() {
        return dimensionUnit;
    }

    public void setDimensionUnit(DimensionUnit dimensionUnit) {
        this.dimensionUnit = dimensionUnit;
    }

    public UpdateListingMethod withDimensionUnit(DimensionUnit dimensionUnit) {
        this.dimensionUnit = dimensionUnit;
        return this;
    }

    public Boolean getNonTaxable() {
        return nonTaxable;
    }

    public void setNonTaxable(Boolean nonTaxable) {
        this.nonTaxable = nonTaxable;
    }

    public UpdateListingMethod withNonTaxable(Boolean nonTaxable) {
        this.nonTaxable = nonTaxable;
        return this;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public UpdateListingMethod withCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Long getTaxonomyId() {
        return taxonomyId;
    }

    public void setTaxonomyId(Long taxonomyId) {
        this.taxonomyId = taxonomyId;
    }

    public UpdateListingMethod withTaxonomyId(Long taxonomyId) {
        this.taxonomyId = taxonomyId;
        return this;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public UpdateListingMethod withTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public String getWhoMade() {
        return whoMade;
    }

    public void setWhoMade(String whoMade) {
        this.whoMade = whoMade;
    }

    public UpdateListingMethod withWhoMade(String whoMade) {
        this.whoMade = whoMade;
        return this;
    }

    public Boolean getIsSupply() {
        return isSupply;
    }

    public void setIsSupply(Boolean isSupply) {
        this.isSupply = isSupply;
    }

    public UpdateListingMethod withIsSupply(Boolean isSupply) {
        this.isSupply = isSupply;
        return this;
    }

    public String getWhenMade() {
        return whenMade;
    }

    public void setWhenMade(String whenMade) {
        this.whenMade = whenMade;
    }

    public UpdateListingMethod withWhenMade(String whenMade) {
        this.whenMade = whenMade;
        return this;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public UpdateListingMethod withRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public UpdateListingMethod withOccasion(String occasion) {
        this.occasion = occasion;
        return this;
    }

    public List<String> getStyle() {
        return style;
    }

    public void setStyle(List<String> style) {
        this.style = style;
    }

    public UpdateListingMethod withStyle(List<String> style) {
        this.style = style;
        return this;
    }

    public Integer getProcessingMin() {
        return processingMin;
    }

    public void setProcessingMin(Integer processingMin) {
        this.processingMin = processingMin;
    }

    public UpdateListingMethod withProcessingMin(Integer processingMin) {
        this.processingMin = processingMin;
        return this;
    }

    public Integer getProcessingMax() {
        return processingMax;
    }

    public void setProcessingMax(Integer processingMax) {
        this.processingMax = processingMax;
    }

    public UpdateListingMethod withProcessingMax(Integer processingMax) {
        this.processingMax = processingMax;
        return this;
    }

    public String getFeaturedRank() {
        return featuredRank;
    }

    public void setFeaturedRank(String featuredRank) {
        this.featuredRank = featuredRank;
    }

    public UpdateListingMethod withFeaturedRank(String featuredRank) {
        this.featuredRank = featuredRank;
        return this;
    }
}
