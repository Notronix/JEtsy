package com.notronix.etsy.impl.v2.method.types;

import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.types.EtsyDataType;

import java.util.List;

import static com.notronix.etsy.impl.v2.method.EtsyResponse.DATA_TYPES;

public class DescribeOccasionEnumMethod extends EtsyMethod<EtsyDataType>
{
    public DescribeOccasionEnumMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    public String getURI() {
        return "/types/enum/occasion";
    }

    @Override
    public EtsyDataType getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyResponse<List<EtsyDataType>> response = unmarshaller.unmarshal(payload, DATA_TYPES);

        return response.getResults().stream().findAny().orElse(null);
    }
}
