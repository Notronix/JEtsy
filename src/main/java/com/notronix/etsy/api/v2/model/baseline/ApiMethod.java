package com.notronix.etsy.api.v2.model.baseline;

import java.util.Map;

public interface ApiMethod
{
    String getName();
    String getUri();
    Map<String, String> getParams();
    Map<String, String> getDefaults();
    String getType();
    String getVisibility();
    String getHttpMethod();
}
