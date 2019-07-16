package com.notronix.etsy.api.model;

public interface ListingImage
{
    Long getListingImageId();
    String getHexCode();
    Integer getRed();
    Integer getGreen();
    Integer getBlue();
    Integer getHue();
    Integer getSaturation();
    Integer getBrightness();
    Boolean getBlackAndWhite();
    Float getCreationTsz();
    Long getListingId();
    Integer getRank();
    String getUrl75x75();
    String getUrl170x135();
    String getUrl570xN();
    String getUrlFullxFull();
    Integer getFullHeight();
    Integer getFullWidth();
}
