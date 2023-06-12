package com.notronix.etsy.api.taxonomy.method;

import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.common.method.EtsyParameter;
import com.notronix.etsy.api.common.method.Method;
import com.notronix.etsy.api.common.method.ParameterPosition;
import com.notronix.etsy.api.taxonomy.model.TaxonomyNodeProperty;

public interface GetTaxonomyNodePropertiesMethod<C> extends Method<PageableResponse<TaxonomyNodeProperty>, C>
{
    @EtsyParameter(nullable = false, position = ParameterPosition.PATH)
    void setTaxonomyId(Long taxonomyId);
}
