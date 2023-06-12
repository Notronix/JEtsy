package com.notronix.etsy.impl.taxonomy.method;

import com.google.api.client.http.HttpContent;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.taxonomy.method.GetTaxonomyNodePropertiesMethod;
import com.notronix.etsy.api.taxonomy.model.TaxonomyNodeProperty;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.EtsyPageableResponse;
import com.notronix.etsy.impl.taxonomy.model.EtsyTaxonomyNodeProperty;

import static java.util.Objects.requireNonNull;

public class EtsyGetTaxonomyNodePropertiesMethod extends AbstractEtsyMethod<PageableResponse<TaxonomyNodeProperty>>
    implements GetTaxonomyNodePropertiesMethod<HttpContent>
{
    private Long taxonomyId;

    @Override
    public PageableResponse<TaxonomyNodeProperty> buildResponseBody(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload,
                new TypeToken<EtsyPageableResponse<EtsyTaxonomyNodeProperty>>(){}.getType());
    }

    @Override
    protected String getURI() {
        return "/application/seller-taxonomy/nodes/" + requireNonNull(taxonomyId) + "/properties";
    }

    public Long getTaxonomyId() {
        return taxonomyId;
    }

    @Override
    public void setTaxonomyId(Long taxonomyId) {
        this.taxonomyId = taxonomyId;
    }

    public EtsyGetTaxonomyNodePropertiesMethod withTaxonomyId(Long taxonomyId) {
        this.taxonomyId = taxonomyId;
        return this;
    }
}
