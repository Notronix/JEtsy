package com.notronix.etsy.api;

public class EtsyAPIException extends Exception
{
    public EtsyAPIException(String message)
    {
        super(message);
    }

    public EtsyAPIException(Throwable cause)
    {
        super(cause);
    }

    public EtsyAPIException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
