package com.notronix.etsy.impl.v2.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class EtsyBooleanAdapter extends TypeAdapter<Boolean>
{
    @Override
    public void write(JsonWriter out, Boolean value) throws IOException {
        if (value == null) {
            out.nullValue();
        }
        else {
            out.value(value.toString());
        }
    }

    @Override
    public Boolean read(JsonReader in) throws IOException {
        JsonToken token = in.peek();

        if (token == JsonToken.NULL) {
            in.nextNull();
            return null;
        }

        if (token == JsonToken.BOOLEAN) {
            return in.nextBoolean();
        }

        if (token == JsonToken.NUMBER) {
            int value = in.nextInt();
            if (value == 0) {
                return false;
            }
            if (value == 1) {
                return true;
            }

            throw new IOException("Unable to parse number as Boolean. Value: " + value + ", Path: " + in.getPath());
        }

        if (token == JsonToken.STRING) {
            String value = in.nextString();
            if ("true".equalsIgnoreCase(value)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(value)) {
                return Boolean.FALSE;
            }

            throw new IOException("Unable to parse string as Boolean. Value: " + value + ", Path: " + in.getPath());
        }

        throw new IOException("Unable to parse Boolean. Path: " + in.getPath());
    }
}
