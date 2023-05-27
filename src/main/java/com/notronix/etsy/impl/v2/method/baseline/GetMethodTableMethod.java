package com.notronix.etsy.impl.v2.method.baseline;

import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.baseline.EtsyApiMethod;

import java.util.List;

public class GetMethodTableMethod extends EtsyMethod<List<EtsyApiMethod>>
{
    public GetMethodTableMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    protected String getURI() {
        return "/";
    }

    @Override
    public List<EtsyApiMethod> getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyResponse<List<EtsyApiMethod>> response = unmarshaller.unmarshal(payload, EtsyResponse.METHODS);

        return response.getResults();
    }
}
