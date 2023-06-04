package com.notronix.etsy.impl.listings.method;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.impl.EtsyPageableResponse;
import com.notronix.etsy.impl.PageableEtsyMethod;
import com.notronix.etsy.impl.listings.model.EtsyListingVariationImage;

import static java.util.Objects.requireNonNull;

public class GetListingVariationImagesMethod extends PageableEtsyMethod<EtsyListingVariationImage>
{
    private Long shopId;
    private Long listingId;

    public GetListingVariationImagesMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    public PageableResponse<EtsyListingVariationImage> getResponse(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload,
                new TypeToken<EtsyPageableResponse<EtsyListingVariationImage>>(){}.getType());
    }

    @Override
    protected String getURI() {
        return "/application/shops/" + requireNonNull(shopId) + "/listings/" + requireNonNull(listingId) + "/variation-images";
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public GetListingVariationImagesMethod withShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }

    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public GetListingVariationImagesMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }
}
