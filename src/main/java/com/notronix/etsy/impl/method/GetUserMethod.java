package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.model.UserAssociations;
import com.notronix.etsy.impl.model.EtsyUser;

import java.util.List;

import static com.notronix.etsy.api.EtsyAPI.__SELF__;
import static com.notronix.etsy.impl.method.MethodUtils.addIfProvided;
import static com.notronix.etsy.impl.method.MethodUtils.safeList;
import static java.util.Objects.requireNonNull;

public class GetUserMethod extends AbstractEtsyMethod<EtsyUser>
{
    private String userId;
    private UserAssociations[] associations;

    @Override
    public boolean requiresOAuth() {
        return __SELF__.equals(userId);
    }

    @Override
    public String getURI() {
        String uri = "/users/" + requireNonNull(userId);
        uri = addIfProvided(uri, "includes", safeList(associations), ASSOCIATIONS_CONVERTER);

        return uri;
    }

    @Override
    public EtsyUser getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyUser>> response
                = gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyUser>>>(){}.getType());

        return response.getResults().stream().findAny().orElse(null);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public GetUserMethod withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public UserAssociations[] getAssociations() {
        return associations;
    }

    public void setAssociations(UserAssociations[] associations) {
        this.associations = associations;
    }

    public GetUserMethod withAssociations(UserAssociations[] associations) {
        this.associations = associations;
        return this;
    }
}
