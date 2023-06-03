package com.notronix.etsy.api.listings.model;

import com.notronix.etsy.api.common.model.DimensionUnit;
import com.notronix.etsy.api.common.model.Price;
import com.notronix.etsy.api.common.model.WeightUnit;
import com.notronix.etsy.api.shops.model.ShippingProfile;
import com.notronix.etsy.api.shops.model.Shop;
import com.notronix.etsy.api.users.model.User;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public interface Listing
{
    Long getId();

    Long getUserId();

    Long getShopId();

    String getTitle();

    String getDescription();

    ListingState getState();

    Instant getCreationTimestamp();

    Instant getCreatedTimestamp();

    Instant getEndingTimestamp();

    Instant getOriginalCreationTimestamp();

    Instant getLastModifiedTimestamp();

    Instant getUpdatedTimestamp();

    Instant getStateTimestamp();

    Integer getQuantity();

    Long getShopSectionId();

    Integer getFeaturedRank();

    String getUrl();

    Long getNumberOfFavorers();

    Boolean getNonTaxable();

    Boolean isTaxable();

    Boolean isCustomizable();

    Boolean isPersonalizable();

    Boolean isPersonalizationRequired();

    Integer getMaxPersonalizationCharacterCount();

    String getPersonalizationInstructions();

    ListingType getType();

    List<String> getTags();

    List<String> getMaterials();

    Long getShippingProfileId();

    Long getReturnPolicyId();

    Integer getProcessingMin();

    Integer getProcessingMax();

    WhoMade getWhoMade();

    WhenMade getWhenMade();

    Boolean isSupply();

    Float getItemWeight();

    WeightUnit getItemWeightUnit();

    Float getItemLength();

    Float getItemWidth();

    Float getItemHeight();

    DimensionUnit getItemDimensionsUnit();

    Boolean isPrivate();

    List<String> getStyles();

    String getFileData();

    Boolean hasVariations();

    Boolean shouldAutoRenew();

    String getLanguage();

    Price getPrice();

    Long getTaxonomyId();

    ShippingProfile getShippingProfile();

    User getUser();

    Shop getShop();

    List<? extends ListingImage> getImages();

    List<? extends ListingVideo> getVideos();

    ListingInventory getInventory();

    List<? extends ProductionPartner> getProductionPartners();

    List<String> getSkus();

    Map<String, ? extends ListingTranslation> getTranslations();

    Long getViews();
}
