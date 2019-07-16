package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.User;

import java.util.List;
import java.util.Map;

public class EtsyUser implements User
{
    @SerializedName(value = "user_id")
    private Long userId;

    @SerializedName(value = "login_name")
    private String loginName;

    @SerializedName(value = "primary_email")
    private String primaryEmail;

    @SerializedName(value = "creation_tsz")
    private Float creationTsz;

    @SerializedName(value = "user_pub_key")
    private Map<String, Object> userPubKey;

    @SerializedName(value = "referred_by_user_id")
    private Long referredByUserId;

    @SerializedName(value = "feedback_info")
    private EtsyFeedbackInfo feedbackInfo;

    @SerializedName(value = "awaiting_feedback_count")
    private Long awaitingFeedbackCount;

    @SerializedName(value = "use_new_inventory_endpoints")
    private Boolean useNewInventoryEndpoints;

    private List<EtsyShop> Shops;
    private EtsyUserProfile Profile;
    private List<EtsyReceipt> BuyerReceipts;
    private List<EtsyTransaction> BuyerTransactions;
    private List<EtsyUserAddress> Addresses;

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
    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    @Override
    public Float getCreationTsz() {
        return creationTsz;
    }

    public void setCreationTsz(Float creationTsz) {
        this.creationTsz = creationTsz;
    }

    @Override
    public Map<String, Object> getUserPubKey() {
        return userPubKey;
    }

    public void setUserPubKey(Map<String, Object> userPubKey) {
        this.userPubKey = userPubKey;
    }

    @Override
    public Long getReferredByUserId() {
        return referredByUserId;
    }

    public void setReferredByUserId(Long referredByUserId) {
        this.referredByUserId = referredByUserId;
    }

    @Override
    public EtsyFeedbackInfo getFeedbackInfo() {
        return feedbackInfo;
    }

    public void setFeedbackInfo(EtsyFeedbackInfo feedbackInfo) {
        this.feedbackInfo = feedbackInfo;
    }

    @Override
    public Long getAwaitingFeedbackCount() {
        return awaitingFeedbackCount;
    }

    public void setAwaitingFeedbackCount(Long awaitingFeedbackCount) {
        this.awaitingFeedbackCount = awaitingFeedbackCount;
    }

    @Override
    public Boolean getUseNewInventoryEndpoints() {
        return useNewInventoryEndpoints;
    }

    public void setUseNewInventoryEndpoints(Boolean useNewInventoryEndpoints) {
        this.useNewInventoryEndpoints = useNewInventoryEndpoints;
    }

    @Override
    public List<EtsyShop> getShops() {
        return Shops;
    }

    public void setShops(List<EtsyShop> shops) {
        Shops = shops;
    }

    @Override
    public EtsyUserProfile getProfile() {
        return Profile;
    }

    public void setProfile(EtsyUserProfile profile) {
        Profile = profile;
    }

    @Override
    public List<EtsyReceipt> getBuyerReceipts() {
        return BuyerReceipts;
    }

    public void setBuyerReceipts(List<EtsyReceipt> buyerReceipts) {
        BuyerReceipts = buyerReceipts;
    }

    @Override
    public List<EtsyTransaction> getBuyerTransactions() {
        return BuyerTransactions;
    }

    public void setBuyerTransactions(List<EtsyTransaction> buyerTransactions) {
        BuyerTransactions = buyerTransactions;
    }

    @Override
    public List<EtsyUserAddress> getAddresses() {
        return Addresses;
    }

    public void setAddresses(List<EtsyUserAddress> addresses) {
        Addresses = addresses;
    }
}
