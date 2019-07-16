package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.model.UserAssociations;
import com.notronix.etsy.impl.model.EtsyUser;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.notronix.albacore.ContainerUtils.thereAreOneOrMore;
import static com.notronix.etsy.api.EtsyAPI.__SELF__;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toSet;
import static org.apache.commons.lang3.StringUtils.join;

public class GetUserMethod extends AbstractEtsyMethod<EtsyUser>
{
    private String userId;
    private UserAssociations[] associations;

    @Override
    public boolean requiresOAuth() {
        return __SELF__.equals(userId);
    }

    @Override
    public String getURI(String apiKey) {
        String uri = "/users/" + requireNonNull(userId);

        if (!__SELF__.equals(userId)) {
            uri += "?api_key=" + apiKey;
        }

        Set<String> includes = Arrays.stream(associations).map(Enum::name).collect(toSet());
        if (thereAreOneOrMore(includes)) {
            uri += (__SELF__.equals(userId) ? "?" : "&") + "includes=" + join(includes, ",");
        }

        return uri;
    }

    @Override
    public EtsyUser getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyUser>> response = gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyUser>>>(){}.getType());

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
