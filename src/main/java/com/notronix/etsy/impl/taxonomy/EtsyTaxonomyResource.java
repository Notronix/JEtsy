package com.notronix.etsy.impl.taxonomy;

import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.taxonomy.TaxonomyResource;
import com.notronix.etsy.impl.EtsyResource;
import com.notronix.etsy.impl.EtsyMethodExecutor;
import com.notronix.etsy.impl.taxonomy.method.GetSellerTaxonomyNodesMethod;
import com.notronix.etsy.impl.taxonomy.method.GetTaxonomyNodePropertiesMethod;
import com.notronix.etsy.impl.taxonomy.model.EtsyTaxonomy;
import com.notronix.etsy.impl.taxonomy.model.EtsyTaxonomyNodeProperty;

public class EtsyTaxonomyResource extends EtsyResource implements TaxonomyResource
{
    public EtsyTaxonomyResource(EtsyMethodExecutor executor, Credentials clientCredentials) {
        super(executor, clientCredentials);
    }

    @Override
    public PageableResponse<EtsyTaxonomy> getSellerTaxonomyNodes() throws EtsyException {
        return getExecutor().execute(new GetSellerTaxonomyNodesMethod(getClientCredentials()));
    }

    @Override
    public PageableResponse<EtsyTaxonomyNodeProperty> getTaxonomyNodeProperties(Long taxonomyId) throws EtsyException {
        return getExecutor().execute(new GetTaxonomyNodePropertiesMethod(getClientCredentials())
                .withTaxonomyId(taxonomyId));
    }

}
