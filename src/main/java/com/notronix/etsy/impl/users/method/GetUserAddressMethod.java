package com.notronix.etsy.impl.users.method;

import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.EtsyMethod;
import com.notronix.etsy.impl.users.model.EtsyUserAddress;

import static java.util.Objects.requireNonNull;

public class GetUserAddressMethod extends EtsyMethod<EtsyUserAddress>
{
    private Long userAddressId;

    public GetUserAddressMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public EtsyUserAddress getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, EtsyUserAddress.class);
    }

    @Override
    protected String getURI() {
        return "/application/user/addresses/" + requireNonNull(userAddressId);
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    public Long getUserAddressId() {
        return userAddressId;
    }

    public void setUserAddressId(Long userAddressId) {
        this.userAddressId = userAddressId;
    }

    public GetUserAddressMethod withUserAddressId(Long userAddressId) {
        this.userAddressId = userAddressId;
        return this;
    }
}
