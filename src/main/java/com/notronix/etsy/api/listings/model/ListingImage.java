package com.notronix.etsy.api.listings.model;

import java.time.Instant;

public interface ListingImage
{
    Long getId();

    Long getListingId();

    String getHexCode();

    Integer getRed();

    Integer getGreen();

    Integer getBlue();

    Integer getHue();

    Integer getSaturation();

    Integer getBrightness();

    Boolean getBlackAndWhite();

    Instant getCreationTimestamp();

    Instant getCreatedTimestamp();

    Integer getRank();

    String getUrl75x75();

    String getUrl170x135();

    String getUrl570xN();

    String getUrlFullxFull();

    Integer getFullHeight();

    Integer getFullWidth();

    String getAltText();
}
