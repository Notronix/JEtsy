package com.notronix.etsy.impl.method;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.notronix.albacore.ContainerUtils.thereAreNo;
import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

@SuppressWarnings("WeakerAccess")
public abstract class MethodUtils
{
    @SafeVarargs
    public static <T> List<T> safeList(T... list) {
        return list == null ? null : (list.length > 0 ? asList(list) : null);
    }

    public static char getDelimiter(String uri) {
        return (uri != null && uri.contains("?")) ? '&' : '?';
    }

    public static String add(String uri, String key, Object value) {
        return add(uri, key, value, null);
    }

    public static <T> String add(String uri, String key, T value, Function<T, String> converter) {
        requireNonNull(key);
        requireNonNull(value);
        String convertedValue = (converter == null ? value.toString() : converter.apply(value));
        String result = (uri == null ? "" : uri);

        return result + getDelimiter(result) + key + "=" + convertedValue;
    }

    public static <T> String addIfProvided(String uri, String key, T value, Function<T, String> converter) {
        return (value == null) ? uri : add(uri, key, value, converter);
    }

    public static String addIfProvided(String uri, String key, Object value) {
        return (value == null) ? uri : add(uri, key, value, null);
    }

    public static void putIfProvided(Map<String, Object> parameters, String key, Object value) {
        if (value == null) {
            return;
        }

        if (value instanceof CharSequence && isBlank((CharSequence) value)) {
            return;
        }

        if ((value instanceof Collection) && thereAreNo((Collection<?>) value)) {
            return;
        }

        if (value instanceof Map && thereAreNo((Map<?, ?>) value)) {
            return;
        }

        parameters.put(key, value);
    }
}
