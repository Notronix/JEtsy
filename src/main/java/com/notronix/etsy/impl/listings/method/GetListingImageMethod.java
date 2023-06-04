package com.notronix.etsy.impl.listings.method;

import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.impl.EtsyMethod;
import com.notronix.etsy.impl.listings.model.EtsyListingImage;

import static java.util.Objects.requireNonNull;

public class GetListingImageMethod extends EtsyMethod<EtsyListingImage>
{
    private Long listingId;
    private Long imageId;

    public GetListingImageMethod(Credentials clientCredentials) {
        super(clientCredentials);
    }

    @Override
    public EtsyListingImage getResponse(Unmarshaller unmarshaller, String payload) {
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

    public GetListingImageMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public GetListingImageMethod withImageId(Long imageId) {
        this.imageId = imageId;
        return this;
    }
}
