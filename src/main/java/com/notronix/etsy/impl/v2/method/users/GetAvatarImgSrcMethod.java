package com.notronix.etsy.impl.v2.method.users;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;

import java.util.Map;

import static com.notronix.etsy.api.v2.EtsyAPI.__SELF__;
import static java.util.Objects.requireNonNull;

public class GetAvatarImgSrcMethod extends EtsyMethod<String>
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
    public String getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyResponse<Map<String, String>> response =
                unmarshaller.unmarshal(payload, new TypeToken<EtsyResponse<Map<String, String>>>(){}.getType());

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
