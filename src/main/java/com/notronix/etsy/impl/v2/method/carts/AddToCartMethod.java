package com.notronix.etsy.impl.v2.method.carts;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.carts.EtsyCart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.notronix.etsy.impl.EtsyMethodUtils.putIfProvided;
import static java.util.Objects.requireNonNull;

public class AddToCartMethod extends EtsyMethod<EtsyCart>
{
    private String userId;
    private Long listingId;
    private Integer quantity;

    public AddToCartMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    protected String getURI() {
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
    public HttpContent getContent(Marshaller marshaller) {
        Map<String, Object> params = new HashMap<>();
        params.put("listing_id", requireNonNull(listingId));
        putIfProvided(params, "quantity", quantity);

        return new UrlEncodedContent(params);
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
