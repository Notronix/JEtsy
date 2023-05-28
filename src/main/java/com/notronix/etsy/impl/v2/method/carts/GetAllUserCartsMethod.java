package com.notronix.etsy.impl.v2.method.carts;

import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.v2.model.carts.CartAssociations;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyPageableResponse;
import com.notronix.etsy.impl.v2.model.carts.EtsyCart;

import static com.notronix.etsy.impl.EtsyMethodUtils.addIfProvided;
import static com.notronix.etsy.impl.EtsyMethodUtils.safeList;
import static com.notronix.etsy.impl.v2.method.EtsyPageableResponse.CARTS;
import static java.util.Objects.requireNonNull;

public class GetAllUserCartsMethod extends EtsyMethod<EtsyPageableResponse<EtsyCart>>
{
    private String userId;
    private Integer limit;
    private Integer offset;
    private CartAssociations[] associations;

    public GetAllUserCartsMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    protected String getURI() {
        String uri = "/users/" + requireNonNull(userId) + "/carts";
        uri = addIfProvided(uri, "limit", limit);
        uri = addIfProvided(uri, "offset", offset);
        uri = addIfProvided(uri, "includes", safeList(associations), ASSOCIATIONS_CONVERTER);

        return uri;
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public EtsyPageableResponse<EtsyCart> getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, CARTS);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public GetAllUserCartsMethod withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public GetAllUserCartsMethod withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public GetAllUserCartsMethod withOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public CartAssociations[] getAssociations() {
        return associations;
    }

    public void setAssociations(CartAssociations[] associations) {
        this.associations = associations;
    }

    public GetAllUserCartsMethod withAssociations(CartAssociations[] associations) {
        this.associations = associations;
        return this;
    }
}
