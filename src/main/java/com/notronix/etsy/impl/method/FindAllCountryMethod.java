package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.authentication.Credentials;
import com.notronix.etsy.impl.model.EtsyCountry;

import java.util.List;

public class FindAllCountryMethod extends AbstractEtsyMethod<List<EtsyCountry>>
{
    public FindAllCountryMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    String getURI() {
        return "/countries";
    }

    @Override
    public List<EtsyCountry> getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyCountry>> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyCountry>>>(){}.getType());

        return response.getResults();
    }
}
