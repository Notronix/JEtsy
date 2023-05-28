package com.notronix.etsy.impl.v2.method.shops;

import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.v2.model.shops.ReceiptAssociations;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyPageableResponse;
import com.notronix.etsy.impl.v2.model.shops.EtsyReceipt;

import static com.notronix.etsy.impl.EtsyMethodUtils.addIfProvided;
import static com.notronix.etsy.impl.EtsyMethodUtils.safeList;
import static com.notronix.etsy.impl.v2.method.EtsyPageableResponse.RECEIPTS;
import static java.util.Objects.requireNonNull;

public class FindAllShopReceiptsMethod extends EtsyMethod<EtsyPageableResponse<EtsyReceipt>>
{
    private String shopIdOrName;
    private Integer limit;
    private Integer offset;
    private ReceiptAssociations[] associations;

    public FindAllShopReceiptsMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    protected String getURI() {
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
    public EtsyPageableResponse<EtsyReceipt> getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, RECEIPTS);
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
