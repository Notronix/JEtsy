package com.notronix.etsy.api;

import com.notronix.etsy.api.authentication.model.Credentials;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CredentialsTest
{
    @Test
    public void testForKeyPair() {
        Credentials creds = Credentials.forKeyPair("token", "secret");
        assertEquals("token", creds.getToken());
        assertEquals("secret", creds.getTokenSecret());
        assertNull(creds.getLoginUrl());
        assertNull(creds.getCallbackConfirmed());
    }
}
