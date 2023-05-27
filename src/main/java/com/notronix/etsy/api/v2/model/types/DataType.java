package com.notronix.etsy.api.v2.model.types;

import java.util.List;
import java.util.Map;

public interface DataType
{
    String getType();
    List<String> getValues();
    Map<String, String> getFormatted();
}
