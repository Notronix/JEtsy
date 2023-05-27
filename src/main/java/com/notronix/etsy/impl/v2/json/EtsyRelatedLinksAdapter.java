package com.notronix.etsy.impl.v2.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.notronix.etsy.impl.v2.model.shops.EtsyRelatedLink;
import com.notronix.etsy.impl.v2.model.shops.EtsyRelatedLinks;

import java.io.IOException;

public class EtsyRelatedLinksAdapter extends TypeAdapter<EtsyRelatedLinks>
{
    @Override
    public void write(JsonWriter out, EtsyRelatedLinks value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }

        out.beginArray();

        for (EtsyRelatedLink relatedLink : value) {
            out.beginObject();
            JsonAdapterUtils.outString(out, relatedLink.getTitle(), "title");
            JsonAdapterUtils.outString(out, relatedLink.getUrl(), "url");
            out.endObject();
        }

        out.endArray();
    }

    @Override
    public EtsyRelatedLinks read(JsonReader in) throws IOException {
        JsonToken token = in.peek();

        if (token == JsonToken.NULL) {
            in.nextNull();
            return null;
        }

        if (token == JsonToken.BEGIN_OBJECT) {
            EtsyRelatedLinks list = new EtsyRelatedLinks();
            list.add(buildEtsyRelatedLink(in));
            return list;
        }

        if (token == JsonToken.BEGIN_ARRAY) {
            EtsyRelatedLinks list = new EtsyRelatedLinks();
            in.beginArray();
            while (in.hasNext()) {
                list.add(buildEtsyRelatedLink(in));
            }
            in.endArray();
            return list;
        }

        return null;
    }

    private EtsyRelatedLink buildEtsyRelatedLink(JsonReader in) throws IOException {
        EtsyRelatedLink relatedLink = new EtsyRelatedLink();
        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "title":
                    relatedLink.setTitle(JsonAdapterUtils.nextString(in));
                    break;
                case "url":
                    relatedLink.setUrl(JsonAdapterUtils.nextString(in));
                    break;
                default:
                    in.skipValue();
            }
        }
        in.endObject();
        return relatedLink;
    }
}
