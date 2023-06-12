package com.notronix.etsy.impl.authentication.method;

import com.google.api.client.http.HttpContent;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.method.PingMethod;
import com.notronix.etsy.impl.AbstractEtsyMethod;

import java.util.HashMap;
import java.util.Map;

public class EtsyPingMethod extends AbstractEtsyMethod<Long> implements PingMethod<HttpContent>
{
    @Override
    public Long buildResponseBody(Unmarshaller unmarshaller, String payload) {
        Map<String, Long> result = unmarshaller.unmarshal(payload,
                new TypeToken<HashMap<String, Long>>(){}.getType());

        return result.get("application_id");
    }

    @Override
    protected String getURI() {
        return "/application/openapi-ping";
    }
}
