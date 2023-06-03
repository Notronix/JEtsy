package com.notronix.etsy.api.shops.model;

import java.time.Instant;
import java.util.List;

public interface Shop
{
    Long getId();
    Long getUserId();
    String getShopName();
    Instant getCreatedDate();
    String getTitle();
    String getAnnouncement();
    String getCurrencyCode();
    Boolean isVacation();
    String getVacationMessage();
    String getSaleMessage();
    String getDigitalSaleMessage();
    Instant getLastUpdatedDate();
    Integer getActiveListingsCount();
    Integer getDigitalListingsCount();
    String getLoginName();
    Boolean acceptsCustomRequests();
    String getWelcomePolicy();
    String getPaymentPolicy();
    String getShippingPolicy();
    String getRefundPolicy();
    String getAdditionalPolicy();
    String getSellerInfoPolicy();
    Instant getPoliciesLastUpdatedDate();
    Boolean policyHasPrivateReceiptInfo();
    Boolean hasUnstructuredPolicies();
    String getPrivacyPolicy();
    String getVacationAutoReply();
    String getUrl();
    String getImageUrl760x100();
    Integer getNumberOfFavorers();
    List<String> getLanguages();
    String getIconUrlFullxFull();
    Boolean isUsingStructuredPolicies();
    Boolean hasOnboardedStructuredPolicies();
    Boolean policiesIncludeDisputeFormLink();
    Boolean isDirectCheckoutOnboarded();
    Boolean isEtsyPaymentsOnboarded();
    Boolean isEligibleForCalculatedShipping();
    Boolean isOptedInToBuyerPromise();
    Boolean isUSBased();
    Integer getTransactionSoldCount();
    String getShippingFromCountryISO();
    String getLocationCountryISO();
    Integer getReviewCount();
    Float getReviewAverage();
}
