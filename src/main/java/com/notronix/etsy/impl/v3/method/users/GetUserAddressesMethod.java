package com.notronix.etsy.impl.v3.method.users;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.v3.PageableResponse;
import com.notronix.etsy.impl.v3.EtsyPageableResponse;
import com.notronix.etsy.impl.v3.method.PageableEtsyMethod;
import com.notronix.etsy.impl.v3.model.users.EtsyUserAddress;

public class GetUserAddressesMethod extends PageableEtsyMethod<EtsyUserAddress>
{
    public GetUserAddressesMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public PageableResponse<EtsyUserAddress> getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload,
                new TypeToken<EtsyPageableResponse<EtsyUserAddress>>(){}.getType());
    }

    @Override
    protected String getURI() {
        return "/application/user/addresses";
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }
}
