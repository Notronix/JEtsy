package com.notronix.etsy.impl.v2;

import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.v2.model.users.UserAssociations;
import com.notronix.etsy.impl.v2.method.EtsyPageableResponse;
import com.notronix.etsy.impl.v2.model.users.EtsyUser;

import java.util.ArrayList;
import java.util.List;

public class ApiTester
{
    public static void main(String[] args) throws EtsyException {
        final String keyString = args[0];
        final String sharedSecret = args[1];

        EtsyDataService etsyDataService = new EtsyDataService(keyString, sharedSecret);

        EtsyPageableResponse<EtsyUser> pageableResponse = etsyDataService.findAllUsers("keith", 50, 0,
                UserAssociations.Shops, UserAssociations.Addresses);
        List<EtsyUser> users = new ArrayList<>(pageableResponse.getResults());

        while (pageableResponse.hasNext()) {
            pageableResponse = etsyDataService.findAllUsers(pageableResponse);
            users.addAll(pageableResponse.getResults());
        }

        System.exit(users.size());
    }
}
