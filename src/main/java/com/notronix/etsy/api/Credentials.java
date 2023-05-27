package com.notronix.etsy.api;

public interface Credentials
{
    String getToken();
    String getTokenSecret();
    String getLoginUrl();
    Boolean getCallbackConfirmed();

    static Credentials forKeyPair(final String token, final String secret) {
        return new Credentials()
        {
            @Override
            public String getToken() {
                return token;
            }

            @Override
            public String getTokenSecret() {
                return secret;
            }

            @Override
            public String getLoginUrl() {
                return null;
            }

            @Override
            public Boolean getCallbackConfirmed() {
                return null;
            }
        };
    }
}
