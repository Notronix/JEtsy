package com.notronix.etsy.impl;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.notronix.albacore.ContainerUtils.numberOf;
import static com.notronix.etsy.impl.EtsyMethodUtils.*;
import static org.junit.Assert.assertEquals;

public class EtsyMethodUtilsTest
{
    @Test
    public void testPutIfProvided() {
        Map<String, Object> params = new HashMap<>();
        putIfProvided(params, "key", "value");
        assertEquals("Simple parameter was not stored", "value", params.get("key"));

        params.clear();
        putIfProvided(params, "key", "value", Objects::nonNull, false);
        assertEquals("Valid value was not stored.", "value", params.get("key"));

        params.clear();
        putIfProvided(params, "key", Integer.MAX_VALUE, i -> i > 0, true);
        assertEquals("Valid value was not stored.", Integer.MAX_VALUE, params.get("key"));

        params.clear();
        putIfProvided(params, "key", Integer.MAX_VALUE, i -> i < 10, false);
        assertEquals("Value should not have been stored.", numberOf(params), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutIfProvidedInvalid() {
        Map<String, Object> params = new HashMap<>();
        putIfProvided(params, "key", Integer.MAX_VALUE, i -> i < 10, true);
    }

    @Test
    public void testGetDelimiter() {
        String url = "index.html";
        assertEquals("Wrong delimiter returned.", '?', getDelimiter(url));
    }

    @Test
    public void testAdd() {
        String url = add("/resource", "limit", 10);
        assertEquals("parameters not added correctly.", "/resource?limit=10", url);

        url = add(url, "offset", 5);
        assertEquals("parameters not added correctly.", "/resource?limit=10&offset=5", url);

        url = add(url, "last", 10, i -> Integer.toString(i + 10));
        assertEquals("converter not used correctly.", "/resource?limit=10&offset=5&last=20", url);
    }
}
