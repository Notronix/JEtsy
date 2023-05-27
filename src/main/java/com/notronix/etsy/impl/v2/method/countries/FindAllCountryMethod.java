package com.notronix.etsy.impl.v2.method.countries;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.countries.EtsyCountry;

import java.util.List;

public class FindAllCountryMethod extends EtsyMethod<List<EtsyCountry>>
{
    public FindAllCountryMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    protected String getURI() {
        return "/countries";
    }

    @Override
    public List<EtsyCountry> getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyResponse<List<EtsyCountry>> response =
                unmarshaller.unmarshal(payload, new TypeToken<EtsyResponse<List<EtsyCountry>>>(){}.getType());

        return response.getResults();
    }
}
