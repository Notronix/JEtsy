package com.notronix.etsy.api.listings.model;

import java.util.List;

public interface PropertyValue
{
    Long getId();
    String getPropertyName();
    Long getScaleId();
    String getScaleName();
    List<Long> getValueIds();
    List<String> getValues();
}
