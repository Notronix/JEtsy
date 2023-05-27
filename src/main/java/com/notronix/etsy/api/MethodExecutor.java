package com.notronix.etsy.api;

public interface MethodExecutor<Content>
{
    <Response> Response execute(Method<Response, Content> method) throws EtsyException;
}
