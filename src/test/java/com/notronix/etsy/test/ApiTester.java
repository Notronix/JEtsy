package com.notronix.etsy.test;

import com.google.gson.Gson;
import com.notronix.etsy.api.EtsyAPI;
import com.notronix.etsy.api.EtsyAPIException;
import com.notronix.etsy.api.authentication.Credentials;
import com.notronix.etsy.impl.EtsyDataService;

import static com.notronix.etsy.api.EtsyAPI.__SELF__;

public class ApiTester
{
    /**
     * Test Runner
     *
     * @param args used to supply credentials.
     */
    public static void main(String[] args) throws EtsyAPIException {
        final String keyString = args[0];
        final String sharedSecret = args[1];

        Credentials clientCreds = Credentials.forKeyPair(keyString, sharedSecret);

        EtsyDataService etsyDataService = new EtsyDataService();
        String callback = "oob";
        Set<String> scopes = Arrays.stream(EtsyScope.values()).map(Enum::name).collect(toSet());
        Credentials temporaryCreds = etsyDataService.getTemporaryCredentials(clientCreds, callback, scopes);
        String loginUrl = temporaryCreds.getLoginUrl();

        String verifier = "VerificationCodeProvidedByEtsy";
        Credentials accessCreds = etsyDataService.getAccessCredentials(clientCreds, temporaryCreds, verifier);

        List<String> userIdsOrNames = Collections.singletonList(EtsyAPI.__SELF__);
        List<EtsyUser> users = etsyDataService.getUser(clientCreds, accessCreds, userIdsOrNames, UserAssociations.values());
        EtsyUser authorizedEtsyAccountUser = users.get(0);

        System.out.println(new Gson().toJson(authorizedEtsyAccountUser));
    }
}
