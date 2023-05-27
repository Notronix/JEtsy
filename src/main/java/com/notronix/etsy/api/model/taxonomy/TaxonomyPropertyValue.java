package com.notronix.etsy.api.model.taxonomy;

import java.util.List;

public interface TaxonomyPropertyValue
{
    Long getValueId();
    String getName();
    Long getScaleId();
    List<Long> getEqualTo();
}
