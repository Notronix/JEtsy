package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.impl.model.EtsyTaxonomy;

import java.util.List;

public class GetSellerTaxonomyMethod extends AbstractEtsyMethod<List<EtsyTaxonomy>>
{
    @Override
    public String getURI(String apiKey) {
        return "/taxonomy/seller/get?api_key=" + apiKey;
    }

    @Override
    public List<EtsyTaxonomy> getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyTaxonomy>> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyTaxonomy>>>(){}.getType());

        return response.getResults();
    }
}
