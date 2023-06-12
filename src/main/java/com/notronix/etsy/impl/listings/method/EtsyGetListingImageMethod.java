package com.notronix.etsy.impl.listings.method;

import com.google.api.client.http.HttpContent;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.listings.method.GetListingImageMethod;
import com.notronix.etsy.api.listings.model.ListingImage;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.listings.model.EtsyListingImage;

import static java.util.Objects.requireNonNull;

public class EtsyGetListingImageMethod extends AbstractEtsyMethod<ListingImage>
        implements GetListingImageMethod<HttpContent>
{
    private Long listingId;
    private Long imageId;

    public EtsyListingImage buildResponseBody(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, EtsyListingImage.class);
    }

    @Override
    protected String getURI() {
        return "/application/listings/" + requireNonNull(listingId) + "/images/" + requireNonNull(imageId);
    }

    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public EtsyGetListingImageMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public EtsyGetListingImageMethod withImageId(Long imageId) {
        this.imageId = imageId;
        return this;
    }
}
