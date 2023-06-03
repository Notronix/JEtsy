package com.notronix.etsy.impl.shops;

import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.shops.ShopResource;
import com.notronix.etsy.api.shops.model.ShippingProfile;
import com.notronix.etsy.api.shops.model.Shop;
import com.notronix.etsy.api.shops.model.ShopSection;
import com.notronix.etsy.impl.EtsyResource;
import com.notronix.etsy.impl.EtsyMethodExecutor;
import com.notronix.etsy.impl.shops.method.GetShopMethod;
import com.notronix.etsy.impl.shops.method.GetShopSectionsMethod;
import com.notronix.etsy.impl.shops.method.GetShopShippingProfilesMethod;

public class EtsyShopResource extends EtsyResource implements ShopResource
{
    public EtsyShopResource(EtsyMethodExecutor executor, Credentials clientCredentials) {
        super(executor, clientCredentials);
    }

    @Override
    public Shop getShop(Long shopId) throws EtsyException {
        return getExecutor().execute(new GetShopMethod(getClientCredentials()).withShopId(shopId));
    }

    @Override
    public PageableResponse<? extends ShippingProfile> getShopShippingProfiles(Credentials accessCredentials, Long shopId)
            throws EtsyException {
        return getExecutor().execute(new GetShopShippingProfilesMethod(getClientCredentials(), accessCredentials)
                .withShopId(shopId));
    }

    @Override
    public PageableResponse<? extends ShopSection> getShopSections(Long shopId) throws EtsyException {
        return getExecutor().execute(new GetShopSectionsMethod(getClientCredentials()).withShopId(shopId));
    }
}
