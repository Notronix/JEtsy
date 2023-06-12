package com.notronix.etsy.impl.taxonomy.method;

import com.google.api.client.http.HttpContent;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.taxonomy.method.GetSellerTaxonomyNodesMethod;
import com.notronix.etsy.api.taxonomy.model.Taxonomy;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.EtsyPageableResponse;
import com.notronix.etsy.impl.taxonomy.model.EtsyTaxonomy;

public class EtsyGetSellerTaxonomyNodesMethod extends AbstractEtsyMethod<PageableResponse<Taxonomy>>
    implements GetSellerTaxonomyNodesMethod<HttpContent>
{
    @Override
    public PageableResponse<Taxonomy> buildResponseBody(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, new TypeToken<EtsyPageableResponse<EtsyTaxonomy>>(){}.getType());
    }

    @Override
    protected String getURI() {
        return "/application/seller-taxonomy/nodes";
    }
}
