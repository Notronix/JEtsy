package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.impl.model.EtsyShippingTemplate;

import java.util.List;

public class GetShippingTemplatesMethod extends AbstractEtsyMethod<EtsyResponse<List<EtsyShippingTemplate>>>
{
    @Override
    public String getURI(String apiKey) {
        return "/users/__SELF__/shipping/templates";
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public EtsyResponse<List<EtsyShippingTemplate>> getResponse(Gson gson, String jsonPayload) {
        return gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyShippingTemplate>>>(){}.getType());
    }
}
