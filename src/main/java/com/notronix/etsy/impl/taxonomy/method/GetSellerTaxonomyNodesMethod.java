package com.notronix.etsy.impl.taxonomy.method;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.impl.EtsyPageableResponse;
import com.notronix.etsy.impl.PageableEtsyMethod;
import com.notronix.etsy.impl.taxonomy.model.EtsyTaxonomy;

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
