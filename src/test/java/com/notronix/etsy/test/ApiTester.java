package com.notronix.etsy.test;

import com.notronix.etsy.api.EtsyAPIException;
import com.notronix.etsy.api.authentication.Credentials;
import com.notronix.etsy.api.model.ListingAssociations;
import com.notronix.etsy.impl.EtsyDataService;
import com.notronix.etsy.impl.model.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public class ApiTester
{
    private Object test(EtsyDataService eds, Credentials clientCreds, Credentials accessCreds)
            throws EtsyAPIException {
        Long listingId = 725719657L; // change this to the listing you want to add the image to
//        Integer rank = 1;
//        Boolean overwrite = null;
//        Boolean isWaterMarked = null;
//        File image = null; // add code here to get your image as a java.io.File instance.

        EtsyListing listing = eds.getListing(clientCreds, accessCreds, listingId, ListingAssociations.values());
        EtsyListingImage mainImage = listing.getMainImage();
        EtsyListingInventory inventory = listing.getInventory().get(0);
        EtsyListingProduct product = inventory.getProducts().get(0);
        EtsyPropertyValue propertyValue = product.getPropertyValues().get(0);

        EtsyListingVariationImage variationImage = new EtsyListingVariationImage();
        variationImage.setImageId(mainImage.getListingImageId());
        variationImage.setPropertyId(propertyValue.getPropertyId());
        variationImage.setValueId(propertyValue.getValueIds().get(0));

        List<EtsyListingVariationImage> currentImages = eds.getVariationImages(clientCreds, accessCreds, listingId);

        return eds.updateVariationImages(clientCreds, accessCreds, listingId, singletonList(variationImage));
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
