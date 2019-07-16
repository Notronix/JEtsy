package com.notronix.etsy.impl.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.model.ListingInventory;
import com.notronix.etsy.api.model.ListingProduct;
import com.notronix.etsy.impl.model.EtsyListingInventory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.notronix.albacore.ContainerUtils.thereAreOneOrMore;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.join;

public class UpdateInventoryMethod extends AbstractEtsyMethod<EtsyListingInventory>
{
    private Long listingId;
    private ListingInventory inventory;

    @Override
    String getURI(String apiKey) {
        return "/listings/" + listingId + "/inventory";
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.PUT;
    }

    @Override
    public HttpContent getContent(Gson gson) {
        Map<String, Object> params = new HashMap<>();
        requireNonNull(inventory);
        List<? extends ListingProduct> products = inventory.getProducts();
        requireNonNull(products);

        String productsParam = gson.toJson(products);
//        productsParam = "[{\"product_id\":null,\"property_values\":[],"
//                + "\"offerings\":[{\"offering_id\":null,\"price\":\"5.00\",\"quantity\":1}]}]";
        params.put("products", productsParam);

        List<Long> priceControllers = inventory.getPriceControllingProperties();
        if (thereAreOneOrMore(priceControllers)) {
            String param = join(priceControllers, ",");
            params.put("price_on_property", param);
        }

        List<Long> quantityControllers = inventory.getQuantityControllingProperties();
        if (thereAreOneOrMore(quantityControllers)) {
            String param = join(quantityControllers, ",");
            params.put("quantity_on_property", param);
        }

        List<Long> skuControllers = inventory.getSkuControllingProperties();
        if (thereAreOneOrMore(skuControllers)) {
            String param = join(skuControllers, ",");
            params.put("sku_on_property", param);
        }

        return new UrlEncodedContent(params);
    }

    @Override
    public EtsyListingInventory getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<EtsyListingInventory> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<EtsyListingInventory>>(){}.getType());

        return response.getResults();
    }

    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public UpdateInventoryMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }

    public ListingInventory getInventory() {
        return inventory;
    }

    public void setInventory(ListingInventory inventory) {
        this.inventory = inventory;
    }

    public UpdateInventoryMethod withInventory(ListingInventory inventory) {
        this.inventory = inventory;
        return this;
    }
}
