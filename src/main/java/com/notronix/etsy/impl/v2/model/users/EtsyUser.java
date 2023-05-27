package com.notronix.etsy.impl.v2.model.users;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.v2.model.users.User;
import com.notronix.etsy.impl.v2.model.shops.EtsyTransaction;
import com.notronix.etsy.impl.v2.model.shops.EtsyReceipt;
import com.notronix.etsy.impl.v2.model.shops.EtsyShop;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class EtsyUser implements User
{
    @SerializedName("user_id")
    private Long userId;

    @SerializedName("login_name")
    private String loginName;

    @SerializedName("primary_email")
    private String primaryEmail;

    @SerializedName("creation_tsz")
    private Instant creationTsz;

    @SerializedName("user_pub_key")
    private Map<String, Object> userPubKey;

    @SerializedName("referred_by_user_id")
    private Long referredByUserId;

    @SerializedName("feedback_info")
    private EtsyFeedbackInfo feedbackInfo;

    @SerializedName("awaiting_feedback_count")
    private Long awaitingFeedbackCount;

    @SerializedName("use_new_inventory_endpoints")
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
    public Instant getCreationTsz() {
        return creationTsz;
    }

    public void setCreationTsz(Instant creationTsz) {
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
