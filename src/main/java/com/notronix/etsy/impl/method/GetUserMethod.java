package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.authentication.Credentials;
import com.notronix.etsy.api.model.UserAssociations;
import com.notronix.etsy.impl.model.EtsyUser;

import java.util.List;

import static com.notronix.etsy.api.EtsyAPI.__SELF__;
import static com.notronix.etsy.impl.method.MethodUtils.addIfProvided;
import static com.notronix.etsy.impl.method.MethodUtils.safeList;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.joining;

public class GetUserMethod extends AbstractEtsyMethod<List<EtsyUser>>
{
    private List<String> userIdsOrNames;
    private UserAssociations[] associations;

    public GetUserMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public boolean requiresOAuth() {
        return requireNonNull(userIdsOrNames).stream().anyMatch(__SELF__::equals);
    }

    @Override
    public String getURI() {
        String uri = "/users/" + requireNonNull(userIdsOrNames).stream().distinct().collect(joining(","));
        uri = addIfProvided(uri, "includes", safeList(associations), ASSOCIATIONS_CONVERTER);

        return uri;
    }

    @Override
    public List<EtsyUser> getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyUser>> response
                = gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyUser>>>(){}.getType());

        return response.getResults();
    }

    public List<String> getUserIdsOrNames() {
        return userIdsOrNames;
    }

    public void setUserIdsOrNames(List<String> userIdsOrNames) {
        this.userIdsOrNames = userIdsOrNames;
    }

    public GetUserMethod withUserIdsOrNames(List<String> userIdsOrNames) {
        this.userIdsOrNames = userIdsOrNames;
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
