package com.notronix.etsy.api.users;

import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.users.model.GetMeResponse;
import com.notronix.etsy.api.users.model.User;
import com.notronix.etsy.api.users.model.UserAddress;

public interface UserResource
{
    GetMeResponse getMe(Credentials accessCredentials) throws EtsyException;

    User getUser(Credentials accessCredentials, Long userId) throws EtsyException;

    UserAddress getUserAddress(Credentials accessCredentials, Long userAddressId) throws EtsyException;

    PageableResponse<? extends UserAddress> getUserAddresses(Credentials accessCredentials, Integer limit, Integer offset)
            throws EtsyException;
}
