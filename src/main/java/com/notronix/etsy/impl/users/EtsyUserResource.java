package com.notronix.etsy.impl.users;

import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.PageableResponse;
import com.notronix.etsy.api.users.UserResource;
import com.notronix.etsy.impl.EtsyResource;
import com.notronix.etsy.impl.EtsyMethodExecutor;
import com.notronix.etsy.impl.users.method.GetMeMethod;
import com.notronix.etsy.impl.users.method.GetUserAddressMethod;
import com.notronix.etsy.impl.users.method.GetUserAddressesMethod;
import com.notronix.etsy.impl.users.method.GetUserMethod;
import com.notronix.etsy.impl.users.model.EtsyGetMeResponse;
import com.notronix.etsy.impl.users.model.EtsyUser;
import com.notronix.etsy.impl.users.model.EtsyUserAddress;

public class EtsyUserResource extends EtsyResource implements UserResource
{
    public EtsyUserResource(EtsyMethodExecutor executor, Credentials clientCredentials) {
        super(executor, clientCredentials);
    }

    public EtsyGetMeResponse getMe(Credentials accessCredentials) throws EtsyException {
        return getExecutor().execute(new GetMeMethod(getClientCredentials(), accessCredentials));
    }

    @Override
    public EtsyUser getUser(Credentials accessCredentials, Long userId) throws EtsyException {
        return getExecutor().execute(new GetUserMethod(getClientCredentials(), accessCredentials)
                .withUserId(userId));
    }

    @Override
    public EtsyUserAddress getUserAddress(Credentials accessCredentials, Long userAddressId) throws EtsyException {
        return getExecutor().execute(new GetUserAddressMethod(getClientCredentials(), accessCredentials)
                .withUserAddressId(userAddressId));
    }

    @Override
    public PageableResponse<EtsyUserAddress> getUserAddresses(Credentials accessCredentials, Integer limit, Integer offset)
            throws EtsyException {
        return getExecutor().execute(new GetUserAddressesMethod(getClientCredentials(), accessCredentials));
    }
}
