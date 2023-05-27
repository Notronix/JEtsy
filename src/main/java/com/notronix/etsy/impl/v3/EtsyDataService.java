package com.notronix.etsy.impl.v3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.v3.EtsyAPI;
import com.notronix.etsy.api.v3.PageableResponse;
import com.notronix.etsy.api.v3.model.authentication.EtsyScope;
import com.notronix.etsy.api.v3.model.taxonomy.TaxonomyNodeProperty;
import com.notronix.etsy.impl.v3.method.authentication.ExchangeTokenMethod;
import com.notronix.etsy.impl.v3.method.authentication.RefreshTokenMethod;
import com.notronix.etsy.impl.v3.method.taxonomy.GetSellerTaxonomyNodesMethod;
import com.notronix.etsy.impl.v3.method.other.PingMethod;
import com.notronix.etsy.impl.v3.method.other.TokenScopesMethod;
import com.notronix.etsy.impl.v3.method.taxonomy.GetTaxonomyNodePropertiesMethod;
import com.notronix.etsy.impl.v3.method.users.GetMeMethod;
import com.notronix.etsy.impl.v3.method.users.GetUserAddressMethod;
import com.notronix.etsy.impl.v3.method.users.GetUserAddressesMethod;
import com.notronix.etsy.impl.v3.method.users.GetUserMethod;
import com.notronix.etsy.impl.v3.model.authentication.EtsyTokenResponse;
import com.notronix.etsy.impl.v3.model.taxonomy.EtsyTaxonomy;
import com.notronix.etsy.impl.v3.model.taxonomy.EtsyTaxonomyNodeProperty;
import com.notronix.etsy.impl.v3.model.users.EtsyGetMeResponse;
import com.notronix.etsy.impl.v3.model.users.EtsyUser;
import com.notronix.etsy.impl.v3.model.users.EtsyUserAddress;

import java.lang.reflect.Type;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class EtsyDataService implements EtsyAPI
{
    private final Object lock = new Object();
    private final Credentials clientCredentials;
    private EtsyMethodExecutor executor;

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
            private final Gson gson = new GsonBuilder().create();

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

    private Gson getReceivingGSON() {
        return new GsonBuilder().create();
    }

    public EtsyDataService(String consumerKey, String consumerSecret) throws NullPointerException {
        clientCredentials = Credentials.forKeyPair(requireNonNull(consumerKey), requireNonNull(consumerSecret));
    }

    @Override
    public Long ping() throws EtsyException {
        return getExecutor().execute(new PingMethod(clientCredentials));
    }

    @Override
    public EtsyTokenResponse exchangeToken(String legacyToken) throws EtsyException {
        return getExecutor().execute(new ExchangeTokenMethod(clientCredentials)
                .withLegacyToken(legacyToken));
    }

    @Override
    public EtsyTokenResponse refreshToken(String refreshToken) throws EtsyException {
        return getExecutor().execute(new RefreshTokenMethod(clientCredentials)
                .withRefreshToken(refreshToken));
    }

    @Override
    public List<EtsyScope> getTokenScopes(String token) throws EtsyException {
        return getExecutor().execute(new TokenScopesMethod(clientCredentials)
                .withToken(token));
    }

    @Override
    public EtsyGetMeResponse getMe(Credentials accessCredentials) throws EtsyException {
        return getExecutor().execute(new GetMeMethod(clientCredentials, accessCredentials));
    }

    @Override
    public EtsyUser getUser(Credentials accessCredentials, Long userId) throws EtsyException {
        return getExecutor().execute(new GetUserMethod(clientCredentials, accessCredentials)
                .withUserId(userId));
    }

    @Override
    public EtsyUserAddress getUserAddress(Credentials accessCredentials, Long userAddressId) throws EtsyException {
        return getExecutor().execute(new GetUserAddressMethod(clientCredentials, accessCredentials)
                .withUserAddressId(userAddressId));
    }

    @Override
    public PageableResponse<EtsyUserAddress> getUserAddresses(Credentials accessCredentials, Integer limit, Integer offset)
            throws EtsyException {
        return getExecutor().execute(new GetUserAddressesMethod(clientCredentials, accessCredentials));
    }

    @Override
    public PageableResponse<EtsyTaxonomy> getSellerTaxonomyNodes() throws EtsyException {
        return getExecutor().execute(new GetSellerTaxonomyNodesMethod(clientCredentials));
    }

    @Override
    public PageableResponse<EtsyTaxonomyNodeProperty> getTaxonomyNodeProperties(Long taxonomyId) throws EtsyException {
        return getExecutor().execute(new GetTaxonomyNodePropertiesMethod(clientCredentials).withTaxonomyId(taxonomyId));
    }
}
