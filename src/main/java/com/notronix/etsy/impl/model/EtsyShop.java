package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.Shop;

import java.util.List;

public class EtsyShop implements Shop
{
    @SerializedName(value = "shop_id")
    private Long shopId;

    @SerializedName(value = "shop_name")
    private String shopName;

    @SerializedName(value = "user_id")
    private Long userId;

    @SerializedName(value = "creation_tsz")
    private Float creationTsz;
    private String title;
    private String announcement;

    @SerializedName(value = "currency_code")
    private String currencyCode;

    @SerializedName(value = "is_vacation")
    private Boolean vacation;

    @SerializedName(value = "vacation_message")
    private String vacationMessage;

    @SerializedName(value = "sale_message")
    private String saleMessage;

    @SerializedName(value = "digital_sale_message")
    private String digitalSaleMessage;

    @SerializedName(value = "last_updated_tsz")
    private Float lastUpdatedTsz;

    @SerializedName(value = "listing_active_count")
    private Integer listingActiveCount;

    @SerializedName(value = "digital_listing_count")
    private Integer digitalListingCount;

    @SerializedName(value = "login_name")
    private String loginName;
    private Float lat;
    private Float lon;

    @SerializedName(value = "accepts_custom_requests")
    private Boolean acceptsCustomRequests;

    @SerializedName(value = "policy_welcome")
    private String policyWelcome;

    @SerializedName(value = "policy_payment")
    private String policyPayment;

    @SerializedName(value = "policy_shipping")
    private String policyShipping;

    @SerializedName(value = "policy_refunds")
    private String policyRefunds;

    @SerializedName(value = "policy_additional")
    private String policyAdditional;

    @SerializedName(value = "policy_seller_info")
    private String policySellerInfo;

    @SerializedName(value = "policy_updated_tsz")
    private Float policyUpdatedTsz;

    @SerializedName(value = "policy_has_private_receipt_info")
    private Boolean policyHasPrivateReceiptInfo;

    @SerializedName(value = "vacation_autoreply")
    private String vacationAutoReply;

    @SerializedName(value = "ga_code")
    private String gaCode;
    private String url;

    @SerializedName(value = "image_url_760x100")
    private String imageUrl760x100;

    @SerializedName(value = "num_favorers")
    private Long numFavorers;
    private List<String> languages;

    @SerializedName(value = "upcoming_local_event_id")
    private Long upcomingLocalEventId;

    @SerializedName(value = "icon_url_fullxfull")
    private String iconUrlFullxFull;

    @SerializedName(value = "is_using_structured_policies")
    private Boolean usingStructuredPolicies;

    @SerializedName(value = "has_onboarded_structured_policies")
    private Boolean hasOnboardedStructuredPolicies;

    @SerializedName(value = "has_unstructured_policies")
    private Boolean hasUnstructuredPolicies;

    @SerializedName(value = "policy_privacy")
    private String policyPrivacy;

    @SerializedName(value = "use_new_inventory_endpoints")
    private Boolean useNewInventoryEndpoints;

    @SerializedName(value = "include_dispute_form_link")
    private Boolean includeDisputeFormLink;

    @Override
    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    @Override
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public Float getCreationTsz() {
        return creationTsz;
    }

    public void setCreationTsz(Float creationTsz) {
        this.creationTsz = creationTsz;
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
    public Float getLastUpdatedTsz() {
        return lastUpdatedTsz;
    }

    public void setLastUpdatedTsz(Float lastUpdatedTsz) {
        this.lastUpdatedTsz = lastUpdatedTsz;
    }

    @Override
    public Integer getListingActiveCount() {
        return listingActiveCount;
    }

    public void setListingActiveCount(Integer listingActiveCount) {
        this.listingActiveCount = listingActiveCount;
    }

    @Override
    public Integer getDigitalListingCount() {
        return digitalListingCount;
    }

    public void setDigitalListingCount(Integer digitalListingCount) {
        this.digitalListingCount = digitalListingCount;
    }

    @Override
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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
    public Boolean getAcceptsCustomRequests() {
        return acceptsCustomRequests;
    }

    public void setAcceptsCustomRequests(Boolean acceptsCustomRequests) {
        this.acceptsCustomRequests = acceptsCustomRequests;
    }

    @Override
    public String getPolicyWelcome() {
        return policyWelcome;
    }

    public void setPolicyWelcome(String policyWelcome) {
        this.policyWelcome = policyWelcome;
    }

    @Override
    public String getPolicyPayment() {
        return policyPayment;
    }

    public void setPolicyPayment(String policyPayment) {
        this.policyPayment = policyPayment;
    }

    @Override
    public String getPolicyShipping() {
        return policyShipping;
    }

    public void setPolicyShipping(String policyShipping) {
        this.policyShipping = policyShipping;
    }

    @Override
    public String getPolicyRefunds() {
        return policyRefunds;
    }

    public void setPolicyRefunds(String policyRefunds) {
        this.policyRefunds = policyRefunds;
    }

    @Override
    public String getPolicyAdditional() {
        return policyAdditional;
    }

    public void setPolicyAdditional(String policyAdditional) {
        this.policyAdditional = policyAdditional;
    }

    @Override
    public String getPolicySellerInfo() {
        return policySellerInfo;
    }

    public void setPolicySellerInfo(String policySellerInfo) {
        this.policySellerInfo = policySellerInfo;
    }

    @Override
    public Float getPolicyUpdatedTsz() {
        return policyUpdatedTsz;
    }

    public void setPolicyUpdatedTsz(Float policyUpdatedTsz) {
        this.policyUpdatedTsz = policyUpdatedTsz;
    }

    @Override
    public Boolean getPolicyHasPrivateReceiptInfo() {
        return policyHasPrivateReceiptInfo;
    }

    public void setPolicyHasPrivateReceiptInfo(Boolean policyHasPrivateReceiptInfo) {
        this.policyHasPrivateReceiptInfo = policyHasPrivateReceiptInfo;
    }

    @Override
    public String getVacationAutoReply() {
        return vacationAutoReply;
    }

    public void setVacationAutoReply(String vacationAutoReply) {
        this.vacationAutoReply = vacationAutoReply;
    }

    @Override
    public String getGaCode() {
        return gaCode;
    }

    public void setGaCode(String gaCode) {
        this.gaCode = gaCode;
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
    public Long getNumFavorers() {
        return numFavorers;
    }

    public void setNumFavorers(Long numFavorers) {
        this.numFavorers = numFavorers;
    }

    @Override
    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public Long getUpcomingLocalEventId() {
        return upcomingLocalEventId;
    }

    public void setUpcomingLocalEventId(Long upcomingLocalEventId) {
        this.upcomingLocalEventId = upcomingLocalEventId;
    }

    @Override
    public String getIconUrlFullxFull() {
        return iconUrlFullxFull;
    }

    public void setIconUrlFullxFull(String iconUrlFullxFull) {
        this.iconUrlFullxFull = iconUrlFullxFull;
    }

    @Override
    public Boolean getUsingStructuredPolicies() {
        return usingStructuredPolicies;
    }

    public void setUsingStructuredPolicies(Boolean usingStructuredPolicies) {
        this.usingStructuredPolicies = usingStructuredPolicies;
    }

    @Override
    public Boolean getHasOnboardedStructuredPolicies() {
        return hasOnboardedStructuredPolicies;
    }

    public void setHasOnboardedStructuredPolicies(Boolean hasOnboardedStructuredPolicies) {
        this.hasOnboardedStructuredPolicies = hasOnboardedStructuredPolicies;
    }

    @Override
    public Boolean getHasUnstructuredPolicies() {
        return hasUnstructuredPolicies;
    }

    public void setHasUnstructuredPolicies(Boolean hasUnstructuredPolicies) {
        this.hasUnstructuredPolicies = hasUnstructuredPolicies;
    }

    @Override
    public String getPolicyPrivacy() {
        return policyPrivacy;
    }

    public void setPolicyPrivacy(String policyPrivacy) {
        this.policyPrivacy = policyPrivacy;
    }

    @Override
    public Boolean getUseNewInventoryEndpoints() {
        return useNewInventoryEndpoints;
    }

    public void setUseNewInventoryEndpoints(Boolean useNewInventoryEndpoints) {
        this.useNewInventoryEndpoints = useNewInventoryEndpoints;
    }

    @Override
    public Boolean getIncludeDisputeFormLink() {
        return includeDisputeFormLink;
    }

    public void setIncludeDisputeFormLink(Boolean includeDisputeFormLink) {
        this.includeDisputeFormLink = includeDisputeFormLink;
    }
}
