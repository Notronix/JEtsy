package com.notronix.etsy.api;

import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;
import static org.apache.commons.lang3.StringUtils.trim;

public class EtsyException extends Exception
{
    private String error;
    private String errorDescription;

    public EtsyException(String message) {
        super(message);
    }

    public EtsyException(Throwable cause) {
        super(cause);
    }

    public EtsyException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getError() {
        return error;
    }

    public EtsyException withError(String error) {
        this.error = error;
        return this;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public EtsyException withErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
        return this;
    }

    public boolean isDueToExpiredToken() {
        return equalsIgnoreCase(trim(errorDescription), "access token is expired");
    }
}
