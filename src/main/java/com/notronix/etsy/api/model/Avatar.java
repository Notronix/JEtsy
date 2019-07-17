package com.notronix.etsy.api.model;

public interface Avatar
{
    Long getAvatarId();
    String getHexCode();
    Integer getRed();
    Integer getGreen();
    Integer getBlue();
    Integer getHue();
    Integer getSaturation();
    Integer getBrightness();
    Boolean getBlackAndWhite();
    Float getCreationTsz();
    Long getUserId();
}
