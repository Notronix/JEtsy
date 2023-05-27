package com.notronix.etsy.impl.v3.method.taxonomy;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.v3.PageableResponse;
import com.notronix.etsy.impl.v3.EtsyPageableResponse;
import com.notronix.etsy.impl.v3.method.PageableEtsyMethod;
import com.notronix.etsy.impl.v3.model.taxonomy.EtsyTaxonomy;

public class GetSellerTaxonomyNodesMethod extends PageableEtsyMethod<EtsyTaxonomy>
{
    public GetSellerTaxonomyNodesMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    public PageableResponse<EtsyTaxonomy> getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, new TypeToken<EtsyPageableResponse<EtsyTaxonomy>>(){}.getType());
    }

    @Override
    protected String getURI() {
        return "/application/seller-taxonomy/nodes";
    }
}
