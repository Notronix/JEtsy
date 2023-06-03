package com.notronix.etsy.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.notronix.albacore.ContainerUtils.thereAreNo;
import static com.notronix.albacore.ContainerUtils.thereAreOneOrMore;
import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toSet;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.join;

@SuppressWarnings("WeakerAccess")
public abstract class EtsyMethodUtils
{
    protected static final Function<List<Enum<?>>, String> INCLUDES_CONVERTER = list -> {
        Set<String> includes = list.stream().map(Enum::name).collect(toSet());
        return thereAreOneOrMore(includes) ? join(includes, ",") : "";
    };

    @SafeVarargs
    public static <T> List<T> safeList(T... list) {
        return list == null ? null : (list.length > 0 ? asList(list) : null);
    }

    public static char getDelimiter(String uri) {
        return (uri != null && uri.contains("?")) ? '&' : '?';
    }

    //TODO: All of these add methods should work with a StringBuilder object... and return void.
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

    public static <T> String addIfProvided(String uri, String key, T value, Predicate<T> validator,
                                           boolean throwWhenInvalid) throws IllegalArgumentException {
        if (validator == null) {
            return addIfProvided(uri, key, value);
        }

        if (validator.test(value)) {
            return addIfProvided(uri, key, value);
        }
        else if (throwWhenInvalid) {
            throw new IllegalArgumentException(key);
        }

        return uri;
    }

    public static <T> void putIfProvided(Map<String, Object> parameters, String key, T value,
                                         Predicate<T> validator, boolean throwWhenInvalid)
            throws IllegalArgumentException {
        if (validator == null) {
            putIfProvided(parameters, key, value);
            return;
        }

        if (validator.test(value)) {
            putIfProvided(parameters, key, value);
        }
        else if (throwWhenInvalid) {
            throw new IllegalArgumentException(key);
        }
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

    public static String addIncludes(String uri, Enum<?>[] includes) {
        return addIfProvided(uri, "includes", safeList(includes), INCLUDES_CONVERTER);
    }
}
