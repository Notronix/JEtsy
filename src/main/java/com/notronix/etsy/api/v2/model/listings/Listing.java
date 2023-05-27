package com.notronix.etsy.api.v2.model.listings;

import com.notronix.etsy.api.v2.model.shops.ShopSection;
import com.notronix.etsy.api.v2.model.users.ShippingTemplate;
import com.notronix.etsy.api.v2.model.shops.Shop;
import com.notronix.etsy.api.v2.model.users.User;

import java.time.Instant;
import java.util.List;

public interface Listing
{
    Long getListingId();
    ListingState getState();
    Long getUserId();
    Long getCategoryId();
    String getTitle();
    String getDescription();
    Instant getCreationTsz();
    Instant getEndingTsz();
    Instant getOriginalCreationTsz();
    Instant getLastModifiedTsz();
    Float getPrice();
    String getCurrencyCode();
    Integer getQuantity();
    List<String> getSku();
    List<String> getTags();
    List<String> getCategoryPaths();
    List<Long> getCategoryPathIds();
    Long getTaxonomyId();
    Long getSuggestedTaxonomyId();
    List<String> getTaxonomyPaths();
    List<String> getMaterials();
    Long getShopSectionId();
    Object getFeaturedRank();
    Instant getStateTsz();
    String getUrl();
    Long getViews();
    Long getNumFavorers();
    Long getShippingTemplateId();
    Long getShippingProfileId();
    Integer getProcessingMin();
    Integer getProcessingMax();
    String getWhoMade();
    Boolean getIsSupply();
    String getWhenMade();
    Float getItemWeight();
    WeightUnit getItemWeightUnit();
    Float getItemLength();
    Float getItemWidth();
    Float getItemHeight();
    DimensionUnit getItemDimensionsUnit();
    Boolean getIsPrivate();
    String getRecipient();
    String getOccasion();
    List<String> getStyle();
    Boolean getNonTaxable();
    Boolean getIsCustomizable();
    Boolean getIsDigital();
    String getFileData();
    Boolean getCanWriteInventory();
    Boolean getHasVariations();
    Boolean getShouldAutoRenew();
    String getLanguage();

    User getUser();
    Shop getShop();
    ShopSection getSection();
    List<? extends ListingImage> getImages();
    ListingImage getMainImage();
    List<? extends ShippingInfo> getShippingInfo();
    ShippingTemplate getShippingTemplate();
    List<? extends ShippingUpgrade> getShippingUpgrades();
    List<? extends PaymentTemplate> getPaymentInfo();
    List<? extends ListingTranslation> getTranslations();
    List<? extends PropertyValue> getAttributes();
    List<? extends ListingInventory> getInventory();
}
