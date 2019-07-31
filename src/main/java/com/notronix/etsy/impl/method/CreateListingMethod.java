package com.notronix.etsy.impl.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.model.Listing;
import com.notronix.etsy.impl.model.EtsyListing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.notronix.albacore.ContainerUtils.thereAreNo;
import static com.notronix.etsy.impl.method.MethodUtils.putIfProvided;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.join;

public class CreateListingMethod extends AbstractEtsyMethod<EtsyListing>
{
    private Listing listing;

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.POST;
    }

    @Override
    public String getURI() {
        return "/listings";
    }

    @Override
    public HttpContent getContent(Gson gson) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("quantity", requireNonNull(listing.getQuantity()));
        parameters.put("title", requireNonNull(listing.getTitle()));
        parameters.put("description", requireNonNull(listing.getDescription()));
        parameters.put("price", requireNonNull(listing.getPrice()));
        parameters.put("shipping_template_id", requireNonNull(listing.getShippingTemplateId()));
        parameters.put("who_made", requireNonNull(listing.getWhoMade()));
        parameters.put("is_supply", requireNonNull(listing.getIsSupply()).toString());
        parameters.put("when_made", requireNonNull(listing.getWhenMade()));

        putIfProvided(parameters, "materials", listing.getMaterials() == null ? null : gson.toJson(listing.getMaterials()));
        putIfProvided(parameters, "shop_section_id", listing.getShopSectionId());
        putIfProvided(parameters, "is_customizable", listing.getIsCustomizable() == null ? null : listing.getIsCustomizable().toString());
        putIfProvided(parameters, "non_taxable", listing.getNonTaxable() == null ? null : listing.getNonTaxable().toString());
        putIfProvided(parameters, "state", listing.getState());
        putIfProvided(parameters, "processing_min", listing.getProcessingMin());
        putIfProvided(parameters, "processing_max", listing.getProcessingMax());
        putIfProvided(parameters, "category_id", listing.getCategoryId());
        putIfProvided(parameters, "taxonomy_id", listing.getTaxonomyId());
        putIfProvided(parameters, "tags", thereAreNo(listing.getTags()) ? null : join(listing.getTags(), ","));
        putIfProvided(parameters, "recipient", listing.getRecipient());
        putIfProvided(parameters, "occasion", listing.getOccasion());
        putIfProvided(parameters, "style", listing.getStyle() == null ? null : gson.toJson(listing.getStyle()));

        return new UrlEncodedContent(parameters);
    }

    @Override
    public EtsyListing getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyListing>> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyListing>>>(){}.getType());

        return response.getResults().stream().findAny().orElse(null);
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public CreateListingMethod withListing(Listing listing) {
        this.listing = listing;
        return this;
    }
}
