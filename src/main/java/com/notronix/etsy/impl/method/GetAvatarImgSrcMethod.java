package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.authentication.Credentials;

import java.util.Map;

import static com.notronix.etsy.api.EtsyAPI.__SELF__;
import static java.util.Objects.requireNonNull;

public class GetAvatarImgSrcMethod extends AbstractEtsyMethod<String>
{
    private String userId;

    public GetAvatarImgSrcMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public boolean requiresOAuth() {
        return __SELF__.equals(userId);
    }

    @Override
    public String getURI() {
        return "/users/" + requireNonNull(userId) + "/avatar/src";
    }

    @Override
    public String getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<Map<String, String>> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<Map<String, String>>>(){}.getType());

        return response.getResults().get("src");
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public GetAvatarImgSrcMethod withUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
