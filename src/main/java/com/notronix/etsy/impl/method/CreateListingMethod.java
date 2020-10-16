package com.notronix.etsy.impl.method;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.UrlEncodedContent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.authentication.Credentials;
import com.notronix.etsy.api.model.ListingState;
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
    private Integer quantity;
    private String title;
    private String description;
    private Float price;
    private List<String> materials;
    private Long shippingTemplateId;
    private Long shopSectionId;
    private List<Long> imageIds;
    private Boolean isCustomizable;
    private Boolean nonTaxable;
    private ListingState state;
    private Integer processingMin;
    private Integer processingMax;
    private Long categoryId;
    private Long taxonomyId;
    private List<String> tags;
    private String whoMade;
    private Boolean isSupply;
    private String whenMade;
    private String recipient;
    private String occasion;
    private List<String> style;

    public CreateListingMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

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
        parameters.put("quantity", requireNonNull(quantity));
        parameters.put("title", requireNonNull(title));
        parameters.put("description", requireNonNull(description));
        parameters.put("price", requireNonNull(price));
        parameters.put("shipping_template_id", requireNonNull(shippingTemplateId));
        parameters.put("who_made", requireNonNull(whoMade));
        parameters.put("is_supply", requireNonNull(isSupply));
        parameters.put("when_made", requireNonNull(whenMade));

        putIfProvided(parameters, "materials", thereAreNo(materials) ? null : join(materials, ","));
        putIfProvided(parameters, "shop_section_id", shopSectionId);
        putIfProvided(parameters, "is_customizable", isCustomizable);
        putIfProvided(parameters, "non_taxable", nonTaxable);
        putIfProvided(parameters, "state", state == null ? null : state.apiValue());
        putIfProvided(parameters, "processing_min", processingMin);
        putIfProvided(parameters, "processing_max", processingMax);
        putIfProvided(parameters, "category_id", categoryId);
        putIfProvided(parameters, "taxonomy_id", taxonomyId);
        putIfProvided(parameters, "tags", thereAreNo(tags) ? null : join(tags, ","));
        putIfProvided(parameters, "recipient", recipient);
        putIfProvided(parameters, "occasion", occasion);
        putIfProvided(parameters, "style", thereAreNo(style) ? null : join(style, ","));

        return new UrlEncodedContent(parameters);
    }

    @Override
    public EtsyListing getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyListing>> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyListing>>>(){}.getType());

        return response.getResults().stream().findAny().orElse(null);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CreateListingMethod withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CreateListingMethod withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CreateListingMethod withDescription(String description) {
        this.description = description;
        return this;
    }

    public List<String> getMaterials() {
        return materials;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    public CreateListingMethod withMaterials(List<String> materials) {
        this.materials = materials;
        return this;
    }

    public Long getShippingTemplateId() {
        return shippingTemplateId;
    }

    public void setShippingTemplateId(Long shippingTemplateId) {
        this.shippingTemplateId = shippingTemplateId;
    }

    public CreateListingMethod withShippingTemplateId(Long shippingTemplateId) {
        this.shippingTemplateId = shippingTemplateId;
        return this;
    }

    public Long getShopSectionId() {
        return shopSectionId;
    }

    public void setShopSectionId(Long shopSectionId) {
        this.shopSectionId = shopSectionId;
    }

    public CreateListingMethod withShopSectionId(Long shopSectionId) {
        this.shopSectionId = shopSectionId;
        return this;
    }

    public ListingState getState() {
        return state;
    }

    public void setState(ListingState state) {
        this.state = state;
    }

    public CreateListingMethod withState(ListingState state) {
        this.state = state;
        return this;
    }

    public List<Long> getImageIds() {
        return imageIds;
    }

    public void setImageIds(List<Long> imageIds) {
        this.imageIds = imageIds;
    }

    public CreateListingMethod withImageIds(List<Long> imageIds) {
        this.imageIds = imageIds;
        return this;
    }

    public Boolean getIsCustomizable() {
        return isCustomizable;
    }

    public void setIsCustomizable(Boolean isCustomizable) {
        this.isCustomizable = isCustomizable;
    }

    public CreateListingMethod withIsCustomizable(Boolean isCustomizable) {
        this.isCustomizable = isCustomizable;
        return this;
    }

    public Boolean getNonTaxable() {
        return nonTaxable;
    }

    public void setNonTaxable(Boolean nonTaxable) {
        this.nonTaxable = nonTaxable;
    }

    public CreateListingMethod withNonTaxable(Boolean nonTaxable) {
        this.nonTaxable = nonTaxable;
        return this;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public CreateListingMethod withCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Long getTaxonomyId() {
        return taxonomyId;
    }

    public void setTaxonomyId(Long taxonomyId) {
        this.taxonomyId = taxonomyId;
    }

    public CreateListingMethod withTaxonomyId(Long taxonomyId) {
        this.taxonomyId = taxonomyId;
        return this;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public CreateListingMethod withTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public String getWhoMade() {
        return whoMade;
    }

    public void setWhoMade(String whoMade) {
        this.whoMade = whoMade;
    }

    public CreateListingMethod withWhoMade(String whoMade) {
        this.whoMade = whoMade;
        return this;
    }

    public Boolean getIsSupply() {
        return isSupply;
    }

    public void setIsSupply(Boolean isSupply) {
        this.isSupply = isSupply;
    }

    public CreateListingMethod withIsSupply(Boolean isSupply) {
        this.isSupply = isSupply;
        return this;
    }

    public String getWhenMade() {
        return whenMade;
    }

    public void setWhenMade(String whenMade) {
        this.whenMade = whenMade;
    }

    public CreateListingMethod withWhenMade(String whenMade) {
        this.whenMade = whenMade;
        return this;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public CreateListingMethod withRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public CreateListingMethod withOccasion(String occasion) {
        this.occasion = occasion;
        return this;
    }

    public List<String> getStyle() {
        return style;
    }

    public void setStyle(List<String> style) {
        this.style = style;
    }

    public CreateListingMethod withStyle(List<String> style) {
        this.style = style;
        return this;
    }

    public Integer getProcessingMin() {
        return processingMin;
    }

    public void setProcessingMin(Integer processingMin) {
        this.processingMin = processingMin;
    }

    public CreateListingMethod withProcessingMin(Integer processingMin) {
        this.processingMin = processingMin;
        return this;
    }

    public Integer getProcessingMax() {
        return processingMax;
    }

    public void setProcessingMax(Integer processingMax) {
        this.processingMax = processingMax;
    }

    public CreateListingMethod withProcessingMax(Integer processingMax) {
        this.processingMax = processingMax;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public CreateListingMethod withPrice(Float price) {
        this.price = price;
        return this;
    }
}
