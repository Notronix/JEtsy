package com.notronix.etsy.api;

import static java.lang.Boolean.TRUE;

public class EtsyException extends Exception
{
    private Boolean dueToExpiredToken;

    public EtsyException(String message)
    {
        super(message);
    }

    public EtsyException(Throwable cause)
    {
        super(cause);
    }

    public EtsyException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public EtsyException dueToExpiredToken(boolean dueToExpiredToken) {
        this.dueToExpiredToken = dueToExpiredToken;
        return this;
    }

    public boolean isDueToExpiredToken() {
        return TRUE.equals(dueToExpiredToken);
    }
}
