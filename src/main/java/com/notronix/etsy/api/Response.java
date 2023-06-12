package com.notronix.etsy.api;

public interface Response<T>
{
    String REQUEST_UUID = "X-Etsy-Request-Uuid";
    String LIMIT_PER_SECOND = "X-Limit-Per-Second";
    String REMAINING_THIS_SECOND = "X-Remaining-This-Second";
    String LIMIT_PER_DAY = "X-Limit-Per-Day";
    String REMAINING_THIS_DAY = "X-Remaining-Today";

    String getRequestUUID();
    Integer getLimitPerSecond();
    Integer getLimitPerDay();
    Integer getCallsRemainingThisDay();
    Integer getCallsRemainingThisSecond();
    T getContent();
}
