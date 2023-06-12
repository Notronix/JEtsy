package com.notronix.etsy.api.taxonomy.method;

import com.notronix.etsy.api.Resource;

public interface TaxonomyResource<C> extends Resource
{
    GetSellerTaxonomyNodesMethod<C> createGetSellerTaxonomyNodesMethod();

    GetTaxonomyNodePropertiesMethod<C> createGetTaxonomyNodePropertiesMethod();
}
