package com.notronix.etsy.impl.v2.method.types;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.types.EtsyDataType;

import java.util.List;

public class DescribeRecipientEnumMethod extends EtsyMethod<EtsyDataType>
{
    public DescribeRecipientEnumMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    public String getURI() {
        return "/types/enum/recipient";
    }

    @Override
    public EtsyDataType getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyResponse<List<EtsyDataType>> response =
                unmarshaller.unmarshal(payload, new TypeToken<EtsyResponse<List<EtsyDataType>>>(){}.getType());

        return response.getResults().stream().findAny().orElse(null);
    }
}
