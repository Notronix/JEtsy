package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.authentication.Credentials;
import com.notronix.etsy.impl.model.EtsyStyle;

import java.util.List;

public class FindSuggestedStylesMethod extends AbstractEtsyMethod<List<EtsyStyle>>
{
    public FindSuggestedStylesMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    String getURI() {
        return "/taxonomy/styles";
    }

    @Override
    public List<EtsyStyle> getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyStyle>> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyStyle>>>(){}.getType());

        return response.getResults();
    }
}
