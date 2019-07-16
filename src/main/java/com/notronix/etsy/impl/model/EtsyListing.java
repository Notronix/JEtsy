package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.*;

import java.util.List;

public class EtsyListing implements Listing
{
    @SerializedName(value = "listing_id")
    private Long listingId;

    private String state;

    @SerializedName(value = "user_id")
    private Long userId;

    @SerializedName(value = "category_id")
    private Long categoryId;

    private String title;
    private String description;

    @SerializedName(value = "creation_tsz")
    private Float creationTsz;

    @SerializedName(value = "ending_tsz")
    private Float endingTsz;

    @SerializedName(value = "original_creation_tsz")
    private Float originalCreationTsz;

    @SerializedName(value = "last_modified_tsz")
    private Float lastModifiedTsz;

    private Float price;

    @SerializedName(value = "currency_code")
    private String currencyCode;

    private Integer quantity;
    private List<String> sku;
    private List<String> tags;

    @SerializedName(value = "category_path")
    private List<String> categoryPaths;

    @SerializedName(value = "category_path_ids")
    private List<Long> categoryPathIds;

    @SerializedName(value = "taxonomy_id")
    private Long taxonomyId;

    @SerializedName(value = "suggested_taxonomy_id")
    private Long suggestedTaxonomyId;

    @SerializedName(value = "taxonomy_path")
    private List<String> taxonomyPaths;
    private List<String> materials;

    @SerializedName(value = "shop_section_id")
    private Long shopSectionId;

    @SerializedName(value = "featured_rank")
    private Object featuredRank;

    @SerializedName(value = "state_tsz")
    private Float stateTsz;
    private String url;
    private Long views;

    @SerializedName(value = "num_favorers")
    private Long numFavorers;

    @SerializedName(value = "shipping_template_id")
    private Long shippingTemplateId;

    @SerializedName(value = "shipping_profile_id")
    private Long shippingProfileId;

    @SerializedName(value = "processing_min")
    private Long processingMin;

    @SerializedName(value = "processing_max")
    private Long processingMax;

    @SerializedName(value = "who_made")
    private String whoMade;

    @SerializedName(value = "is_supply")
    private Boolean isSupply;

    @SerializedName(value = "when_made")
    private String whenMade;

    @SerializedName(value = "item_weight")
    private Double itemWeight;

    @SerializedName(value = "item_weight_unit")
    private WeightUnit itemWeightUnit;

    @SerializedName(value = "item_length")
    private Double itemLength;

    @SerializedName(value = "item_width")
    private Double itemWidth;

    @SerializedName(value = "item_height")
    private Double itemHeight;

    @SerializedName(value = "item_dimensions_unit")
    private DimensionUnit itemDimensionsUnit;

    @SerializedName(value = "is_private")
    private Boolean isPrivate;

    private String recipient;
    private String occasion;
    private List<String> style;

    @SerializedName(value = "non_taxable")
    private Boolean nonTaxable;

    @SerializedName(value = "is_customizable")
    private Boolean isCustomizable;

    @SerializedName(value = "is_digital")
    private Boolean isDigital;

    @SerializedName(value = "file_data")
    private String fileData;

    @SerializedName(value = "can_write_inventory")
    private Boolean canWriteInventory;

    @SerializedName(value = "has_variations")
    private Boolean hasVariations;

    @SerializedName(value = "should_auto_renew")
    private Boolean shouldAutoRenew;

    private String language;

    private EtsyUser User;
    private EtsyShop Shop;
    private EtsyShopSection Section;
    private List<EtsyListingImage> Images;
    private EtsyListingImage MainImage;
    private List<EtsyShippingInfo> ShippingInfo;
    private EtsyShippingTemplate ShippingTemplate;
    private List<EtsyShippingUpgrade> ShippingUpgrades;
    private EtsyPaymentInfo PaymentInfo;
    private List<EtsyListingTranslation> Translations;
    private List<EtsyPropertyValue> Attributes;
    private List<EtsyListingInventory> Inventory;

    @Override
    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    @Override
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
    public Float getCreationTsz() {
        return creationTsz;
    }

    public void setCreationTsz(Float creationTsz) {
        this.creationTsz = creationTsz;
    }

    @Override
    public Float getEndingTsz() {
        return endingTsz;
    }

    public void setEndingTsz(Float endingTsz) {
        this.endingTsz = endingTsz;
    }

    @Override
    public Float getOriginalCreationTsz() {
        return originalCreationTsz;
    }

    public void setOriginalCreationTsz(Float originalCreationTsz) {
        this.originalCreationTsz = originalCreationTsz;
    }

    @Override
    public Float getLastModifiedTsz() {
        return lastModifiedTsz;
    }

    public void setLastModifiedTsz(Float lastModifiedTsz) {
        this.lastModifiedTsz = lastModifiedTsz;
    }

    @Override
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public List<String> getSku() {
        return sku;
    }

    public void setSku(List<String> sku) {
        this.sku = sku;
    }

    @Override
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public List<String> getCategoryPaths() {
        return categoryPaths;
    }

    public void setCategoryPaths(List<String> categoryPaths) {
        this.categoryPaths = categoryPaths;
    }

    @Override
    public List<Long> getCategoryPathIds() {
        return categoryPathIds;
    }

    public void setCategoryPathIds(List<Long> categoryPathIds) {
        this.categoryPathIds = categoryPathIds;
    }

    @Override
    public Long getTaxonomyId() {
        return taxonomyId;
    }

    public void setTaxonomyId(Long taxonomyId) {
        this.taxonomyId = taxonomyId;
    }

    @Override
    public Long getSuggestedTaxonomyId() {
        return suggestedTaxonomyId;
    }

    public void setSuggestedTaxonomyId(Long suggestedTaxonomyId) {
        this.suggestedTaxonomyId = suggestedTaxonomyId;
    }

    @Override
    public List<String> getTaxonomyPaths() {
        return taxonomyPaths;
    }

    public void setTaxonomyPaths(List<String> taxonomyPaths) {
        this.taxonomyPaths = taxonomyPaths;
    }

    @Override
    public List<String> getMaterials() {
        return materials;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    @Override
    public Long getShopSectionId() {
        return shopSectionId;
    }

    public void setShopSectionId(Long shopSectionId) {
        this.shopSectionId = shopSectionId;
    }

    @Override
    public Object getFeaturedRank() {
        return featuredRank;
    }

    public void setFeaturedRank(Object featuredRank) {
        this.featuredRank = featuredRank;
    }

    @Override
    public Float getStateTsz() {
        return stateTsz;
    }

    public void setStateTsz(Float stateTsz) {
        this.stateTsz = stateTsz;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    @Override
    public Long getNumFavorers() {
        return numFavorers;
    }

    public void setNumFavorers(Long numFavorers) {
        this.numFavorers = numFavorers;
    }

    @Override
    public Long getShippingTemplateId() {
        return shippingTemplateId;
    }

    public void setShippingTemplateId(Long shippingTemplateId) {
        this.shippingTemplateId = shippingTemplateId;
    }

    @Override
    public Long getShippingProfileId() {
        return shippingProfileId;
    }

    public void setShippingProfileId(Long shippingProfileId) {
        this.shippingProfileId = shippingProfileId;
    }

    @Override
    public Long getProcessingMin() {
        return processingMin;
    }

    public void setProcessingMin(Long processingMin) {
        this.processingMin = processingMin;
    }

    @Override
    public Long getProcessingMax() {
        return processingMax;
    }

    public void setProcessingMax(Long processingMax) {
        this.processingMax = processingMax;
    }

    @Override
    public String getWhoMade() {
        return whoMade;
    }

    public void setWhoMade(String whoMade) {
        this.whoMade = whoMade;
    }

    @Override
    public Boolean getIsSupply() {
        return isSupply;
    }

    public void setIsSupply(Boolean supply) {
        isSupply = supply;
    }

    @Override
    public String getWhenMade() {
        return whenMade;
    }

    public void setWhenMade(String whenMade) {
        this.whenMade = whenMade;
    }

    @Override
    public Double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(Double itemWeight) {
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
    public Double getItemLength() {
        return itemLength;
    }

    public void setItemLength(Double itemLength) {
        this.itemLength = itemLength;
    }

    @Override
    public Double getItemWidth() {
        return itemWidth;
    }

    public void setItemWidth(Double itemWidth) {
        this.itemWidth = itemWidth;
    }

    @Override
    public Double getItemHeight() {
        return itemHeight;
    }

    public void setItemHeight(Double itemHeight) {
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
    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    @Override
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @Override
    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    @Override
    public List<String> getStyle() {
        return style;
    }

    public void setStyle(List<String> style) {
        this.style = style;
    }

    @Override
    public Boolean getNonTaxable() {
        return nonTaxable;
    }

    public void setNonTaxable(Boolean nonTaxable) {
        this.nonTaxable = nonTaxable;
    }

    @Override
    public Boolean getIsCustomizable() {
        return isCustomizable;
    }

    public void setIsCustomizable(Boolean customizable) {
        isCustomizable = customizable;
    }

    @Override
    public Boolean getIsDigital() {
        return isDigital;
    }

    public void setIsDigital(Boolean digital) {
        isDigital = digital;
    }

    @Override
    public String getFileData() {
        return fileData;
    }

    public void setFileData(String fileData) {
        this.fileData = fileData;
    }

    @Override
    public Boolean getCanWriteInventory() {
        return canWriteInventory;
    }

    public void setCanWriteInventory(Boolean canWriteInventory) {
        this.canWriteInventory = canWriteInventory;
    }

    @Override
    public Boolean getHasVariations() {
        return hasVariations;
    }

    public void setHasVariations(Boolean hasVariations) {
        this.hasVariations = hasVariations;
    }

    @Override
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
    public List<EtsyListingInventory> getInventory() {
        return Inventory;
    }

    public void setInventory(List<EtsyListingInventory> inventory) {
        Inventory = inventory;
    }

    @Override
    public EtsyUser getUser() {
        return User;
    }

    public void setUser(EtsyUser user) {
        User = user;
    }

    @Override
    public EtsyShop getShop() {
        return Shop;
    }

    public void setShop(EtsyShop shop) {
        Shop = shop;
    }

    @Override
    public EtsyShopSection getSection() {
        return Section;
    }

    public void setSection(EtsyShopSection section) {
        Section = section;
    }

    @Override
    public List<EtsyListingImage> getImages() {
        return Images;
    }

    public void setImages(List<EtsyListingImage> images) {
        Images = images;
    }

    @Override
    public EtsyListingImage getMainImage() {
        return MainImage;
    }

    public void setMainImage(EtsyListingImage mainImage) {
        MainImage = mainImage;
    }

    @Override
    public List<EtsyShippingInfo> getShippingInfo() {
        return ShippingInfo;
    }

    public void setShippingInfo(List<EtsyShippingInfo> shippingInfo) {
        ShippingInfo = shippingInfo;
    }

    @Override
    public EtsyShippingTemplate getShippingTemplate() {
        return ShippingTemplate;
    }

    public void setShippingTemplate(EtsyShippingTemplate shippingTemplate) {
        ShippingTemplate = shippingTemplate;
    }

    @Override
    public List<EtsyShippingUpgrade> getShippingUpgrades() {
        return ShippingUpgrades;
    }

    public void setShippingUpgrades(List<EtsyShippingUpgrade> shippingUpgrades) {
        ShippingUpgrades = shippingUpgrades;
    }

    @Override
    public EtsyPaymentInfo getPaymentInfo() {
        return PaymentInfo;
    }

    public void setPaymentInfo(EtsyPaymentInfo paymentInfo) {
        PaymentInfo = paymentInfo;
    }

    @Override
    public List<EtsyListingTranslation> getTranslations() {
        return Translations;
    }

    public void setTranslations(List<EtsyListingTranslation> translations) {
        Translations = translations;
    }

    @Override
    public List<EtsyPropertyValue> getAttributes() {
        return Attributes;
    }

    public void setAttributes(List<EtsyPropertyValue> attributes) {
        Attributes = attributes;
    }
}
