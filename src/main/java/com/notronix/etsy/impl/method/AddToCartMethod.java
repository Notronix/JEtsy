package com.notronix.etsy.impl.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.impl.model.EtsyCart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.notronix.etsy.impl.method.MethodUtils.putIfProvided;
import static java.util.Objects.requireNonNull;

public class AddToCartMethod extends AbstractEtsyMethod<EtsyCart>
{
    private String userId;
    private Long listingId;
    private Integer quantity;

    @Override
    String getURI() {
        return "/users/" + requireNonNull(userId) + "/carts";
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.POST;
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public HttpContent getContent(Gson gson) {
        Map<String, Object> params = new HashMap<>();
        params.put("listing_id", requireNonNull(listingId));
        putIfProvided(params, "quantity", quantity);

        return new UrlEncodedContent(params);
    }

    @Override
    public EtsyCart getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyCart>> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyCart>>>(){}.getType());

        return response.getResults().stream().findAny().orElse(null);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public AddToCartMethod withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public AddToCartMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public AddToCartMethod withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
