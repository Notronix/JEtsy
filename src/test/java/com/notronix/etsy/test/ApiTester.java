package com.notronix.etsy.test;

import com.notronix.etsy.api.EtsyAPIException;
import com.notronix.etsy.api.authentication.Credentials;
import com.notronix.etsy.impl.EtsyDataService;

import java.io.File;

public class ApiTester
{
    private Object test(EtsyDataService eds, Credentials clientCreds, Credentials accessCreds)
            throws EtsyAPIException {
        Long listingId = -1L; // change this to the listing you want to add the image to
        File image = null; // add code here to get your image as a java.io.File instance.

        return eds.uploadListingImage(clientCreds, accessCreds, listingId, image);
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
