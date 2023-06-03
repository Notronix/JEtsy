package com.notronix.etsy.api.taxonomy;

import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.taxonomy.model.Taxonomy;
import com.notronix.etsy.api.taxonomy.model.TaxonomyNodeProperty;

public interface TaxonomyResource
{
    PageableResponse<? extends Taxonomy> getSellerTaxonomyNodes() throws EtsyException;

    PageableResponse<? extends TaxonomyNodeProperty> getTaxonomyNodeProperties(Long taxonomyId) throws EtsyException;
}
