package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.model.ShopAssociations;
import com.notronix.etsy.impl.model.EtsyShop;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.notronix.albacore.ContainerUtils.thereAreOneOrMore;
import static com.notronix.etsy.api.EtsyAPI.__SELF__;
import static java.util.stream.Collectors.toSet;
import static org.apache.commons.lang3.StringUtils.join;

public class FindAllUserShopsMethod extends AbstractEtsyMethod<EtsyResponse<List<EtsyShop>>>
{
    private String userId;
    private ShopAssociations[] associations;

    @Override
    public boolean requiresOAuth() {
        return __SELF__.equals(userId);
    }

    @Override
    String getURI(String apiKey) {
        String uri = "/users/" + userId + "/shops";

        boolean fullAccess = __SELF__.equals(userId);
        if (!fullAccess) {
            uri += "?api_key=" + apiKey;
        }

        Set<String> includes = Arrays.stream(associations).map(Enum::name).collect(toSet());
        if (thereAreOneOrMore(includes)) {
            uri += (fullAccess ? "?" : "&") + "includes=" + join(includes, ",");
        }

        return uri;
    }

    @Override
    public EtsyResponse<List<EtsyShop>> getResponse(Gson gson, String jsonPayload) {
        return gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyShop>>>(){}.getType());
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public FindAllUserShopsMethod withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public ShopAssociations[] getAssociations() {
        return associations;
    }

    public void setAssociations(ShopAssociations[] associations) {
        this.associations = associations;
    }

    public FindAllUserShopsMethod withAssociations(ShopAssociations[] associations) {
        this.associations = associations;
        return this;
    }
}
