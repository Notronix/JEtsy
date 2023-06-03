package com.notronix.etsy.api.listings.model;

import java.util.List;

public interface ListingTranslation
{
    Long getListingId();
    String getLanguage();
    String getTitle();
    String getDescription();
    List<String> getTags();
}
