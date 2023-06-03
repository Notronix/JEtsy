package com.notronix.etsy.impl.shops.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.shops.model.Shop;

import java.time.Instant;
import java.util.List;

public class EtsyShop implements Shop
{
    @SerializedName("shop_id")
    private Long id;

    @SerializedName("user_id")
    private Long userId;

    @SerializedName("shop_name")
    private String shopName;

    @SerializedName("create_date")
    private Instant createdDate;

    @SerializedName("created_timestamp")
    private Instant createdTimestamp;

    private String title;
    private String announcement;

    @SerializedName("currency_code")
    private String currencyCode;

    @SerializedName("is_vacation")
    private Boolean vacation;

    @SerializedName("vacation_message")
    private String vacationMessage;

    @SerializedName("sale_message")
    private String saleMessage;

    @SerializedName("digital_sale_message")
    private String digitalSaleMessage;

    @SerializedName("update_date")
    private Instant lastUpdatedDate;

    @SerializedName("updated_timestamp")
    private Instant lastUpdatedTimestamp;

    @SerializedName("listing_active_count")
    private Integer activeListingsCount;

    @SerializedName("digital_listing_count")
    private Integer digitalListingsCount;

    @SerializedName("login_name")
    private String loginName;

    @SerializedName("accepts_custom_requests")
    private Boolean acceptsCustomRequests;

    @SerializedName("policy_welcome")
    private String welcomePolicy;

    @SerializedName("policy_payment")
    private String paymentPolicy;

    @SerializedName("policy_shipping")
    private String shippingPolicy;

    @SerializedName("policy_refunds")
    private String refundPolicy;

    @SerializedName("policy_additional")
    private String additionalPolicy;

    @SerializedName("policy_seller_info")
    private String sellerInfoPolicy;

    @SerializedName("policy_update_date")
    private Instant policiesLastUpdatedDate;

    @SerializedName("policy_has_private_receipt_info")
    private Boolean policyHasPrivateReceiptInfo;

    @SerializedName("has_unstructured_policies")
    private Boolean hasUnstructuredPolicies;

    @SerializedName("policy_privacy")
    private String privacyPolicy;

    @SerializedName("vacation_autoreply")
    private String vacationAutoReply;

    private String url;

    @SerializedName("image_url_760x100")
    private String imageUrl760x100;

    @SerializedName("num_favorers")
    private Integer numberOfFavorers;

    private List<String> languages;

    @SerializedName("icon_url_fullxfull")
    private String iconUrlFullxFull;

    @SerializedName("is_using_structured_policies")
    private Boolean usingStructuredPolicies;

    @SerializedName("has_onboarded_structured_policies")
    private Boolean hasOnboardedStructuredPolicies;

    @SerializedName("include_dispute_form_link")
    private Boolean policiesIncludeDisputeFormLink;

    @SerializedName("is_direct_checkout_onboarded")
    private Boolean directCheckoutOnboarded;

    @SerializedName("is_etsy_payments_onboarded")
    private Boolean etsyPaymentsOnboarded;

    @SerializedName("is_calculated_eligible")
    private Boolean eligibleForCalculatedShipping;

    @SerializedName("is_opted_in_to_buyer_promise")
    private Boolean optedInToBuyerPromise;

    @SerializedName("is_shop_us_based")
    private Boolean uSBased;

    @SerializedName("transaction_sold_count")
    private Integer transactionSoldCount;

    @SerializedName("shipping_from_country_iso")
    private String shippingFromCountryISO;

    @SerializedName("shop_location_country_iso")
    private String locationCountryISO;

    @SerializedName("review_count")
    private Integer reviewCount;

    @SerializedName("review_average")
    private Float reviewAverage;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Instant createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    @Override
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public Boolean isVacation() {
        return vacation;
    }

    public Boolean getVacation() {
        return vacation;
    }

    public void setVacation(Boolean vacation) {
        this.vacation = vacation;
    }

    @Override
    public String getVacationMessage() {
        return vacationMessage;
    }

    public void setVacationMessage(String vacationMessage) {
        this.vacationMessage = vacationMessage;
    }

    @Override
    public String getSaleMessage() {
        return saleMessage;
    }

    public void setSaleMessage(String saleMessage) {
        this.saleMessage = saleMessage;
    }

    @Override
    public String getDigitalSaleMessage() {
        return digitalSaleMessage;
    }

    public void setDigitalSaleMessage(String digitalSaleMessage) {
        this.digitalSaleMessage = digitalSaleMessage;
    }

    @Override
    public Instant getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Instant lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Instant getLastUpdatedTimestamp() {
        return lastUpdatedTimestamp;
    }

    public void setLastUpdatedTimestamp(Instant lastUpdatedTimestamp) {
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }

    @Override
    public Integer getActiveListingsCount() {
        return activeListingsCount;
    }

    public void setActiveListingsCount(Integer activeListingsCount) {
        this.activeListingsCount = activeListingsCount;
    }

    @Override
    public Integer getDigitalListingsCount() {
        return digitalListingsCount;
    }

    public void setDigitalListingsCount(Integer digitalListingsCount) {
        this.digitalListingsCount = digitalListingsCount;
    }

    @Override
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public Boolean acceptsCustomRequests() {
        return acceptsCustomRequests;
    }

    public Boolean getAcceptsCustomRequests() {
        return acceptsCustomRequests;
    }

    public void setAcceptsCustomRequests(Boolean acceptsCustomRequests) {
        this.acceptsCustomRequests = acceptsCustomRequests;
    }

    @Override
    public String getWelcomePolicy() {
        return welcomePolicy;
    }

    public void setWelcomePolicy(String welcomePolicy) {
        this.welcomePolicy = welcomePolicy;
    }

    @Override
    public String getPaymentPolicy() {
        return paymentPolicy;
    }

    public void setPaymentPolicy(String paymentPolicy) {
        this.paymentPolicy = paymentPolicy;
    }

    @Override
    public String getShippingPolicy() {
        return shippingPolicy;
    }

    public void setShippingPolicy(String shippingPolicy) {
        this.shippingPolicy = shippingPolicy;
    }

    @Override
    public String getRefundPolicy() {
        return refundPolicy;
    }

    public void setRefundPolicy(String refundPolicy) {
        this.refundPolicy = refundPolicy;
    }

    @Override
    public String getAdditionalPolicy() {
        return additionalPolicy;
    }

    public void setAdditionalPolicy(String additionalPolicy) {
        this.additionalPolicy = additionalPolicy;
    }

    @Override
    public String getSellerInfoPolicy() {
        return sellerInfoPolicy;
    }

    public void setSellerInfoPolicy(String sellerInfoPolicy) {
        this.sellerInfoPolicy = sellerInfoPolicy;
    }

    @Override
    public Instant getPoliciesLastUpdatedDate() {
        return policiesLastUpdatedDate;
    }

    public void setPoliciesLastUpdatedDate(Instant policiesLastUpdatedDate) {
        this.policiesLastUpdatedDate = policiesLastUpdatedDate;
    }

    @Override
    public Boolean policyHasPrivateReceiptInfo() {
        return policyHasPrivateReceiptInfo;
    }

    public Boolean getPolicyHasPrivateReceiptInfo() {
        return policyHasPrivateReceiptInfo;
    }

    public void setPolicyHasPrivateReceiptInfo(Boolean policyHasPrivateReceiptInfo) {
        this.policyHasPrivateReceiptInfo = policyHasPrivateReceiptInfo;
    }

    @Override
    public Boolean hasUnstructuredPolicies() {
        return hasUnstructuredPolicies;
    }

    public Boolean getHasUnstructuredPolicies() {
        return hasUnstructuredPolicies;
    }

    public void setHasUnstructuredPolicies(Boolean hasUnstructuredPolicies) {
        this.hasUnstructuredPolicies = hasUnstructuredPolicies;
    }

    @Override
    public String getPrivacyPolicy() {
        return privacyPolicy;
    }

    public void setPrivacyPolicy(String privacyPolicy) {
        this.privacyPolicy = privacyPolicy;
    }

    @Override
    public String getVacationAutoReply() {
        return vacationAutoReply;
    }

    public void setVacationAutoReply(String vacationAutoReply) {
        this.vacationAutoReply = vacationAutoReply;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getImageUrl760x100() {
        return imageUrl760x100;
    }

    public void setImageUrl760x100(String imageUrl760x100) {
        this.imageUrl760x100 = imageUrl760x100;
    }

    @Override
    public Integer getNumberOfFavorers() {
        return numberOfFavorers;
    }

    public void setNumberOfFavorers(Integer numberOfFavorers) {
        this.numberOfFavorers = numberOfFavorers;
    }

    @Override
    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public String getIconUrlFullxFull() {
        return iconUrlFullxFull;
    }

    public void setIconUrlFullxFull(String iconUrlFullxFull) {
        this.iconUrlFullxFull = iconUrlFullxFull;
    }

    @Override
    public Boolean isUsingStructuredPolicies() {
        return usingStructuredPolicies;
    }

    public Boolean getUsingStructuredPolicies() {
        return usingStructuredPolicies;
    }

    public void setUsingStructuredPolicies(Boolean usingStructuredPolicies) {
        this.usingStructuredPolicies = usingStructuredPolicies;
    }

    @Override
    public Boolean hasOnboardedStructuredPolicies() {
        return hasOnboardedStructuredPolicies;
    }

    public Boolean getHasOnboardedStructuredPolicies() {
        return hasOnboardedStructuredPolicies;
    }

    public void setHasOnboardedStructuredPolicies(Boolean hasOnboardedStructuredPolicies) {
        this.hasOnboardedStructuredPolicies = hasOnboardedStructuredPolicies;
    }

    @Override
    public Boolean policiesIncludeDisputeFormLink() {
        return policiesIncludeDisputeFormLink;
    }

    public Boolean getPoliciesIncludeDisputeFormLink() {
        return policiesIncludeDisputeFormLink;
    }

    public void setPoliciesIncludeDisputeFormLink(Boolean policiesIncludeDisputeFormLink) {
        this.policiesIncludeDisputeFormLink = policiesIncludeDisputeFormLink;
    }

    @Override
    public Boolean isDirectCheckoutOnboarded() {
        return directCheckoutOnboarded;
    }

    public Boolean getDirectCheckoutOnboarded() {
        return directCheckoutOnboarded;
    }

    public void setDirectCheckoutOnboarded(Boolean directCheckoutOnboarded) {
        this.directCheckoutOnboarded = directCheckoutOnboarded;
    }

    @Override
    public Boolean isEtsyPaymentsOnboarded() {
        return etsyPaymentsOnboarded;
    }

    public Boolean getEtsyPaymentsOnboarded() {
        return etsyPaymentsOnboarded;
    }

    public void setEtsyPaymentsOnboarded(Boolean etsyPaymentsOnboarded) {
        this.etsyPaymentsOnboarded = etsyPaymentsOnboarded;
    }

    @Override
    public Boolean isEligibleForCalculatedShipping() {
        return eligibleForCalculatedShipping;
    }

    public Boolean getEligibleForCalculatedShipping() {
        return eligibleForCalculatedShipping;
    }

    public void setEligibleForCalculatedShipping(Boolean eligibleForCalculatedShipping) {
        this.eligibleForCalculatedShipping = eligibleForCalculatedShipping;
    }

    @Override
    public Boolean isOptedInToBuyerPromise() {
        return optedInToBuyerPromise;
    }

    public Boolean getOptedInToBuyerPromise() {
        return optedInToBuyerPromise;
    }

    public void setOptedInToBuyerPromise(Boolean optedInToBuyerPromise) {
        this.optedInToBuyerPromise = optedInToBuyerPromise;
    }

    @Override
    public Boolean isUSBased() {
        return uSBased;
    }

    public Boolean getUSBased() {
        return uSBased;
    }

    public void setUSBased(Boolean uSBased) {
        this.uSBased = uSBased;
    }

    @Override
    public Integer getTransactionSoldCount() {
        return transactionSoldCount;
    }

    public void setTransactionSoldCount(Integer transactionSoldCount) {
        this.transactionSoldCount = transactionSoldCount;
    }

    @Override
    public String getShippingFromCountryISO() {
        return shippingFromCountryISO;
    }

    public void setShippingFromCountryISO(String shippingFromCountryISO) {
        this.shippingFromCountryISO = shippingFromCountryISO;
    }

    @Override
    public String getLocationCountryISO() {
        return locationCountryISO;
    }

    public void setLocationCountryISO(String locationCountryISO) {
        this.locationCountryISO = locationCountryISO;
    }

    @Override
    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    @Override
    public Float getReviewAverage() {
        return reviewAverage;
    }

    public void setReviewAverage(Float reviewAverage) {
        this.reviewAverage = reviewAverage;
    }
}
