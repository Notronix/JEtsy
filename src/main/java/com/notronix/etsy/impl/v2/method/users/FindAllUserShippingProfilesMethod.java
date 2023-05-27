package com.notronix.etsy.impl.v2.method.users;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.users.EtsyShippingTemplate;

import java.util.List;

import static com.notronix.etsy.impl.EtsyMethodUtils.addIfProvided;

public class FindAllUserShippingProfilesMethod extends EtsyMethod<EtsyResponse<List<EtsyShippingTemplate>>>
{
    private String userId;
    private Integer limit;
    private Integer offset;
    private Integer page;

    public FindAllUserShippingProfilesMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public String getURI() {
        String uri = "/users/" + userId + "/shipping/templates";
        uri = addIfProvided(uri, "limit", limit);
        uri = addIfProvided(uri, "offset", offset);
        uri = addIfProvided(uri, "page", page);

        return uri;
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public EtsyResponse<List<EtsyShippingTemplate>> getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, new TypeToken<EtsyResponse<List<EtsyShippingTemplate>>>(){}.getType());
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

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public FindAllUserShippingProfilesMethod withPage(Integer page) {
        this.page = page;
        return this;
    }
}
