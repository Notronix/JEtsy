package com.notronix.etsy.impl.model;

import com.notronix.etsy.api.model.DataType;

import java.util.List;

public class EtsyDataType implements DataType
{
    private String type;
    private List<String> values;

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
}
