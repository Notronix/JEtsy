package com.notronix.etsy.api.v2.model.listings;

import java.util.List;

public interface ListingTranslation
{
    Long getListingId();
    String getLanguage();
    String getTitle();
    String getDescription();
    List<String> getTags();
}
