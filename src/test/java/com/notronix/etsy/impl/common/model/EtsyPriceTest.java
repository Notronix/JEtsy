package com.notronix.etsy.impl.common.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class EtsyPriceTest
{
    @Test
    public void testPrice() {
        EtsyPrice price = new EtsyPrice();
        assertNull(price.getAmount());
        assertNull(price.getDivisor());
        assertNull(price.getCurrencyCode());
        assertNull(price.asFloat());

        price.setCurrencyCode("CAD");
        assertNull(price.getAmount());
        assertNull(price.getDivisor());
        assertEquals("CAD", price.getCurrencyCode());
        assertNull(price.asFloat());

        price.setDivisor(7);
        price.setCurrencyCode(null);
        assertNull(price.getAmount());
        assertEquals(7, price.getDivisor(), 0.0001);
        assertNull(price.getCurrencyCode());
        assertNull(price.asFloat());

        price.setAmount(13);
        price.setDivisor(null);
        assertEquals(13, price.getAmount(), 0.0001);
        assertNull(price.getDivisor());
        assertNull(price.getCurrencyCode());
        assertNull(price.asFloat());

        price.setDivisor(7);
        assertEquals(13, price.getAmount(), 0.0001);
        assertEquals(7, price.getDivisor(), 0.0001);
        assertNull(price.getCurrencyCode());
        assertEquals(1.86, price.asFloat(), 0.0001);
    }
}
