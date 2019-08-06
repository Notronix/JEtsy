package com.notronix.etsy.impl.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.model.CartAssociations;
import com.notronix.etsy.impl.model.EtsyCart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.notronix.etsy.impl.method.MethodUtils.*;
import static java.util.Objects.requireNonNull;

public class CreateSingleListingCartMethod extends AbstractEtsyMethod<EtsyCart>
{
    private String userId;
    private Long listingId;
    private Integer quantity;
    private CartAssociations[] associations;

    @Override
    public String getRequestMethod() {
        return HttpMethods.POST;
    }

    @Override
    String getURI() {
        String uri = "/users/" + requireNonNull(userId) + "/carts/single_listing";
        uri = addIfProvided(uri, "includes", safeList(associations), ASSOCIATIONS_CONVERTER);

        return uri;
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public HttpContent getContent(Gson gson) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("listing_id", requireNonNull(listingId));
        putIfProvided(parameters, "quantity", quantity);

        return new UrlEncodedContent(parameters);
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

    public CreateSingleListingCartMethod withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public CreateSingleListingCartMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CreateSingleListingCartMethod withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public CartAssociations[] getAssociations() {
        return associations;
    }

    public void setAssociations(CartAssociations[] associations) {
        this.associations = associations;
    }

    public CreateSingleListingCartMethod withAssociations(CartAssociations[] associations) {
        this.associations = associations;
        return this;
    }
}
