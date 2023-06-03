package com.notronix.etsy.api.listings.model;

public enum WhenMade
{
    made_to_order,
    _2020_2023("2020_2023"),
    _2010_2019("2010_2019"),
    _2004_2009("2004_2009"),
    before_2004,
    _2000_2003("2000_2003"),
    _1990s("1990s"),
    _1980s("1980s"),
    _1970s("1970s"),
    _1960s("1960s"),
    _1950s("1950s"),
    _1940s("1940s"),
    _1930s("1930s"),
    _1920s("1920s"),
    _1910s("1910s"),
    _1900s("1900s"),
    _1800s("1800s"),
    _1700s("1700s"),
    before_1700;

    private final String apiValue;

    WhenMade() {
        apiValue = this.name();
    }

    WhenMade(String apiValue) {
        this.apiValue = apiValue;
    }

    public String apiValue() {
        return apiValue;
    }

    public static WhenMade forValue(String value) {
        try {
            return WhenMade.valueOf(value);
        }
        catch (Exception ex) {
            return WhenMade.valueOf("_" + value);
        }
    }


    @Override
    public String toString() {
        return apiValue;
    }
}
