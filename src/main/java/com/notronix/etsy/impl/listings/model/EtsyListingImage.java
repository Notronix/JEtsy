package com.notronix.etsy.impl.listings.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.listings.model.ListingImage;

import java.time.Instant;

public class EtsyListingImage implements ListingImage
{
    @SerializedName("listing_image_id")
    private Long id;
    @SerializedName("listing_id")
    private Long listingId;

    @SerializedName("hex_code")
    private String hexCode;

    private Integer red;
    private Integer green;
    private Integer blue;
    private Integer hue;
    private Integer saturation;
    private Integer brightness;

    @SerializedName("is_black_and_white")
    private Boolean blackAndWhite;

    @SerializedName("creation_tsz")
    private Instant creationTimestamp;

    @SerializedName("created_timestamp")
    private Instant createdTimestamp;

    private Integer rank;

    @SerializedName("url_75x75")
    private String url75x75;

    @SerializedName("url_170x135")
    private String url170x135;

    @SerializedName("url_570xN")
    private String url570xN;

    @SerializedName("url_fullxfull")
    private String urlFullxFull;

    @SerializedName("full_height")
    private Integer fullHeight;

    @SerializedName("full_width")
    private Integer fullWidth;

    @SerializedName("alt_text")
    private String altText;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
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
        return blackAndWhite;
    }

    public void setBlackAndWhite(Boolean blackAndWhite) {
        this.blackAndWhite = blackAndWhite;
    }

    public Instant getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Instant creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Instant getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Instant createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
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

    @Override
    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }
}
