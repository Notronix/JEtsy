package com.notronix.etsy.impl.users.method;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.impl.EtsyPageableResponse;
import com.notronix.etsy.impl.PageableEtsyMethod;
import com.notronix.etsy.impl.users.model.EtsyUserAddress;

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
