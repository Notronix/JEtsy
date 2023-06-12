package com.notronix.etsy.api.common.method;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface EtsyParameter
{
    ParameterPosition position() default ParameterPosition.BODY;

    boolean nullable() default true;
}
