package com.notronix.etsy.api.model;

import java.util.List;

public interface TaxonomyNodeProperty
{
    Long getPropertyId();
    String getName();
    String getDisplayName();
    List<? extends TaxonomyPropertyScale> getScales();
    Boolean getRequired();
    Boolean getSupportsAttributes();
    Boolean getSupportsVariations();
    Boolean getMultiValued();
    List<? extends TaxonomyPropertyValue> getPossibleValues();
    List<? extends TaxonomyPropertyValue> getSelectedValues();
}
