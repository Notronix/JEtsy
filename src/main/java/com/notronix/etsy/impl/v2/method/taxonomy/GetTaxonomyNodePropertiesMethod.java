package com.notronix.etsy.impl.v2.method.taxonomy;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.taxonomy.EtsyTaxonomyNodeProperty;

import java.util.List;

public class GetTaxonomyNodePropertiesMethod extends EtsyMethod<List<EtsyTaxonomyNodeProperty>>
{
    private Long taxonomyId;

    public GetTaxonomyNodePropertiesMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    protected String getURI() {
        return "/taxonomy/seller/" + taxonomyId + "/properties";
    }

    @Override
    public List<EtsyTaxonomyNodeProperty> getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyResponse<List<EtsyTaxonomyNodeProperty>> response =
                unmarshaller.unmarshal(payload, new TypeToken<EtsyResponse<List<EtsyTaxonomyNodeProperty>>>(){}.getType());

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
