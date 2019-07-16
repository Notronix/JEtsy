package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.impl.model.EtsyListing;

public class FindAllListingActiveMethod extends AbstractEtsyMethod<EtsyResponse<EtsyListing>>
{
    private Integer limit;
    private Integer offset;

    @Override
    public String getURI(String apiKey) {
        String uri = "/listings/active?api_key=" + apiKey;

        if (limit != null) {
            uri += "&limit=" + limit;
        }

        if (offset != null) {
            uri += "&offset=" + offset;
        }

        return uri;
    }

    @Override
    public EtsyResponse<EtsyListing> getResponse(Gson gson, String jsonPayload) {
        return gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<EtsyListing>>(){}.getType());
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public FindAllListingActiveMethod withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public FindAllListingActiveMethod withOffset(Integer offset) {
        this.offset = offset;
        return this;
    }
}
