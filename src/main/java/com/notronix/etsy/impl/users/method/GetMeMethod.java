package com.notronix.etsy.impl.users.method;

import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.EtsyMethod;
import com.notronix.etsy.impl.users.model.EtsyGetMeResponse;

public class GetMeMethod extends EtsyMethod<EtsyGetMeResponse>
{
    public GetMeMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public EtsyGetMeResponse getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, EtsyGetMeResponse.class);
    }

    @Override
    protected String getURI() {
        return "/application/users/me";
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }
}
