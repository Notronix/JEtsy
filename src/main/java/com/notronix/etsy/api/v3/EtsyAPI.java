package com.notronix.etsy.api.v3;

import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.v3.model.authentication.EtsyScope;
import com.notronix.etsy.api.v3.model.authentication.TokenResponse;
import com.notronix.etsy.api.v3.model.taxonomy.Taxonomy;
import com.notronix.etsy.api.v3.model.taxonomy.TaxonomyNodeProperty;
import com.notronix.etsy.api.v3.model.users.GetMeResponse;
import com.notronix.etsy.api.v3.model.users.User;
import com.notronix.etsy.api.v3.model.users.UserAddress;

import java.util.List;

public interface EtsyAPI
{
    Long ping() throws EtsyException;

    TokenResponse exchangeToken(String legacyToken) throws EtsyException;

    TokenResponse refreshToken(String refreshToken) throws EtsyException;

    List<EtsyScope> getTokenScopes(String token) throws EtsyException;

    GetMeResponse getMe(Credentials accessCredentials) throws EtsyException;

    User getUser(Credentials accessCredentials, Long userId) throws EtsyException;

    UserAddress getUserAddress(Credentials accessCredentials, Long userAddressId) throws EtsyException;

    PageableResponse<? extends UserAddress> getUserAddresses(Credentials accessCredentials, Integer limit, Integer offset)
            throws EtsyException;

    PageableResponse<? extends Taxonomy> getSellerTaxonomyNodes() throws EtsyException;

    PageableResponse<? extends TaxonomyNodeProperty> getTaxonomyNodeProperties(Long taxonomyId) throws EtsyException;
}
