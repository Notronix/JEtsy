package com.notronix.etsy.api.model;

import java.util.List;
import java.util.Map;

public interface User
{
    Long getUserId();
    String getLoginName();
    String getPrimaryEmail();
    Float getCreationTsz();
    Map<String, Object> getUserPubKey();
    Long getReferredByUserId();
    FeedbackInfo getFeedbackInfo();
    Long getAwaitingFeedbackCount();
    Boolean getUseNewInventoryEndpoints();

    List<? extends Shop> getShops();
    UserProfile getProfile();
    List<? extends Receipt> getBuyerReceipts();
    List<? extends Transaction> getBuyerTransactions();
    List<? extends UserAddress> getAddresses();
}
