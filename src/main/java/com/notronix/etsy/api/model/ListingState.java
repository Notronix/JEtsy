package com.notronix.etsy.api.model;

public enum ListingState
{
    active,
    removed,
    sold_out,
    expired,
    edit,
    draft,
    _private("private"),
    unavailable;

    private String apiValue;

    ListingState() {
        apiValue = this.name();
    }

    ListingState(String apiValue) {
        this.apiValue = apiValue;
    }

    public String apiValue() {
        return apiValue;
    }
}
