package com.notronix.etsy.api.model;

import java.util.List;

public interface ShopAbout
{
    Long getShopId();
    String getStatus();
    String getStoryHeadline();
    String getStoryLeadingParagraph();
    String getStory();
    List<String> getRelatedLinks();
    String getUrl();}
