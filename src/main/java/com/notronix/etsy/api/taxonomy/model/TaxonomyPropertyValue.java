package com.notronix.etsy.api.taxonomy.model;

import java.util.List;

public interface TaxonomyPropertyValue
{
    Long getValueId();
    String getName();
    Long getScaleId();
    List<Long> getEqualTo();
}
