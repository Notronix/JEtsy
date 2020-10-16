package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.authentication.Credentials;
import com.notronix.etsy.api.method.Pagination;
import com.notronix.etsy.api.model.CartAssociations;
import com.notronix.etsy.impl.model.EtsyCart;

import java.util.List;

import static com.notronix.etsy.impl.method.MethodUtils.addIfProvided;
import static com.notronix.etsy.impl.method.MethodUtils.safeList;
import static java.util.Objects.requireNonNull;

public class GetAllUserCartsMethod extends AbstractEtsyMethod<EtsyResponse<List<EtsyCart>>>
{
    private String userId;
    private Integer limit;
    private Integer offset;
    private CartAssociations[] associations;

    public GetAllUserCartsMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    String getURI() {
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
    public EtsyResponse<List<EtsyCart>> getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyCart>> response
                = gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyCart>>>()
        {
        }.getType());
        Pagination pagination = response.getPagination();

        if (pagination != null && pagination.hasNextPage()) {
            response.setNextBuilder(method -> {
                if (!(method instanceof GetAllUserCartsMethod)) {
                    throw new IllegalArgumentException("invalid method");
                }

                ((GetAllUserCartsMethod) method)
                        .withUserId(userId)
                        .withAssociations(associations)
                        .withLimit(limit)
                        .withOffset(pagination.getNextOffset());
            });
        }

        return response;
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
