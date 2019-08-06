package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.method.Pagination;
import com.notronix.etsy.api.model.ShopAssociations;
import com.notronix.etsy.impl.model.EtsyShop;

import java.util.List;

import static com.notronix.etsy.api.EtsyAPI.__SELF__;
import static com.notronix.etsy.impl.method.MethodUtils.addIfProvided;
import static com.notronix.etsy.impl.method.MethodUtils.safeList;
import static java.util.Objects.requireNonNull;

public class FindAllUserShopsMethod extends AbstractEtsyMethod<EtsyResponse<List<EtsyShop>>>
{
    private String userId;
    private Integer limit;
    private Integer offset;
    private ShopAssociations[] associations;

    @Override
    public boolean requiresOAuth() {
        return __SELF__.equals(requireNonNull(userId));
    }

    @Override
    String getURI() {
        String uri = "/users/" + requireNonNull(userId) + "/shops";
        uri = addIfProvided(uri, "limit", limit);
        uri = addIfProvided(uri, "offset", offset);
        uri = addIfProvided(uri, "includes", safeList(associations), ASSOCIATIONS_CONVERTER);

        return uri;
    }

    @Override
    public EtsyResponse<List<EtsyShop>> getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyShop>> response
                = gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyShop>>>(){}.getType());
        Pagination pagination = response.getPagination();

        if (pagination != null && pagination.hasNextPage()) {
            response.setNextBuilder(method -> {
                if (!(method instanceof FindAllUserShopsMethod)) {
                    throw new IllegalArgumentException("invalid method");
                }

                ((FindAllUserShopsMethod) method).withUserId(userId).withLimit(limit).withAssociations(associations)
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

    public FindAllUserShopsMethod withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public FindAllUserShopsMethod withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public FindAllUserShopsMethod withOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public ShopAssociations[] getAssociations() {
        return associations;
    }

    public void setAssociations(ShopAssociations[] associations) {
        this.associations = associations;
    }

    public FindAllUserShopsMethod withAssociations(ShopAssociations[] associations) {
        this.associations = associations;
        return this;
    }
}
