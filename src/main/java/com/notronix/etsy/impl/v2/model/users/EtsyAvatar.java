package com.notronix.etsy.impl.v2.model.users;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.v2.model.users.Avatar;

import java.time.Instant;

public class EtsyAvatar implements Avatar
{
    @SerializedName("avatar_id")
    private Long avatarId;

    @SerializedName("hex_code")
    private String hexCode;

    private Integer red;
    private Integer green;
    private Integer blue;
    private Integer hue;
    private Integer saturation;
    private Integer brightness;

    @SerializedName("is_black_and_white")
    private Boolean isBlackAndWhite;

    @SerializedName("creation_tsz")
    private Instant creationTsz;

    @SerializedName("user_id")
    private Long userId;

    @Override
    public Long getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Long avatarId) {
        this.avatarId = avatarId;
    }

    @Override
    public String getHexCode() {
        return hexCode;
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
    }

    @Override
    public Integer getRed() {
        return red;
    }

    public void setRed(Integer red) {
        this.red = red;
    }

    @Override
    public Integer getGreen() {
        return green;
    }

    public void setGreen(Integer green) {
        this.green = green;
    }

    @Override
    public Integer getBlue() {
        return blue;
    }

    public void setBlue(Integer blue) {
        this.blue = blue;
    }

    @Override
    public Integer getHue() {
        return hue;
    }

    public void setHue(Integer hue) {
        this.hue = hue;
    }

    @Override
    public Integer getSaturation() {
        return saturation;
    }

    public void setSaturation(Integer saturation) {
        this.saturation = saturation;
    }

    @Override
    public Integer getBrightness() {
        return brightness;
    }

    public void setBrightness(Integer brightness) {
        this.brightness = brightness;
    }

    @Override
    public Boolean getBlackAndWhite() {
        return isBlackAndWhite;
    }

    public void setBlackAndWhite(Boolean blackAndWhite) {
        isBlackAndWhite = blackAndWhite;
    }

    @Override
    public Instant getCreationTsz() {
        return creationTsz;
    }

    public void setCreationTsz(Instant creationTsz) {
        this.creationTsz = creationTsz;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
