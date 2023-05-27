package com.notronix.etsy.impl.v2.method.taxonomy;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.taxonomy.EtsyTaxonomy;

import java.util.List;

public class GetSellerTaxonomyMethod extends EtsyMethod<List<EtsyTaxonomy>>
{
    public GetSellerTaxonomyMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    public String getURI() {
        return "/taxonomy/seller/get";
    }

    @Override
    public List<EtsyTaxonomy> getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyResponse<List<EtsyTaxonomy>> response =
                unmarshaller.unmarshal(payload, new TypeToken<EtsyResponse<List<EtsyTaxonomy>>>(){}.getType());

        return response.getResults();
    }
}
