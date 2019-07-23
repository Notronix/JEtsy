package com.notronix.etsy.impl.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.notronix.etsy.impl.model.EtsyRelatedLink;
import com.notronix.etsy.impl.model.EtsyRelatedLinks;

import java.io.IOException;

import static com.notronix.etsy.impl.json.JsonAdapterUtils.*;

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
            outString(out, relatedLink.getTitle(), "title");
            outString(out, relatedLink.getUrl(), "url");
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
                    relatedLink.setTitle(nextString(in));
                    break;
                case "url":
                    relatedLink.setUrl(nextString(in));
                    break;
                default:
                    in.skipValue();
            }
        }
        in.endObject();
        return relatedLink;
    }
}
