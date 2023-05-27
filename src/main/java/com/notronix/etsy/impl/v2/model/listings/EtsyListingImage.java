package com.notronix.etsy.impl.v2.model.listings;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.v2.model.listings.ListingImage;

import java.time.Instant;

public class EtsyListingImage implements ListingImage
{
    @SerializedName("listing_image_id")
    private Long listingImageId;

    @SerializedName(value = "hex_code")
    private String hexCode;

    private Integer red;
    private Integer green;
    private Integer blue;
    private Integer hue;
    private Integer saturation;
    private Integer brightness;

    @SerializedName(value = "is_black_and_white")
    private Boolean isBlackAndWhite;

    @SerializedName(value = "creation_tsz")
    private Instant creationTsz;

    @SerializedName(value = "listing_id")
    private Long listingId;
    private Integer rank;

    @SerializedName(value = "url_75x75")
    private String url75x75;

    @SerializedName(value = "url_170x135")
    private String url170x135;

    @SerializedName(value = "url_570xN")
    private String url570xN;

    @SerializedName(value = "url_fullxfull")
    private String urlFullxFull;

    @SerializedName(value = "full_height")
    private Integer fullHeight;

    @SerializedName(value = "full_width")
    private Integer fullWidth;

    @Override
    public Long getListingImageId() {
        return listingImageId;
    }

    public void setListingImageId(Long listingImageId) {
        this.listingImageId = listingImageId;
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
    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    @Override
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public String getUrl75x75() {
        return url75x75;
    }

    public void setUrl75x75(String url75x75) {
        this.url75x75 = url75x75;
    }

    @Override
    public String getUrl170x135() {
        return url170x135;
    }

    public void setUrl170x135(String url170x135) {
        this.url170x135 = url170x135;
    }

    @Override
    public String getUrl570xN() {
        return url570xN;
    }

    public void setUrl570xN(String url570xN) {
        this.url570xN = url570xN;
    }

    @Override
    public String getUrlFullxFull() {
        return urlFullxFull;
    }

    public void setUrlFullxFull(String urlFullxFull) {
        this.urlFullxFull = urlFullxFull;
    }

    @Override
    public Integer getFullHeight() {
        return fullHeight;
    }

    public void setFullHeight(Integer fullHeight) {
        this.fullHeight = fullHeight;
    }

    @Override
    public Integer getFullWidth() {
        return fullWidth;
    }

    public void setFullWidth(Integer fullWidth) {
        this.fullWidth = fullWidth;
    }
}
