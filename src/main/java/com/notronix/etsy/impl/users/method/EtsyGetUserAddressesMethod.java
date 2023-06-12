package com.notronix.etsy.impl.users.method;

import com.google.api.client.http.HttpContent;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.common.method.OAuthMethod;
import com.notronix.etsy.api.common.method.PageableMethod;
import com.notronix.etsy.api.users.method.GetUserAddressesMethod;
import com.notronix.etsy.api.users.model.UserAddress;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.EtsyPageableResponse;
import com.notronix.etsy.impl.users.model.EtsyUserAddress;

public class EtsyGetUserAddressesMethod extends AbstractEtsyMethod<PageableResponse<UserAddress>>
    implements GetUserAddressesMethod<HttpContent>, OAuthMethod, PageableMethod
{
    private AccessToken accessToken;
    private Integer limit;
    private Integer offset;

    @Override
    public PageableResponse<UserAddress> buildResponseBody(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload,
                new TypeToken<EtsyPageableResponse<EtsyUserAddress>>(){}.getType());
    }

    @Override
    protected String getURI() {
        String uri = "/application/user/addresses";
        uri = addPageableParameters(uri, this, true);

        return uri;
    }

    @Override
    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public EtsyGetUserAddressesMethod withAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    @Override
    public Integer getLimit() {
        return limit;
    }

    @Override
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public EtsyGetUserAddressesMethod withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    @Override
    public Integer getOffset() {
        return offset;
    }

    @Override
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public EtsyGetUserAddressesMethod withOffset(Integer offset) {
        this.offset = offset;
        return this;
    }
}
