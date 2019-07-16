package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.impl.model.EtsyTaxonomyNodeProperty;

import java.util.List;

public class GetTaxonomyNodePropertiesMethod extends AbstractEtsyMethod<List<EtsyTaxonomyNodeProperty>>
{
    private Long taxonomyId;

    @Override
    String getURI(String apiKey) {
        return "/taxonomy/seller/" + taxonomyId + "/properties?api_key=" + apiKey;
    }

    @Override
    public List<EtsyTaxonomyNodeProperty> getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyTaxonomyNodeProperty>> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyTaxonomyNodeProperty>>>(){}.getType());

        return response.getResults();
    }

    public Long getTaxonomyId() {
        return taxonomyId;
    }

    public void setTaxonomyId(Long taxonomyId) {
        this.taxonomyId = taxonomyId;
    }

    public GetTaxonomyNodePropertiesMethod withTaxonomyId(Long taxonomyId) {
        this.taxonomyId = taxonomyId;
        return this;
    }
}
