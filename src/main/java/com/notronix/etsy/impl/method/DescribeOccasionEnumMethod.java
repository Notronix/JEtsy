package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.impl.model.EtsyDataType;

import java.util.List;

public class DescribeOccasionEnumMethod extends AbstractEtsyMethod<EtsyDataType>
{
    @Override
    public String getURI(String apiKey) {
        return "/types/enum/occasion?api_key=" + apiKey;
    }

    @Override
    public EtsyDataType getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyDataType>> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyDataType>>>(){}.getType());

        return response.getResults().stream().findAny().orElse(null);
    }
}
