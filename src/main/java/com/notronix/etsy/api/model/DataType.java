package com.notronix.etsy.api.model;

import java.util.List;
import java.util.Map;

public interface DataType
{
    String getType();
    List<String> getValues();
    Map<String, String> getFormatted();
}
