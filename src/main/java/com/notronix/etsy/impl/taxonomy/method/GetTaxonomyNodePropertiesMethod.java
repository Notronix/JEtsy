package com.notronix.etsy.impl.taxonomy.method;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.impl.EtsyPageableResponse;
import com.notronix.etsy.impl.PageableEtsyMethod;
import com.notronix.etsy.impl.taxonomy.model.EtsyTaxonomyNodeProperty;

import static java.util.Objects.requireNonNull;

public class GetTaxonomyNodePropertiesMethod extends PageableEtsyMethod<EtsyTaxonomyNodeProperty>
{
    private Long taxonomyId;

    public GetTaxonomyNodePropertiesMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    public PageableResponse<EtsyTaxonomyNodeProperty> getResponse(Unmarshaller unmarshaller, String payload) {
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

    public void setTaxonomyId(Long taxonomyId) {
        this.taxonomyId = taxonomyId;
    }

    public GetTaxonomyNodePropertiesMethod withTaxonomyId(Long taxonomyId) {
        this.taxonomyId = taxonomyId;
        return this;
    }
}
