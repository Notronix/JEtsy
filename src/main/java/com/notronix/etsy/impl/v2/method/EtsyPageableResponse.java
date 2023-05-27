package com.notronix.etsy.impl.v2.method;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.v2.method.PageableResponse;
import com.notronix.etsy.impl.v2.model.carts.EtsyCart;
import com.notronix.etsy.impl.v2.model.listings.EtsyListing;
import com.notronix.etsy.impl.v2.model.shops.EtsyReceipt;
import com.notronix.etsy.impl.v2.model.shops.EtsyShop;
import com.notronix.etsy.impl.v2.model.users.EtsyUser;

import java.lang.reflect.Type;
import java.util.List;

public class EtsyPageableResponse<T> extends EtsyResponse<List<T>> implements PageableResponse<T>
{
    public static Type CARTS = new TypeToken<EtsyPageableResponse<EtsyCart>>(){}.getType();
    public static Type SHOPS = new TypeToken<EtsyPageableResponse<EtsyShop>>(){}.getType();
    public static Type LISTINGS = new TypeToken<EtsyPageableResponse<EtsyListing>>(){}.getType();
    public static Type RECEIPTS = new TypeToken<EtsyPageableResponse<EtsyReceipt>>(){}.getType();
    public static Type USERS = new TypeToken<EtsyPageableResponse<EtsyUser>>(){}.getType();
}
