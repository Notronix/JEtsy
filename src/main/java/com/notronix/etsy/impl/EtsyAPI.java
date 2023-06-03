package com.notronix.etsy.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.notronix.etsy.api.API;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.impl.authentication.EtsyAuthResource;
import com.notronix.etsy.impl.common.json.InstantAdapter;
import com.notronix.etsy.impl.listings.EtsyListingResource;
import com.notronix.etsy.impl.shops.EtsyShopResource;
import com.notronix.etsy.impl.taxonomy.EtsyTaxonomyResource;
import com.notronix.etsy.impl.users.EtsyUserResource;

import java.lang.reflect.Type;
import java.time.Instant;

import static java.util.Objects.requireNonNull;

public class EtsyAPI implements API
{
    private final Object lock = new Object();
    private final Credentials clientCredentials;
    private EtsyMethodExecutor executor;
    private EtsyAuthResource authResource;
    private EtsyListingResource listingResource;
    private EtsyShopResource shopResource;
    private EtsyTaxonomyResource taxonomyResource;
    private EtsyUserResource userResource;

    public EtsyAPI(String consumerKey, String consumerSecret) throws NullPointerException {
        clientCredentials = Credentials.forKeyPair(requireNonNull(consumerKey), requireNonNull(consumerSecret));
    }

    private EtsyMethodExecutor getExecutor() {
        if (executor != null) {
            return executor;
        }

        synchronized (lock) {
            if (executor != null) {
                return executor;
            }

            executor = new EtsyMethodExecutor(getMarshaller(), getUnMarshaller());
        }

        return executor;
    }

    public void setExecutor(EtsyMethodExecutor executor) {
        this.executor = executor;
    }

    @Override
    public EtsyAuthResource getAuthResource() {
        if (authResource != null) {
            return authResource;
        }

        EtsyMethodExecutor executor = getExecutor();

        synchronized (lock) {
            if (authResource != null) {
                return authResource;
            }

            authResource = new EtsyAuthResource(executor, clientCredentials);
        }

        return authResource;
    }

    public void setAuthResource(EtsyAuthResource authResource) {
        this.authResource = authResource;
    }

    @Override
    public EtsyListingResource getListingResource() {
        if (listingResource != null) {
            return listingResource;
        }

        EtsyMethodExecutor executor = getExecutor();

        synchronized (lock) {
            if (listingResource != null) {
                return listingResource;
            }

            listingResource = new EtsyListingResource(executor, clientCredentials);
        }

        return listingResource;
    }

    public void setListingResource(EtsyListingResource listingResource) {
        this.listingResource = listingResource;
    }

    @Override
    public EtsyShopResource getShopResource() {
        if (shopResource != null) {
            return shopResource;
        }

        EtsyMethodExecutor executor = getExecutor();

        synchronized (lock) {
            if (shopResource != null) {
                return shopResource;
            }

            shopResource = new EtsyShopResource(executor, clientCredentials);
        }

        return shopResource;
    }

    public void setShopResource(EtsyShopResource shopResource) {
        this.shopResource = shopResource;
    }

    @Override
    public EtsyTaxonomyResource getTaxonomyResource() {
        if (taxonomyResource != null) {
            return taxonomyResource;
        }

        EtsyMethodExecutor executor = getExecutor();

        synchronized (lock) {
            if (taxonomyResource != null) {
                return taxonomyResource;
            }

            taxonomyResource = new EtsyTaxonomyResource(executor, clientCredentials);
        }

        return taxonomyResource;
    }

    public void setTaxonomyResource(EtsyTaxonomyResource taxonomyResource) {
        this.taxonomyResource = taxonomyResource;
    }

    @Override
    public EtsyUserResource getUserResource() {
        if (userResource != null) {
            return userResource;
        }

        EtsyMethodExecutor executor = getExecutor();

        synchronized (lock) {
            if (userResource != null) {
                return userResource;
            }

            userResource = new EtsyUserResource(executor, clientCredentials);
        }

        return userResource;
    }

    public void setUserResource(EtsyUserResource userResource) {
        this.userResource = userResource;
    }

    private Marshaller getMarshaller() {
        return new Marshaller()
        {
            private final Gson gson = new GsonBuilder().setVersion(0).create();

            @Override
            public String marshal(Object object) {
                return gson.toJson(object);
            }
        };
    }

    private Unmarshaller getUnMarshaller() {
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
}
