package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.StructuredPolicies;

import java.util.Map;

public class EtsyStructuredPolicies implements StructuredPolicies
{
    @SerializedName(value = "structured_policies_id")
    private Long structuredPoliciesId;

    private Map<String, Object> payments; // TODO: determine real structure here from json payload
    private Map<String, Object> refunds; // TODO: determine real structure here from json payload
    private Map<String, Object> shipping; // TODO: determine real structure here from json payload

    @SerializedName(value = "create_date")
    private Long createDate;

    @SerializedName(value = "update_date")
    private Long updateDate;

    @SerializedName(value = "create_date_formatted")
    private String createDateFormatted;

    @SerializedName(value = "update_date_formatted")
    private String updateDateFormatted;

    @SerializedName(value = "has_unstructured_policies")
    private Boolean hasUnstructuredPolicies;

    @SerializedName(value = "additional_terms_and_conditions")
    private String additionalTermsAndConditions;

    @SerializedName(value = "shop_in_germany")
    private Boolean shopInGermany;

    @SerializedName(value = "char_limits")
    private Object charLimits;

    @SerializedName(value = "include_dispute_form_link")
    private Boolean includeDisputeFormLink;

    private Map<String, Object> privacy; // TODO: determine real structure here from json payload

    @Override
    public Long getStructuredPoliciesId() {
        return structuredPoliciesId;
    }

    public void setStructuredPoliciesId(Long structuredPoliciesId) {
        this.structuredPoliciesId = structuredPoliciesId;
    }

    @Override
    public Map<String, Object> getPayments() {
        return payments;
    }

    public void setPayments(Map<String, Object> payments) {
        this.payments = payments;
    }

    @Override
    public Map<String, Object> getRefunds() {
        return refunds;
    }

    public void setRefunds(Map<String, Object> refunds) {
        this.refunds = refunds;
    }

    @Override
    public Map<String, Object> getShipping() {
        return shipping;
    }

    public void setShipping(Map<String, Object> shipping) {
        this.shipping = shipping;
    }

    @Override
    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    @Override
    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String getCreateDateFormatted() {
        return createDateFormatted;
    }

    public void setCreateDateFormatted(String createDateFormatted) {
        this.createDateFormatted = createDateFormatted;
    }

    @Override
    public String getUpdateDateFormatted() {
        return updateDateFormatted;
    }

    public void setUpdateDateFormatted(String updateDateFormatted) {
        this.updateDateFormatted = updateDateFormatted;
    }

    @Override
    public Boolean getHasUnstructuredPolicies() {
        return hasUnstructuredPolicies;
    }

    public void setHasUnstructuredPolicies(Boolean hasUnstructuredPolicies) {
        this.hasUnstructuredPolicies = hasUnstructuredPolicies;
    }

    @Override
    public String getAdditionalTermsAndConditions() {
        return additionalTermsAndConditions;
    }

    public void setAdditionalTermsAndConditions(String additionalTermsAndConditions) {
        this.additionalTermsAndConditions = additionalTermsAndConditions;
    }

    @Override
    public Boolean getShopInGermany() {
        return shopInGermany;
    }

    public void setShopInGermany(Boolean shopInGermany) {
        this.shopInGermany = shopInGermany;
    }

    @Override
    public Object getCharLimits() {
        return charLimits;
    }

    public void setCharLimits(Object charLimits) {
        this.charLimits = charLimits;
    }

    @Override
    public Boolean getIncludeDisputeFormLink() {
        return includeDisputeFormLink;
    }

    public void setIncludeDisputeFormLink(Boolean includeDisputeFormLink) {
        this.includeDisputeFormLink = includeDisputeFormLink;
    }

    @Override
    public Map<String, Object> getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Map<String, Object> privacy) {
        this.privacy = privacy;
    }
}
