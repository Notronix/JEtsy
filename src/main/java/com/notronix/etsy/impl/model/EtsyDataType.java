package com.notronix.etsy.impl.model;

import com.notronix.etsy.api.model.DataType;

import java.util.List;
import java.util.Map;

public class EtsyDataType implements DataType
{
    private String type;
    private List<String> values;
    private Map<String, String> formatted;

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    @Override
    public Map<String, String> getFormatted() {
        return formatted;
    }

    public void setFormatted(Map<String, String> formatted) {
        this.formatted = formatted;
    }
}
