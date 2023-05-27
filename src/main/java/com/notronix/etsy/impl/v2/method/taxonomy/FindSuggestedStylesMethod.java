package com.notronix.etsy.impl.v2.method.taxonomy;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.taxonomy.EtsyStyle;

import java.util.List;

public class FindSuggestedStylesMethod extends EtsyMethod<List<EtsyStyle>>
{
    public FindSuggestedStylesMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    protected String getURI() {
        return "/taxonomy/styles";
    }

    @Override
    public List<EtsyStyle> getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyResponse<List<EtsyStyle>> response =
                unmarshaller.unmarshal(payload, new TypeToken<EtsyResponse<List<EtsyStyle>>>(){}.getType());

        return response.getResults();
    }
}
