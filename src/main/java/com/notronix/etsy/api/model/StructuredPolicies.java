package com.notronix.etsy.api.model;

import java.util.Map;

public interface StructuredPolicies
{
    Long getStructuredPoliciesId();
    Map<String, Object> getPayments();
    Map<String, Object> getRefunds();
    Map<String, Object> getShipping();
    Long getCreateDate();
    Long getUpdateDate();
    String getCreateDateFormatted();
    String getUpdateDateFormatted();
    Boolean getHasUnstructuredPolicies();
    String getAdditionalTermsAndConditions();
    Boolean getShopInGermany();
    Object getCharLimits();
    Boolean getIncludeDisputeFormLink();
    Map<String, Object> getPrivacy();
}
