package com.notronix.etsy.impl.v2.method.users;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.v2.model.users.UserAssociations;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.users.EtsyUser;

import java.util.List;

import static com.notronix.etsy.api.v2.EtsyAPI.__SELF__;
import static com.notronix.etsy.impl.EtsyMethodUtils.addIfProvided;
import static com.notronix.etsy.impl.EtsyMethodUtils.safeList;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.joining;

public class GetUserMethod extends EtsyMethod<List<EtsyUser>>
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
    public List<EtsyUser> getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyResponse<List<EtsyUser>> response
                = unmarshaller.unmarshal(payload, new TypeToken<EtsyResponse<List<EtsyUser>>>(){}.getType());

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
