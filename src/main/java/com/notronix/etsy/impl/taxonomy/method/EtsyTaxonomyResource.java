package com.notronix.etsy.impl.taxonomy.method;

import com.google.api.client.http.HttpContent;
import com.notronix.etsy.api.taxonomy.method.TaxonomyResource;

public class EtsyTaxonomyResource implements TaxonomyResource<HttpContent>
{
    @Override
    public EtsyGetSellerTaxonomyNodesMethod createGetSellerTaxonomyNodesMethod() {
        return new EtsyGetSellerTaxonomyNodesMethod();
    }

    @Override
    public EtsyGetTaxonomyNodePropertiesMethod createGetTaxonomyNodePropertiesMethod() {
        return new EtsyGetTaxonomyNodePropertiesMethod();
    }
}
