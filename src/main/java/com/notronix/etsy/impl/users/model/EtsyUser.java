package com.notronix.etsy.impl.users.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.users.model.User;

public class EtsyUser implements User
{
    @SerializedName("user_id")
    private Long userId;

    @SerializedName("primary_email")
    private String primaryEmail;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("image_url_75x75")
    private String imageUrl75x75;

    @Override
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
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

    @Override
    public String getImageUrl75x75() {
        return imageUrl75x75;
    }

    public void setImageUrl75x75(String imageUrl75x75) {
        this.imageUrl75x75 = imageUrl75x75;
    }
}
