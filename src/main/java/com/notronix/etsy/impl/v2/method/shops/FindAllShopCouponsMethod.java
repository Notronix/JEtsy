package com.notronix.etsy.impl.v2.method.shops;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.shops.EtsyCoupon;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Deprecated
public class FindAllShopCouponsMethod extends EtsyMethod<List<EtsyCoupon>>
{
    private String shopIdOrName;

    public FindAllShopCouponsMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    protected String getURI() {
        return "/shops/" + requireNonNull(shopIdOrName) + "/coupons";
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public List<EtsyCoupon> getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyResponse<List<EtsyCoupon>> response =
                unmarshaller.unmarshal(payload, new TypeToken<EtsyResponse<List<EtsyCoupon>>>(){}.getType());

        return response.getResults();
    }

    public String getShopIdOrName() {
        return shopIdOrName;
    }

    public void setShopIdOrName(String shopIdOrName) {
        this.shopIdOrName = shopIdOrName;
    }

    public FindAllShopCouponsMethod withShopIdOrName(String shopIdOrName) {
        this.shopIdOrName = shopIdOrName;
        return this;
    }
}
