package com.notronix.etsy.impl.shops.method;

import com.google.api.client.http.HttpContent;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.shops.method.GetShopSectionsMethod;
import com.notronix.etsy.api.shops.model.ShopSection;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.EtsyPageableResponse;
import com.notronix.etsy.impl.shops.model.EtsyShopSection;

import static java.util.Objects.requireNonNull;

public class EtsyGetShopSectionsMethod extends AbstractEtsyMethod<PageableResponse<ShopSection>>
    implements GetShopSectionsMethod<HttpContent>
{
    private Long shopId;

    @Override
    public PageableResponse<ShopSection> buildResponseBody(Unmarshaller unmarshaller, String payload) {
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

    @Override
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public EtsyGetShopSectionsMethod withShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }
}
