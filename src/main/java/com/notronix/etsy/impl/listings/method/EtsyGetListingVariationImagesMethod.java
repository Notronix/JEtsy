package com.notronix.etsy.impl.listings.method;

import com.google.api.client.http.HttpContent;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.listings.method.GetListingVariationImagesMethod;
import com.notronix.etsy.api.listings.model.ListingVariationImage;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.EtsyPageableResponse;
import com.notronix.etsy.impl.listings.model.EtsyListingVariationImage;

import static java.util.Objects.requireNonNull;

public class EtsyGetListingVariationImagesMethod extends AbstractEtsyMethod<PageableResponse<ListingVariationImage>>
    implements GetListingVariationImagesMethod<HttpContent>
{
    private Long shopId;
    private Long listingId;

    @Override
    public PageableResponse<ListingVariationImage> buildResponseBody(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload,
                new TypeToken<EtsyPageableResponse<EtsyListingVariationImage>>(){}.getType());
    }

    @Override
    protected String getURI() {
        return "/application/shops/" + requireNonNull(shopId) + "/listings/"
                + requireNonNull(listingId) + "/variation-images";
    }

    public Long getShopId() {
        return shopId;
    }

    @Override
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public EtsyGetListingVariationImagesMethod withShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }

    public Long getListingId() {
        return listingId;
    }

    @Override
    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public EtsyGetListingVariationImagesMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }
}
