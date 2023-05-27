package com.notronix.etsy.impl.v2.json;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

abstract class JsonAdapterUtils
{
    static String nextString(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }

        return in.nextString();
    }

    static Long nextLong(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }

        return in.nextLong();
    }

    static Integer nextInt(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }

        return in.nextInt();
    }

    static Boolean nextBoolean(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }

        return in.nextBoolean();
    }

    private static boolean nullNotHandled(JsonWriter out, Object value, String name) throws IOException {
        if (value == null && !out.getSerializeNulls()) {
            return false;
        }

        out.name(name);
        if (value == null) {
            out.nullValue();
            return false;
        }

        return true;
    }

    static void outString(JsonWriter out, String value, String name) throws IOException {
        if (nullNotHandled(out, value, name)) {
            out.value(value);
        }
    }

    static void outLong(JsonWriter out, Long value, String name) throws IOException {
        if (nullNotHandled(out, value, name)) {
            out.value(value);
        }
    }

    static void outBoolean(JsonWriter out, Boolean value, String name) throws IOException {
        if (nullNotHandled(out, value, name)) {
            out.value(value);
        }
    }
}
