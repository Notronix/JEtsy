package com.notronix.etsy.impl.v2.method.users;

import com.google.gson.Gson;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.v2.model.users.UserAssociations;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyPageableResponse;
import com.notronix.etsy.impl.v2.model.users.EtsyUser;

import static com.notronix.etsy.impl.EtsyMethodUtils.addIfProvided;
import static com.notronix.etsy.impl.v2.method.EtsyPageableResponse.USERS;

public class FindAllUsersMethod extends EtsyMethod<EtsyPageableResponse<EtsyUser>>
{
    private String keywords;
    private Integer limit;
    private Integer offset;
    private UserAssociations[] associations;

    public FindAllUsersMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    public EtsyPageableResponse<EtsyUser> getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, USERS);
    }

    @Override
    protected String getURI() {
        //TODO: should use a StringBuilder
        String uri = "/users";
        uri = addIfProvided(uri, "keywords", keywords);
        uri = addIfProvided(uri, "limit", limit);
        uri = addIfProvided(uri, "offset", offset);
        uri = addAssociations(uri, associations);

        return uri;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public FindAllUsersMethod withKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public FindAllUsersMethod withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public FindAllUsersMethod withOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public UserAssociations[] getAssociations() {
        return associations;
    }

    public void setAssociations(UserAssociations[] associations) {
        this.associations = associations;
    }

    public FindAllUsersMethod withAssociations(UserAssociations[] associations) {
        this.associations = associations;
        return this;
    }
}
