package com.notronix.etsy.api;

import java.lang.reflect.Type;

public interface Unmarshaller
{
    <T> T unmarshal(String payload, Class<T> classOfT);
    <T> T unmarshal(String payload, Type typeOfT);
}
