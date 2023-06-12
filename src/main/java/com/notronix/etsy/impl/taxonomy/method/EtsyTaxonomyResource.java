package com.notronix.etsy.impl.taxonomy.method;

import com.google.api.client.http.HttpContent;
import com.notronix.etsy.api.taxonomy.method.GetSellerTaxonomyNodesMethod;
import com.notronix.etsy.api.taxonomy.method.GetTaxonomyNodePropertiesMethod;
import com.notronix.etsy.api.taxonomy.method.TaxonomyResource;

public class EtsyTaxonomyResource implements TaxonomyResource<HttpContent>
{
    @Override
    public GetSellerTaxonomyNodesMethod<HttpContent> createGetSellerTaxonomyNodesMethod() {
        return new EtsyGetSellerTaxonomyNodesMethod();
    }

    @Override
    public GetTaxonomyNodePropertiesMethod<HttpContent> createGetTaxonomyNodePropertiesMethod() {
        return new EtsyGetTaxonomyNodePropertiesMethod();
    }
}
