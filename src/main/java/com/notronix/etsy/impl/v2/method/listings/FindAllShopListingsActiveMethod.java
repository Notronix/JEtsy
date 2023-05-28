package com.notronix.etsy.impl.v2.method.listings;

import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.v2.model.listings.ListingAssociations;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyPageableResponse;
import com.notronix.etsy.impl.v2.model.listings.EtsyListing;

import static com.notronix.albacore.Predicates.requireNonBlank;
import static com.notronix.etsy.api.v2.EtsyAPI.__SELF__;
import static com.notronix.etsy.impl.v2.method.EtsyPageableResponse.LISTINGS;

public class FindAllShopListingsActiveMethod extends EtsyMethod<EtsyPageableResponse<EtsyListing>>
{
    private String shopIdOrName;
    private Integer limit;
    private Integer offset;
    private ListingAssociations[] associations;

    public FindAllShopListingsActiveMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    protected String getURI() {
        return "/shops/" + requireNonBlank(shopIdOrName) + "/listings/active";
    }

    @Override
    public boolean requiresOAuth() {
        return __SELF__.equals(shopIdOrName);
    }

    @Override
    public EtsyPageableResponse<EtsyListing> getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, LISTINGS);
    }

    public String getShopIdOrName() {
        return shopIdOrName;
    }

    public void setShopIdOrName(String shopIdOrName) {
        this.shopIdOrName = shopIdOrName;
    }

    public FindAllShopListingsActiveMethod withShopIdOrName(String shopIdOrName) {
        this.shopIdOrName = shopIdOrName;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public FindAllShopListingsActiveMethod withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public FindAllShopListingsActiveMethod withOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public ListingAssociations[] getAssociations() {
        return associations;
    }

    public void setAssociations(ListingAssociations[] associations) {
        this.associations = associations;
    }

    public FindAllShopListingsActiveMethod withAssociations(ListingAssociations[] associations) {
        this.associations = associations;
        return this;
    }
}
