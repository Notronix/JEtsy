package com.notronix.etsy.impl.v2.method.carts;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.v2.model.carts.CartAssociations;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.carts.EtsyCart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.notronix.etsy.impl.EtsyMethodUtils.*;
import static java.util.Objects.requireNonNull;

public class CreateSingleListingCartMethod extends EtsyMethod<EtsyCart>
{
    private String userId;
    private Long listingId;
    private Integer quantity;
    private CartAssociations[] associations;

    public CreateSingleListingCartMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.POST;
    }

    @Override
    protected String getURI() {
        String uri = "/users/" + requireNonNull(userId) + "/carts/single_listing";
        uri = addIfProvided(uri, "includes", safeList(associations), ASSOCIATIONS_CONVERTER);

        return uri;
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public HttpContent getContent(Marshaller marshaller) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("listing_id", requireNonNull(listingId));
        putIfProvided(parameters, "quantity", quantity);

        return new UrlEncodedContent(parameters);
    }

    @Override
    public EtsyCart getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyResponse<List<EtsyCart>> response =
                unmarshaller.unmarshal(payload, new TypeToken<EtsyResponse<List<EtsyCart>>>(){}.getType());

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
