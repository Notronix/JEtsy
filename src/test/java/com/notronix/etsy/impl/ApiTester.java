package com.notronix.etsy.impl;

import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.api.shops.model.Shop;
import com.notronix.etsy.api.users.model.GetMeResponse;
import com.notronix.etsy.impl.authentication.model.EtsyTokenResponse;

public class ApiTester
{
    public static void main(String[] args) throws EtsyException {
        final String keyString = args[0];
        final String sharedSecret = args[1];
        EtsyAPI etsyAPI = new EtsyAPI(keyString, sharedSecret);

        String at = "access_token";
        String rt = "refresh_token";

        Credentials accessCredentials = Credentials.forKeyPair(at, null);

        try {
            GetMeResponse getMeResponse = etsyAPI.getUserResource().getMe(accessCredentials);
            Shop shop = etsyAPI.getShopResource().getShop(getMeResponse.getShopId());

            System.exit(0);
        }
        catch (EtsyException ex) {
            if (ex.isDueToExpiredToken()) {
                System.out.println("Token is expired.");
                EtsyTokenResponse tokenResponse = etsyAPI.getAuthResource().refreshToken(rt);
                System.out.println("Access Token: " + tokenResponse.getAccessToken());
                System.out.println("Refresh Token: " + tokenResponse.getRefreshToken());
                System.exit(1);
            }
        }
    }
}
