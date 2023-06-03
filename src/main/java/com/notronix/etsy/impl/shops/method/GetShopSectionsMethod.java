package com.notronix.etsy.impl.shops.method;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.impl.EtsyPageableResponse;
import com.notronix.etsy.impl.PageableEtsyMethod;
import com.notronix.etsy.impl.shops.model.EtsyShopSection;

import static java.util.Objects.requireNonNull;

public class GetShopSectionsMethod extends PageableEtsyMethod<EtsyShopSection>
{
    private Long shopId;

    public GetShopSectionsMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    public PageableResponse<EtsyShopSection> getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload,
                new TypeToken<EtsyPageableResponse<EtsyShopSection>>(){}.getType());
    }

    @Override
    protected String getURI() {
        return "/application/shops/" + requireNonNull(shopId) + "/sections";
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public GetShopSectionsMethod withShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }
}
