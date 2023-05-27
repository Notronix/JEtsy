package com.notronix.etsy.impl.v2.method.listings;

import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyPageableResponse;
import com.notronix.etsy.impl.v2.model.listings.EtsyListing;

import static com.notronix.etsy.impl.EtsyMethodUtils.addIfProvided;
import static com.notronix.etsy.impl.v2.method.EtsyPageableResponse.LISTINGS;

public class FindAllListingActiveMethod extends EtsyMethod<EtsyPageableResponse<EtsyListing>>
{
    private Integer limit;
    private Integer offset;

    public FindAllListingActiveMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public String getURI() {
        String uri = "/listings/active";
        uri = addIfProvided(uri, "limit", limit);
        uri = addIfProvided(uri, "offset", offset);

        return uri;
    }

    @Override
    public EtsyPageableResponse<EtsyListing> getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyPageableResponse<EtsyListing> response = unmarshaller.unmarshal(payload, LISTINGS);
//        Pagination pagination = response.getPagination();
//
//        if (pagination != null && pagination.hasNext()) {
//            response.setNextBuilder(method -> {
//                if (!(method instanceof FindAllListingActiveMethod)) {
//                    throw new IllegalArgumentException("invalid method");
//                }
//
//                ((FindAllListingActiveMethod) method)
//                        .withLimit(limit)
//                        .withOffset(pagination.getNextOffset());
//            });
//        }

        return response;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public FindAllListingActiveMethod withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public FindAllListingActiveMethod withOffset(Integer offset) {
        this.offset = offset;
        return this;
    }
}
