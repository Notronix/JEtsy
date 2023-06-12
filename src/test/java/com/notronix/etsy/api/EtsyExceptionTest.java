package com.notronix.etsy.api;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class EtsyExceptionTest
{
    @Test
    public void testIsDueToExpiredToken() {
        EtsyException ex = new EtsyException("test");
        assertFalse(ex.isDueToExpiredToken());

        ex.withError("test");
        ex.withErrorDescription("test");
        assertFalse(ex.isDueToExpiredToken());

        ex.withErrorDescription("access token is expired");
        assertTrue(ex.isDueToExpiredToken());
    }
}
