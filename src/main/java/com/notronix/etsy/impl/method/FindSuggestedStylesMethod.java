package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.impl.model.EtsyStyle;

import java.util.List;

public class FindSuggestedStylesMethod extends AbstractEtsyMethod<List<EtsyStyle>>
{
    @Override
    String getURI(String apiKey) {
        return "/taxonomy/styles?api_key=" + apiKey;
    }

    @Override
    public List<EtsyStyle> getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyStyle>> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyStyle>>>(){}.getType());

        return response.getResults();
    }
}
