package com.notronix.etsy.impl.v2.method.shops;

import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.v2.model.shops.ShopAssociations;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyPageableResponse;
import com.notronix.etsy.impl.v2.model.shops.EtsyShop;

import static com.notronix.etsy.api.v2.EtsyAPI.__SELF__;
import static com.notronix.etsy.impl.EtsyMethodUtils.addIfProvided;
import static com.notronix.etsy.impl.EtsyMethodUtils.safeList;
import static com.notronix.etsy.impl.v2.method.EtsyPageableResponse.SHOPS;
import static java.util.Objects.requireNonNull;

public class FindAllUserShopsMethod extends EtsyMethod<EtsyPageableResponse<EtsyShop>>
{
    private String userId;
    private Integer limit;
    private Integer offset;
    private ShopAssociations[] associations;

    public FindAllUserShopsMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public boolean requiresOAuth() {
        return __SELF__.equals(requireNonNull(userId));
    }

    @Override
    protected String getURI() {
        String uri = "/users/" + requireNonNull(userId) + "/shops";
        uri = addIfProvided(uri, "limit", limit);
        uri = addIfProvided(uri, "offset", offset);
        uri = addIfProvided(uri, "includes", safeList(associations), ASSOCIATIONS_CONVERTER);

        return uri;
    }

    @Override
    public EtsyPageableResponse<EtsyShop> getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyPageableResponse<EtsyShop> response = unmarshaller.unmarshal(payload, SHOPS);
//        Pagination pagination = response.getPagination();
//
//        if (pagination != null && pagination.hasNext()) {
//            response.setNextBuilder(method -> {
//                if (!(method instanceof FindAllUserShopsMethod)) {
//                    throw new IllegalArgumentException("invalid method");
//                }
//
//                ((FindAllUserShopsMethod) method).withUserId(userId).withLimit(limit).withAssociations(associations)
//                        .withOffset(pagination.getNextOffset());
//            });
//        }

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
