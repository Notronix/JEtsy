package com.notronix.etsy.api.v2.model.users;

import java.time.Instant;

public interface UserProfile
{
    Long getUserId();
    String getLoginName();
    String getBio();
    String getGender();
    String getBirthMonth();
    String getBirthDay();
    String getBirthYear();
    Instant getJoinTsz();
    String getMaterials();
    Long getCountryId();
    String getRegion();
    String getCity();
    Long getAvatarId();
    Float getLat();
    Float getLon();
    Long getTransactionBuyCount();
    Long getTransactionSoldCount();
    Boolean getSeller();
    String getImageUrl75x75();
    String getFirstName();
    String getLastName();
}
