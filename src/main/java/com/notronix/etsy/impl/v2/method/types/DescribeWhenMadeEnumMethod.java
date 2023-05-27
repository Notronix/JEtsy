package com.notronix.etsy.impl.v2.method.types;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.types.EtsyDataType;

import java.util.List;

import static com.notronix.etsy.impl.EtsyMethodUtils.addIfProvided;

public class DescribeWhenMadeEnumMethod extends EtsyMethod<EtsyDataType>
{
    private Boolean includeFormatted;

    public DescribeWhenMadeEnumMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    public String getURI() {
        String uri =  "/types/enum/when_made";
        uri = addIfProvided(uri, "include_formatted", includeFormatted);

        return uri;
    }

    @Override
    public EtsyDataType getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyResponse<List<EtsyDataType>> response =
                unmarshaller.unmarshal(payload, new TypeToken<EtsyResponse<List<EtsyDataType>>>(){}.getType());

        return response.getResults().stream().findAny().orElse(null);
    }

    public Boolean getIncludeFormatted() {
        return includeFormatted;
    }

    public void setIncludeFormatted(Boolean includeFormatted) {
        this.includeFormatted = includeFormatted;
    }

    public DescribeWhenMadeEnumMethod withIncludeFormatted(Boolean includeFormatted) {
        this.includeFormatted = includeFormatted;
        return this;
    }
}
