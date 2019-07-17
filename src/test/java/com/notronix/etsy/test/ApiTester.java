package com.notronix.etsy.test;

import com.notronix.etsy.api.EtsyAPIException;
import com.notronix.etsy.api.authentication.Credentials;
import com.notronix.etsy.impl.EtsyDataService;

public class ApiTester
{
    private Object test(EtsyDataService eds, Credentials clientCreds, Credentials accessCreds)
            throws EtsyAPIException {
        return eds.findAllCountry(clientCreds);
    }

    /**
     * Test Runner
     *
     * @param args used to supply credentials.  args must contain 4 supplied credentials as described by the code.
     */
    public static void main(String[] args) {
        String consumerKey = args[0];
        String consumerSecret = args[1];
        String token = args[2];
        String tokenSecret = args[3];

        Credentials clientCreds = Credentials.forKeyPair(consumerKey, consumerSecret);
        Credentials accessCreds = Credentials.forKeyPair(token, tokenSecret);

        try {
            Object result = new ApiTester().test(new EtsyDataService(), clientCreds, accessCreds);

            System.out.println("done");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
