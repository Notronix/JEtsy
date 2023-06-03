package com.notronix.etsy.api.listings.model;

public interface ListingVideo
{
    Long getId();

    Integer getHeight();

    Integer getWidth();

    String getThumbnailUrl();

    String getUrl();

    VideoState getState();
}
