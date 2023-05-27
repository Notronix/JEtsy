package com.notronix.etsy.impl.v2.model.shops;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.v2.model.shops.ShopAbout;

public class EtsyShopAbout implements ShopAbout
{
    @SerializedName("shop_id")
    private Long shopId;

    private String status;

    @SerializedName("story_headline")
    private String storyHeadline;

    @SerializedName("story_leading_paragraph")
    private String storyLeadingParagraph;

    private String story;

    @SerializedName("related_links")
    private EtsyRelatedLinks relatedLinks;

    private String url;

    @Override
    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    @Override
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getStoryHeadline() {
        return storyHeadline;
    }

    public void setStoryHeadline(String storyHeadline) {
        this.storyHeadline = storyHeadline;
    }

    @Override
    public String getStoryLeadingParagraph() {
        return storyLeadingParagraph;
    }

    public void setStoryLeadingParagraph(String storyLeadingParagraph) {
        this.storyLeadingParagraph = storyLeadingParagraph;
    }

    @Override
    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    @Override
    public EtsyRelatedLinks getRelatedLinks() {
        return relatedLinks;
    }

    public void setRelatedLinks(EtsyRelatedLinks relatedLinks) {
        this.relatedLinks = relatedLinks;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
