package com.notronix.etsy.impl.listings.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.common.model.DimensionUnit;
import com.notronix.etsy.api.common.model.WeightUnit;
import com.notronix.etsy.api.listings.model.*;
import com.notronix.etsy.impl.common.model.EtsyPrice;
import com.notronix.etsy.impl.shops.model.EtsyShippingProfile;
import com.notronix.etsy.impl.shops.model.EtsyShop;
import com.notronix.etsy.impl.users.model.EtsyUser;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class EtsyListing implements Listing
{
    @SerializedName("listing_id")
    private Long id;
    @SerializedName("user_id")
    private Long userId;
    @SerializedName("shop_id")
    private Long shopId;
    private String title;
    private String description;
    private ListingState state;

    @SerializedName("creation_timestamp")
    private Instant creationTimestamp;

    @SerializedName("created_timestamp")
    private Instant createdTimestamp;

    @SerializedName("ending_timestamp")
    private Instant endingTimestamp;

    @SerializedName("original_creation_timestamp")
    private Instant originalCreationTimestamp;

    @SerializedName("last_modified_timestamp")
    private Instant lastModifiedTimestamp;

    @SerializedName("updated_timestamp")
    private Instant updatedTimestamp;

    @SerializedName("state_timestamp")
    private Instant stateTimestamp;
    private Integer quantity;

    @SerializedName("shop_section_id")
    private Long shopSectionId;
    @SerializedName("featured_rank")
    private Integer featuredRank;
    private String url;
    @SerializedName("num_favorers")
    private Long numberOfFavorers;

    @SerializedName("non_taxable")
    private Boolean nonTaxable;
    @SerializedName("is_taxable")
    private Boolean taxable;

    @SerializedName("is_customizable")
    private Boolean customizable;

    @SerializedName("is_personalizable")
    private Boolean personalizable;

    @SerializedName("personalization_is_required")
    private Boolean personalizationRequired;

    @SerializedName("personalization_char_count_max")
    private Integer maxPersonalizationCharacterCount;

    @SerializedName("personalization_instructions")
    private String personalizationInstructions;

    @SerializedName("listing_type")
    private ListingType type;
    private List<String> tags;
    private List<String> materials;
    @SerializedName("shipping_profile_id")
    private Long shippingProfileId;

    @SerializedName("return_policy_id")
    private Long returnPolicyId;

    @SerializedName("processing_min")
    private Integer processingMin;

    @SerializedName("processing_max")
    private Integer processingMax;

    @SerializedName("who_made")
    private WhoMade whoMade;

    @SerializedName("when_made")
    private WhenMade whenMade;

    @SerializedName("is_supply")
    private Boolean supply;

    @SerializedName("item_weight")
    private Float itemWeight;

    @SerializedName("item_weight_unit")
    private WeightUnit itemWeightUnit;

    @SerializedName("item_length")
    private Float itemLength;

    @SerializedName("item_width")
    private Float itemWidth;

    @SerializedName("item_height")
    private Float itemHeight;

    @SerializedName("item_dimensions_unit")
    private DimensionUnit itemDimensionsUnit;

    @SerializedName("is_private")
    private Boolean isPrivate;

    @SerializedName("style")
    private List<String> styles;
    @SerializedName("file_data")
    private String fileData;
    @SerializedName("has_variations")
    private Boolean hasVariations;

    @SerializedName("should_auto_renew")
    private Boolean shouldAutoRenew;

    private String language;
    private EtsyPrice price;
    @SerializedName("taxonomy_id")
    private Long taxonomyId;

    @SerializedName("shipping_profile")
    private EtsyShippingProfile shippingProfile;

    private EtsyUser user;
    private EtsyShop shop;

    private List<EtsyListingImage> images;

    private List<EtsyListingVideo> videos;

    private EtsyListingInventory inventory;

    @SerializedName("production_partners")
    private List<EtsyProductionPartner> productionPartners;
    private List<String> skus;

    private Map<String, EtsyListingTranslation> translations;

    private Long views;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public ListingState getState() {
        return state;
    }

    public void setState(ListingState state) {
        this.state = state;
    }

    @Override
    public Instant getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Instant creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    @Override
    public Instant getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Instant createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @Override
    public Instant getEndingTimestamp() {
        return endingTimestamp;
    }

    public void setEndingTimestamp(Instant endingTimestamp) {
        this.endingTimestamp = endingTimestamp;
    }

    @Override
    public Instant getOriginalCreationTimestamp() {
        return originalCreationTimestamp;
    }

    public void setOriginalCreationTimestamp(Instant originalCreationTimestamp) {
        this.originalCreationTimestamp = originalCreationTimestamp;
    }

    @Override
    public Instant getLastModifiedTimestamp() {
        return lastModifiedTimestamp;
    }

    public void setLastModifiedTimestamp(Instant lastModifiedTimestamp) {
        this.lastModifiedTimestamp = lastModifiedTimestamp;
    }

    @Override
    public Instant getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Instant updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    @Override
    public Instant getStateTimestamp() {
        return stateTimestamp;
    }

    public void setStateTimestamp(Instant stateTimestamp) {
        this.stateTimestamp = stateTimestamp;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public Long getShopSectionId() {
        return shopSectionId;
    }

    public void setShopSectionId(Long shopSectionId) {
        this.shopSectionId = shopSectionId;
    }

    @Override
    public Integer getFeaturedRank() {
        return featuredRank;
    }

    public void setFeaturedRank(Integer featuredRank) {
        this.featuredRank = featuredRank;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Long getNumberOfFavorers() {
        return numberOfFavorers;
    }

    public void setNumberOfFavorers(Long numberOfFavorers) {
        this.numberOfFavorers = numberOfFavorers;
    }

    @Override
    public Boolean getNonTaxable() {
        return nonTaxable;
    }

    public void setNonTaxable(Boolean nonTaxable) {
        this.nonTaxable = nonTaxable;
    }

    @Override
    public Boolean isTaxable() {
        return taxable;
    }

    public Boolean getTaxable() {
        return taxable;
    }

    public void setTaxable(Boolean taxable) {
        this.taxable = taxable;
    }

    @Override
    public Boolean isCustomizable() {
        return customizable;
    }

    public Boolean getCustomizable() {
        return customizable;
    }

    public void setCustomizable(Boolean customizable) {
        this.customizable = customizable;
    }

    @Override
    public Boolean isPersonalizable() {
        return personalizable;
    }

    public Boolean getPersonalizable() {
        return personalizable;
    }

    public void setPersonalizable(Boolean personalizable) {
        this.personalizable = personalizable;
    }

    @Override
    public Boolean isPersonalizationRequired() {
        return personalizationRequired;
    }

    public Boolean getPersonalizationRequired() {
        return personalizationRequired;
    }

    public void setPersonalizationRequired(Boolean personalizationRequired) {
        this.personalizationRequired = personalizationRequired;
    }

    @Override
    public Integer getMaxPersonalizationCharacterCount() {
        return maxPersonalizationCharacterCount;
    }

    public void setMaxPersonalizationCharacterCount(Integer maxPersonalizationCharacterCount) {
        this.maxPersonalizationCharacterCount = maxPersonalizationCharacterCount;
    }

    @Override
    public String getPersonalizationInstructions() {
        return personalizationInstructions;
    }

    public void setPersonalizationInstructions(String personalizationInstructions) {
        this.personalizationInstructions = personalizationInstructions;
    }

    @Override
    public ListingType getType() {
        return type;
    }

    public void setType(ListingType type) {
        this.type = type;
    }

    @Override
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public List<String> getMaterials() {
        return materials;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    @Override
    public Long getShippingProfileId() {
        return shippingProfileId;
    }

    public void setShippingProfileId(Long shippingProfileId) {
        this.shippingProfileId = shippingProfileId;
    }

    @Override
    public Long getReturnPolicyId() {
        return returnPolicyId;
    }

    public void setReturnPolicyId(Long returnPolicyId) {
        this.returnPolicyId = returnPolicyId;
    }

    @Override
    public Integer getProcessingMin() {
        return processingMin;
    }

    public void setProcessingMin(Integer processingMin) {
        this.processingMin = processingMin;
    }

    @Override
    public Integer getProcessingMax() {
        return processingMax;
    }

    public void setProcessingMax(Integer processingMax) {
        this.processingMax = processingMax;
    }

    @Override
    public WhoMade getWhoMade() {
        return whoMade;
    }

    public void setWhoMade(WhoMade whoMade) {
        this.whoMade = whoMade;
    }

    @Override
    public WhenMade getWhenMade() {
        return whenMade;
    }

    public void setWhenMade(WhenMade whenMade) {
        this.whenMade = whenMade;
    }

    @Override
    public Boolean isSupply() {
        return supply;
    }

    public Boolean getSupply() {
        return supply;
    }

    public void setSupply(Boolean supply) {
        this.supply = supply;
    }

    @Override
    public Float getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(Float itemWeight) {
        this.itemWeight = itemWeight;
    }

    @Override
    public WeightUnit getItemWeightUnit() {
        return itemWeightUnit;
    }

    public void setItemWeightUnit(WeightUnit itemWeightUnit) {
        this.itemWeightUnit = itemWeightUnit;
    }

    @Override
    public Float getItemLength() {
        return itemLength;
    }

    public void setItemLength(Float itemLength) {
        this.itemLength = itemLength;
    }

    @Override
    public Float getItemWidth() {
        return itemWidth;
    }

    public void setItemWidth(Float itemWidth) {
        this.itemWidth = itemWidth;
    }

    @Override
    public Float getItemHeight() {
        return itemHeight;
    }

    public void setItemHeight(Float itemHeight) {
        this.itemHeight = itemHeight;
    }

    @Override
    public DimensionUnit getItemDimensionsUnit() {
        return itemDimensionsUnit;
    }

    public void setItemDimensionsUnit(DimensionUnit itemDimensionsUnit) {
        this.itemDimensionsUnit = itemDimensionsUnit;
    }

    @Override
    public Boolean isPrivate() {
        return isPrivate;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    @Override
    public List<String> getStyles() {
        return styles;
    }

    public void setStyles(List<String> styles) {
        this.styles = styles;
    }

    @Override
    public String getFileData() {
        return fileData;
    }

    public void setFileData(String fileData) {
        this.fileData = fileData;
    }

    @Override
    public Boolean hasVariations() {
        return hasVariations;
    }

    public Boolean getHasVariations() {
        return hasVariations;
    }

    public void setHasVariations(Boolean hasVariations) {
        this.hasVariations = hasVariations;
    }

    @Override
    public Boolean shouldAutoRenew() {
        return shouldAutoRenew;
    }

    public Boolean getShouldAutoRenew() {
        return shouldAutoRenew;
    }

    public void setShouldAutoRenew(Boolean shouldAutoRenew) {
        this.shouldAutoRenew = shouldAutoRenew;
    }

    @Override
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public EtsyPrice getPrice() {
        return price;
    }

    public void setPrice(EtsyPrice price) {
        this.price = price;
    }

    @Override
    public Long getTaxonomyId() {
        return taxonomyId;
    }

    public void setTaxonomyId(Long taxonomyId) {
        this.taxonomyId = taxonomyId;
    }

    @Override
    public EtsyShippingProfile getShippingProfile() {
        return shippingProfile;
    }

    public void setShippingProfile(EtsyShippingProfile shippingProfile) {
        this.shippingProfile = shippingProfile;
    }

    @Override
    public EtsyUser getUser() {
        return user;
    }

    public void setUser(EtsyUser user) {
        this.user = user;
    }

    @Override
    public EtsyShop getShop() {
        return shop;
    }

    public void setShop(EtsyShop shop) {
        this.shop = shop;
    }

    @Override
    public List<EtsyListingImage> getImages() {
        return images;
    }

    public void setImages(List<EtsyListingImage> images) {
        this.images = images;
    }

    @Override
    public List<EtsyListingVideo> getVideos() {
        return videos;
    }

    public void setVideos(List<EtsyListingVideo> videos) {
        this.videos = videos;
    }

    @Override
    public EtsyListingInventory getInventory() {
        return inventory;
    }

    public void setInventory(EtsyListingInventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public List<EtsyProductionPartner> getProductionPartners() {
        return productionPartners;
    }

    public void setProductionPartners(List<EtsyProductionPartner> productionPartners) {
        this.productionPartners = productionPartners;
    }

    @Override
    public List<String> getSkus() {
        return skus;
    }

    public void setSkus(List<String> skus) {
        this.skus = skus;
    }

    @Override
    public Map<String, EtsyListingTranslation> getTranslations() {
        return translations;
    }

    public void setTranslations(Map<String, EtsyListingTranslation> translations) {
        this.translations = translations;
    }

    @Override
    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }
}
