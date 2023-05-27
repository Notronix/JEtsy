package com.notronix.etsy.impl.v2.method.listings;

import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.impl.v2.method.EtsyMethod;
import com.notronix.etsy.impl.v2.method.EtsyResponse;
import com.notronix.etsy.impl.v2.model.listings.EtsyListingInventory;

import static com.notronix.etsy.impl.EtsyMethodUtils.addIfProvided;
import static java.lang.Boolean.TRUE;

public class GetInventoryMethod extends EtsyMethod<EtsyListingInventory>
{
    private Long listingId;
    private Boolean writeMissingInventory;

    public GetInventoryMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public String getURI() {
        String uri = "/listings/" + listingId + "/inventory";
        uri = addIfProvided(uri, "write_missing_inventory", TRUE.equals(writeMissingInventory) ? "1" : null);

        return uri;
    }

    @Override
    public EtsyListingInventory getResponse(Unmarshaller unmarshaller, String payload) {
        EtsyResponse<EtsyListingInventory> response =
                unmarshaller.unmarshal(payload, new TypeToken<EtsyResponse<EtsyListingInventory>>(){}.getType());

        return response.getResults();
    }

    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public GetInventoryMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }

    public Boolean getWriteMissingInventory() {
        return writeMissingInventory;
    }

    public void setWriteMissingInventory(Boolean writeMissingInventory) {
        this.writeMissingInventory = writeMissingInventory;
    }

    public GetInventoryMethod withWriteMissingInventory(Boolean writeMissingInventory) {
        this.writeMissingInventory = writeMissingInventory;
        return this;
    }
}
