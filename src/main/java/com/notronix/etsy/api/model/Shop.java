package com.notronix.etsy.api.model;

import java.util.List;

public interface Shop
{
    Long getShopId();
    String getShopName();
    Long getUserId();    
    Float getCreationTsz();
    String getTitle();
    String getAnnouncement();
    String getCurrencyCode();
    Boolean getVacation();
    String getVacationMessage();
    String getSaleMessage();
    String getDigitalSaleMessage();
    Float getLastUpdatedTsz();
    Integer getListingActiveCount();
    Integer getDigitalListingCount();
    String getLoginName();
    Float getLat();
    Float getLon();
    Boolean getAcceptsCustomRequests();
    String getPolicyWelcome();
    String getPolicyPayment();
    String getPolicyShipping();
    String getPolicyRefunds();
    String getPolicyAdditional();
    String getPolicySellerInfo();
    Float getPolicyUpdatedTsz();
    Boolean getPolicyHasPrivateReceiptInfo();
    String getVacationAutoReply();
    String getGaCode();
    String getUrl();
    String getImageUrl760x100();
    Long getNumFavorers();
    List<String> getLanguages();
    Long getUpcomingLocalEventId();
    String getIconUrlFullxFull();
    Boolean getUsingStructuredPolicies();
    Boolean getHasOnboardedStructuredPolicies();
    Boolean getHasUnstructuredPolicies();
    String getPolicyPrivacy();
    Boolean getUseNewInventoryEndpoints();
    Boolean getIncludeDisputeFormLink();
}
