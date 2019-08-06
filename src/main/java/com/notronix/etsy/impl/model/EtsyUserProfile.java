package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.UserProfile;

import java.time.Instant;

public class EtsyUserProfile implements UserProfile
{
    @SerializedName(value = "user_id")
    private Long userId;

    @SerializedName(value = "login_name")
    private String loginName;
    private String bio;
    private String gender;

    @SerializedName(value = "birth_month")
    private String birthMonth;

    @SerializedName(value = "birth_day")
    private String birthDay;

    @SerializedName(value = "birth_year")
    private String birthYear;

    @SerializedName(value = "join_tsz")
    private Instant joinTsz;
    private String materials;

    @SerializedName(value = "country_id")
    private Long countryId;
    private String region;
    private String city;

    @SerializedName(value = "avatar_id")
    private Long avatarId;
    private Float lat;
    private Float lon;

    @SerializedName(value = "transaction_buy_count")
    private Long transactionBuyCount;

    @SerializedName(value = "transaction_sold_count")
    private Long transactionSoldCount;

    @SerializedName(value = "is_seller")
    private Boolean seller;

    @SerializedName(value = "image_url_75x75")
    private String imageUrl75x75;

    @SerializedName(value = "first_name")
    private String firstName;

    @SerializedName(value = "last_name")
    private String lastName;

    @Override
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    @Override
    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public Instant getJoinTsz() {
        return joinTsz;
    }

    public void setJoinTsz(Instant joinTsz) {
        this.joinTsz = joinTsz;
    }

    @Override
    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    @Override
    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    @Override
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public Long getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Long avatarId) {
        this.avatarId = avatarId;
    }

    @Override
    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    @Override
    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    @Override
    public Long getTransactionBuyCount() {
        return transactionBuyCount;
    }

    public void setTransactionBuyCount(Long transactionBuyCount) {
        this.transactionBuyCount = transactionBuyCount;
    }

    @Override
    public Long getTransactionSoldCount() {
        return transactionSoldCount;
    }

    public void setTransactionSoldCount(Long transactionSoldCount) {
        this.transactionSoldCount = transactionSoldCount;
    }

    @Override
    public Boolean getSeller() {
        return seller;
    }

    public void setSeller(Boolean seller) {
        this.seller = seller;
    }

    @Override
    public String getImageUrl75x75() {
        return imageUrl75x75;
    }

    public void setImageUrl75x75(String imageUrl75x75) {
        this.imageUrl75x75 = imageUrl75x75;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
