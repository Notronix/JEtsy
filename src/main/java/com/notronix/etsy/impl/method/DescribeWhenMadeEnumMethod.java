package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.authentication.Credentials;
import com.notronix.etsy.impl.model.EtsyDataType;

import java.util.List;

import static com.notronix.etsy.impl.method.MethodUtils.addIfProvided;

public class DescribeWhenMadeEnumMethod extends AbstractEtsyMethod<EtsyDataType>
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
    public EtsyDataType getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyDataType>> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyDataType>>>(){}.getType());

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
