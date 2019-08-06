package com.notronix.etsy.api.model;

import java.time.Instant;

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
    Instant getCreationTsz();
    Long getUserId();
}
