package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.impl.model.EtsyApiMethod;

import java.util.List;

public class GetMethodTableMethod extends AbstractEtsyMethod<List<EtsyApiMethod>>
{
    @Override
    String getURI() {
        return "/";
    }

    @Override
    public List<EtsyApiMethod> getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyApiMethod>> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyApiMethod>>>(){}.getType());

        return response.getResults();
    }
}
