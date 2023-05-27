package com.notronix.etsy.api.v2.model.shops;

import com.notronix.etsy.api.v2.model.listings.Listing;
import com.notronix.etsy.api.v2.model.users.User;

import java.time.Instant;
import java.util.List;

public interface Shop
{
    Long getShopId();
    String getShopName();
    Long getUserId();
    Instant getCreationTsz();
    String getTitle();
    String getAnnouncement();
    String getCurrencyCode();
    Boolean getVacation();
    String getVacationMessage();
    String getSaleMessage();
    String getDigitalSaleMessage();
    Instant getLastUpdatedTsz();
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
    Instant getPolicyUpdatedTsz();
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

    User getUser();
    ShopAbout getAbout();
    List<? extends ShopSection> getSections();
    List<? extends Listing> getListings();
    List<? extends Receipt> getReceipts();
    List<? extends Transaction> getTransactions();
    List<? extends ShopTranslation> getTranslations();
    StructuredPolicies getStructuredPolicies();
    SellerDetails getSellerDetails();
    List<? extends FrequentlyAskedQuestion> getFAQ();
}
