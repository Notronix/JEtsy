package com.notronix.etsy.impl.v2.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.notronix.etsy.api.v2.model.listings.ListingState;

import java.io.IOException;

public class ListingStateAdapter extends TypeAdapter<ListingState>
{
    @Override
    public void write(JsonWriter out, ListingState value) throws IOException {
        out.value(value.apiValue());
    }

    @Override
    public ListingState read(JsonReader in) throws IOException {
        JsonToken token = in.peek();
        if (token == JsonToken.STRING) {
            return ListingState.forValue(in.nextString());
        }

        throw new IOException("Expected STRING but was " + token.name() + ". Path: " + in.getPath());
    }
}
