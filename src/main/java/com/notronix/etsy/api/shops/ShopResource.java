package com.notronix.etsy.api.shops;

import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.shops.model.ShippingProfile;
import com.notronix.etsy.api.shops.model.Shop;
import com.notronix.etsy.api.shops.model.ShopSection;

public interface ShopResource
{
    Shop getShop(Long shopId) throws EtsyException;

    PageableResponse<? extends ShippingProfile> getShopShippingProfiles(Credentials accessCredentials, Long shopId)
            throws EtsyException;

    PageableResponse<? extends ShopSection> getShopSections(Long shopId) throws EtsyException;
}
