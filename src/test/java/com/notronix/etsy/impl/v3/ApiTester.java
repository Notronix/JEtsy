package com.notronix.etsy.impl.v3;

import com.notronix.etsy.api.Credentials;
import com.notronix.etsy.api.EtsyException;
import com.notronix.etsy.api.v3.PageableResponse;
import com.notronix.etsy.impl.v3.model.authentication.EtsyTokenResponse;
import com.notronix.etsy.impl.v3.model.taxonomy.EtsyTaxonomy;
import com.notronix.etsy.impl.v3.model.taxonomy.EtsyTaxonomyNodeProperty;

import static com.notronix.albacore.ContainerUtils.theFirst;

public class ApiTester
{
    public static void main(String[] args) throws EtsyException {
        final String keyString = args[0];
        final String sharedSecret = args[1];
        EtsyDataService etsyDataService = new EtsyDataService(keyString, sharedSecret);

        Credentials accessCredentials =
                Credentials.forKeyPair("access_token", null);

        try {
            PageableResponse<EtsyTaxonomy> nodesResponse = etsyDataService.getSellerTaxonomyNodes();
            PageableResponse<EtsyTaxonomyNodeProperty> propertiesResponse =
                    etsyDataService.getTaxonomyNodeProperties(theFirst(nodesResponse.getResults()).getId());

            System.exit(0);
        }
        catch (EtsyException ex) {
            if (ex.isDueToExpiredToken()) {
                System.out.println("Token is expired.");
                EtsyTokenResponse tokenResponse = etsyDataService.refreshToken("refresh_token");

                System.out.println("Access Token: " + tokenResponse.getAccessToken());
                System.out.println("Refresh Token: " + tokenResponse.getRefreshToken());

                System.exit(1);
            }
        }
    }
}
