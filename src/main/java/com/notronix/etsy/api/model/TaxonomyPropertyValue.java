package com.notronix.etsy.api.model;

import java.util.List;

public interface TaxonomyPropertyValue
{
    Long getValueId();
    String getName();
    Long getScaleId();
    Integer getOrder();
    List<Long> getEqualTo();
}
