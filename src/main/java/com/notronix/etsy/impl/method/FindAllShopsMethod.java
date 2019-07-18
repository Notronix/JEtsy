package com.notronix.etsy.impl.method;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.model.ShopAssociations;
import com.notronix.etsy.impl.model.EtsyShop;

import java.util.List;

import static com.notronix.etsy.impl.method.MethodUtils.addIfProvided;
import static com.notronix.etsy.impl.method.MethodUtils.safeList;

public class FindAllShopsMethod extends AbstractEtsyMethod<EtsyResponse<List<EtsyShop>>>
{
    private String shopName;
    private Integer limit;
    private Integer offset;
    private Float latitude;
    private Float longitude;
    private Float distanceMax;
    private ShopAssociations[] associations;

    @Override
    String getURI() {
        String uri = "/shops";
        uri = addIfProvided(uri, "shop_name", shopName);
        uri = addIfProvided(uri, "limit", limit);
        uri = addIfProvided(uri, "offset", offset);
        uri = addIfProvided(uri, "lat", latitude);
        uri = addIfProvided(uri, "lon", longitude);
        uri = addIfProvided(uri, "distance_max", distanceMax);
        uri = addIfProvided(uri, "includes", safeList(associations), ASSOCIATIONS_CONVERTER);

        return uri;
    }

    @Override
    public EtsyResponse<List<EtsyShop>> getResponse(Gson gson, String jsonPayload) {
        return gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyShop>>>(){}.getType());
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public FindAllShopsMethod withShopName(String shopName) {
        this.shopName = shopName;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public FindAllShopsMethod withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public FindAllShopsMethod withOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public FindAllShopsMethod withLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public FindAllShopsMethod withLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public Float getDistanceMax() {
        return distanceMax;
    }

    public void setDistanceMax(Float distanceMax) {
        this.distanceMax = distanceMax;
    }

    public FindAllShopsMethod withDistanceMax(Float distanceMax) {
        this.distanceMax = distanceMax;
        return this;
    }

    public ShopAssociations[] getAssociations() {
        return associations;
    }

    public void setAssociations(ShopAssociations[] associations) {
        this.associations = associations;
    }

    public FindAllShopsMethod withAssociations(ShopAssociations[] associations) {
        this.associations = associations;
        return this;
    }
}
