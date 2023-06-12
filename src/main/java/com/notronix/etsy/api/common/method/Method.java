package com.notronix.etsy.api.common.method;

import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;

public interface Method<B, C>
{
    String getURL();
    B buildResponseBody(Unmarshaller unmarshaller, String payload);
    String getRequestMethod();
    C buildRequestContent(Marshaller marshaller);
}
