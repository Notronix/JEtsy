package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.impl.model.EtsyListingInventory;

import static java.lang.Boolean.TRUE;

public class GetInventoryMethod extends AbstractEtsyMethod<EtsyListingInventory>
{
    private Long listingId;
    private Boolean writeMissingInventory;

    @Override
    public String getURI(String apiKey) {
        String uri = "/listings/" + listingId + "/inventory?api_key=" + apiKey;

        if (TRUE.equals(writeMissingInventory)) {
            uri += "&write_missing_inventory=1";
        }

        return uri;
    }

    @Override
    public EtsyListingInventory getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<EtsyListingInventory> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<EtsyListingInventory>>(){}.getType());

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
