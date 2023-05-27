package com.notronix.etsy.api.v2.model.listings;

import java.util.List;

public interface ListingInventory
{
    List<? extends ListingProduct> getProducts();
    List<Long> getPriceControllingProperties();
    List<Long> getQuantityControllingProperties();
    List<Long> getSkuControllingProperties();
}
