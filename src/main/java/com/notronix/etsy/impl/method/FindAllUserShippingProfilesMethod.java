package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.impl.model.EtsyShippingTemplate;

import java.util.List;

public class FindAllUserShippingProfilesMethod extends AbstractEtsyMethod<EtsyResponse<List<EtsyShippingTemplate>>>
{
    private String userId;
    private Integer limit;
    private Integer offset;

    @Override
    public String getURI() {
        return "/users/" + userId + "/shipping/templates";
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public EtsyResponse<List<EtsyShippingTemplate>> getResponse(Gson gson, String jsonPayload) {
        return gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyShippingTemplate>>>(){}.getType());
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public FindAllUserShippingProfilesMethod withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public FindAllUserShippingProfilesMethod withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public FindAllUserShippingProfilesMethod withOffset(Integer offset) {
        this.offset = offset;
        return this;
    }
}
