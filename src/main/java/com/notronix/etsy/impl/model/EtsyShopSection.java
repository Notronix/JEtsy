package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.ShopSection;

public class EtsyShopSection implements ShopSection
{
    @SerializedName(value = "shop_section_id")
    private Long shopSectionId;
    private String title;
    private Integer rank;

    @SerializedName(value = "user_id")
    private Long userId;

    @SerializedName(value = "active_listing_count")
    private Integer activeListingCount;

    @Override
    public Long getShopSectionId() {
        return shopSectionId;
    }

    public void setShopSectionId(Long shopSectionId) {
        this.shopSectionId = shopSectionId;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public Integer getActiveListingCount() {
        return activeListingCount;
    }

    public void setActiveListingCount(Integer activeListingCount) {
        this.activeListingCount = activeListingCount;
    }
}
