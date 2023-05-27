package com.notronix.etsy.impl.v2.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.Instant;

public class InstantAdapter extends TypeAdapter<Instant>
{
    @Override
    public void write(JsonWriter out, Instant value) throws IOException {
        out.value(Math.floor((double) value.toEpochMilli() / 1000d));
    }

    @Override
    public Instant read(JsonReader in) throws IOException {
        JsonToken token = in.peek();

        if (token == JsonToken.NUMBER) {
            return Instant.ofEpochMilli(in.nextLong() * 1000);
        }

        throw new IOException();
    }
}
