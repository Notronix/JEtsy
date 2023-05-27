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

        ex.dueToExpiredToken(false);
        assertFalse(ex.isDueToExpiredToken());

        ex.dueToExpiredToken(true);
        assertTrue(ex.isDueToExpiredToken());
    }
}
