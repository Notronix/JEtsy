package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.authentication.Credentials;
import com.notronix.etsy.api.method.Pagination;
import com.notronix.etsy.api.model.ReceiptAssociations;
import com.notronix.etsy.impl.model.EtsyReceipt;

import java.util.List;

import static com.notronix.etsy.impl.method.MethodUtils.addIfProvided;
import static com.notronix.etsy.impl.method.MethodUtils.safeList;
import static java.util.Objects.requireNonNull;

public class FindAllShopReceiptsMethod extends AbstractEtsyMethod<EtsyResponse<List<EtsyReceipt>>>
{
    private String shopIdOrName;
    private Integer limit;
    private Integer offset;
    private ReceiptAssociations[] associations;

    public FindAllShopReceiptsMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    String getURI() {
        String uri = "/shops/" + requireNonNull(shopIdOrName) + "/receipts";
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
    public EtsyResponse<List<EtsyReceipt>> getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyReceipt>> response
                = gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyReceipt>>>()
        {
        }.getType());
        Pagination pagination = response.getPagination();

        if (pagination != null && pagination.hasNextPage()) {
            response.setNextBuilder(method -> {
                if (!(method instanceof FindAllShopReceiptsMethod)) {
                    throw new IllegalArgumentException("invalid method");
                }

                ((FindAllShopReceiptsMethod) method)
                        .withShopIdOrName(shopIdOrName)
                        .withAssociations(associations)
                        .withLimit(limit)
                        .withOffset(pagination.getNextOffset());
            });
        }

        return response;
    }

    public String getShopIdOrName() {
        return shopIdOrName;
    }

    public void setShopIdOrName(String shopIdOrName) {
        this.shopIdOrName = shopIdOrName;
    }

    public FindAllShopReceiptsMethod withShopIdOrName(String shopIdOrName) {
        this.shopIdOrName = shopIdOrName;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public FindAllShopReceiptsMethod withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public FindAllShopReceiptsMethod withOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public ReceiptAssociations[] getAssociations() {
        return associations;
    }

    public void setAssociations(ReceiptAssociations[] associations) {
        this.associations = associations;
    }

    public FindAllShopReceiptsMethod withAssociations(ReceiptAssociations[] associations) {
        this.associations = associations;
        return this;
    }
}
