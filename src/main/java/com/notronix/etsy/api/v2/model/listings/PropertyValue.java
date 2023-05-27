package com.notronix.etsy.api.v2.model.listings;

import java.util.List;

public interface PropertyValue
{
    Long getPropertyId();
    String getPropertyName();
    Long getScaleId();
    String getScaleName();
    List<Long> getValueIds();
    List<String> getValues();
}
