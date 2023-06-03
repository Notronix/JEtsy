package com.notronix.etsy.impl.authentication.method;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.EtsyMethod;

import java.util.HashMap;
import java.util.Map;

public class PingMethod extends EtsyMethod<Long>
{
    public PingMethod(Credentials clientCredentials) {
        super(clientCredentials, null);
    }
    @Override
    public Long getResponse(Unmarshaller unmarshaller, String payload) {
        Map<String, Long> result = unmarshaller.unmarshal(payload,
                new TypeToken<HashMap<String, Long>>(){}.getType());

        return result.get("application_id");
    }

    @Override
    protected String getURI() {
        return "/application/openapi-ping";
    }
}
