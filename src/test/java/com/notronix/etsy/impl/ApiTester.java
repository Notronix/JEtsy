package com.notronix.etsy.impl;

import com.google.api.client.http.HttpContent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.notronix.etsy.api.*;
import com.notronix.etsy.api.authentication.method.PingMethod;
import com.notronix.etsy.api.authentication.method.RefreshTokenMethod;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.authentication.model.RefreshToken;
import com.notronix.etsy.api.authentication.model.TokenResponse;
import com.notronix.etsy.api.listings.method.CreateDraftListingMethod;
import com.notronix.etsy.api.listings.method.GetListingInventoryMethod;
import com.notronix.etsy.api.listings.model.Listing;
import com.notronix.etsy.api.listings.model.ListingInventory;
import com.notronix.etsy.api.users.method.GetMeMethod;
import com.notronix.etsy.api.users.model.GetMeResponse;
import com.notronix.etsy.impl.authentication.method.EtsyAuthResource;
import com.notronix.etsy.impl.common.json.InstantAdapter;
import com.notronix.etsy.impl.listings.method.EtsyListingResource;
import com.notronix.etsy.impl.shops.method.EtsyShopResource;
import com.notronix.etsy.impl.taxonomy.method.EtsyTaxonomyResource;
import com.notronix.etsy.impl.users.method.EtsyUserResource;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ApiTester
{
    /**
     * Long testListingId = 1496404187L;
     * Long testImageId = 5018283025L;
     *
     * @param args 1 argument containing the application keyString.
     * @throws EtsyException if the API fails.
     */
    public static void main(String[] args) throws EtsyException {
        AppKey appKey = AppKey.forKeyString(args[0]);
        API<HttpContent> etsyAPI = getEtsyAPI();

        AccessToken accessToken = AccessToken.forToken("<access_token>");

        try {
            PingMethod<HttpContent> pingMethod = etsyAPI.getAuthResource().createPingMethod();
            Long pingResponse = etsyAPI.execute(appKey, pingMethod).getContent();

            GetMeMethod<HttpContent> getMeMethod = etsyAPI.getUserResource().createGetMeMethod(accessToken);
            GetMeResponse getMeResponse = etsyAPI.execute(appKey, getMeMethod).getContent();

            CreateDraftListingMethod<HttpContent> createDraftListingMethod = etsyAPI.getListingResource()
                    .createCreateDraftListingMethod(accessToken);
            createDraftListingMethod.setShopId(getMeResponse.getShopId());
            createDraftListingMethod.setTitle("title");
            createDraftListingMethod.setDescription("description");
            Listing listing = etsyAPI.execute(appKey, createDraftListingMethod).getContent();

            GetListingInventoryMethod<HttpContent> getListingInventoryMethod = etsyAPI.getListingResource()
                    .createGetListingInventoryMethod(accessToken);
            ListingInventory inventory = etsyAPI.execute(appKey, getListingInventoryMethod).getContent();

            System.exit(0);
        }
        catch (EtsyException ex) {
            ex.printStackTrace();
            if (ex.isDueToExpiredToken()) {
                refreshToken(etsyAPI, appKey);
            }

            System.exit(1);
        }
    }

    private static void refreshToken(API<HttpContent> etsyAPI, AppKey appKey) throws EtsyException {
        System.out.println("Token is expired.");

        RefreshToken refreshToken = RefreshToken.forToken("<refresh_token>");
        RefreshTokenMethod<HttpContent> refreshTokenMethod = etsyAPI.getAuthResource()
                .createRefreshTokenMethod(appKey, refreshToken);
        TokenResponse tokenResponse = etsyAPI.execute(appKey, refreshTokenMethod).getContent();

        System.out.println("Access Token: " + tokenResponse.getAccessToken().getValue());
        System.out.println("Refresh Token: " + tokenResponse.getRefreshToken().getValue());
    }

    private static API<HttpContent> getEtsyAPI() {
        Marshaller marshaller = getMarshaller();
        Unmarshaller unmarshaller = getUnMarshaller();

        EtsyAPI etsyAPI = new EtsyAPI();
        etsyAPI.setMarshaller(marshaller);
        etsyAPI.setUnmarshaller(unmarshaller);
        etsyAPI.setAuthResource(new EtsyAuthResource());
        etsyAPI.setListingResource(new EtsyListingResource());
        etsyAPI.setShopResource(new EtsyShopResource());
        etsyAPI.setUserResource(new EtsyUserResource());
        etsyAPI.setTaxonomyResource(new EtsyTaxonomyResource());

        return etsyAPI;
    }

    private static Marshaller getMarshaller() {
        return new Marshaller()
        {
            private final Gson gson = new GsonBuilder().setVersion(0).create();

            @Override
            public String marshal(Object object) {
                return gson.toJson(object);
            }
        };
    }

    private static Unmarshaller getUnMarshaller() {
        return new Unmarshaller()
        {
            private final Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Instant.class, new InstantAdapter().nullSafe())
                    .create();

            @Override
            public <T> T unmarshal(String payload, Class<T> classOfT) {
                return gson.fromJson(payload, classOfT);
            }

            @Override
            public <T> T unmarshal(String payload, Type typeOfT) {
                return gson.fromJson(payload, typeOfT);
            }
        };
    }

    private static void getTime() {
        try {
            String time = "Sat, 10 Jun 2023 11:36:46 GMT";
            Instant date = ZonedDateTime.parse(time, DateTimeFormatter.RFC_1123_DATE_TIME).toInstant();

            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        System.exit(0);
    }
}
