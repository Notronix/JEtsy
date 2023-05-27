package com.notronix.etsy.impl.v2.model.listings;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.v2.model.listings.ListingInventory;

import java.util.List;

public class EtsyListingInventory implements ListingInventory
{
    private List<EtsyListingProduct> products;

    @SerializedName(value = "price_on_property")
    private List<Long> priceControllingProperties;

    @SerializedName(value = "quantity_on_property")
    private List<Long> quantityControllingProperties;

    @SerializedName(value = "sku_on_property")
    private List<Long> skuControllingProperties;

    @Override
    public List<EtsyListingProduct> getProducts() {
        return products;
    }

    public void setProducts(List<EtsyListingProduct> products) {
        this.products = products;
    }

    @Override
    public List<Long> getPriceControllingProperties() {
        return priceControllingProperties;
    }

    public void setPriceControllingProperties(List<Long> priceControllingProperties) {
        this.priceControllingProperties = priceControllingProperties;
    }

    @Override
    public List<Long> getQuantityControllingProperties() {
        return quantityControllingProperties;
    }

    public void setQuantityControllingProperties(List<Long> quantityControllingProperties) {
        this.quantityControllingProperties = quantityControllingProperties;
    }

    @Override
    public List<Long> getSkuControllingProperties() {
        return skuControllingProperties;
    }

    public void setSkuControllingProperties(List<Long> skuControllingProperties) {
        this.skuControllingProperties = skuControllingProperties;
    }
}
