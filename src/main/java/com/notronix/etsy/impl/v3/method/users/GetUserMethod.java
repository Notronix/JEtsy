package com.notronix.etsy.impl.v3.method.users;

import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.v3.method.EtsyMethod;
import com.notronix.etsy.impl.v3.model.users.EtsyUser;

import static java.util.Objects.requireNonNull;

public class GetUserMethod extends EtsyMethod<EtsyUser>
{
    private Long userId;

    public GetUserMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public EtsyUser getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, EtsyUser.class);
    }

    @Override
    protected String getURI() {
        return "/application/users/" + requireNonNull(userId);
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public GetUserMethod withUserId(Long userId) {
        this.userId = userId;
        return this;
    }
}
