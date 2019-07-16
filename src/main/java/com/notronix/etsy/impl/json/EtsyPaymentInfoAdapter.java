package com.notronix.etsy.impl.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.notronix.etsy.impl.model.EtsyPaymentInfo;
import com.notronix.etsy.impl.model.EtsyPaymentTemplate;

import java.io.IOException;

import static com.notronix.etsy.impl.json.JsonAdapterUtils.*;

public class EtsyPaymentInfoAdapter extends TypeAdapter<EtsyPaymentInfo>
{
    @Override
    public void write(JsonWriter out, EtsyPaymentInfo value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }

        out.beginArray();

        for (EtsyPaymentTemplate template : value) {
            out.beginObject();

            outLong(out, template.getPaymentTemplateId(), "payment_template_id");
            outBoolean(out, template.getAllowBt(), "allow_bt");
            outBoolean(out, template.getAllowCheck(), "allow_check");
            outBoolean(out, template.getAllowMo(), "allow_mo");
            outBoolean(out, template.getAllowOther(), "allow_other");
            outBoolean(out, template.getAllowPayPal(), "allow_paypal");
            outBoolean(out, template.getAllowCc(), "allow_cc");
            outString(out, template.getPayPalEmail(), "paypal_email");
            outString(out, template.getName(), "name");
            outString(out, template.getFirstLine(), "first_line");
            outString(out, template.getSecondLine(), "second_line");
            outString(out, template.getCity(), "city");
            outString(out, template.getState(), "state");
            outString(out, template.getZip(), "zip");
            outLong(out, template.getCountryId(), "country_id");
            outLong(out, template.getUserId(), "user_id");
            outLong(out, template.getListingPaymentId(), "listing_payment_id");

            out.endObject();
        }

        out.endArray();
    }

    @Override
    public EtsyPaymentInfo read(JsonReader in) throws IOException {
        JsonToken token = in.peek();

        if (token == JsonToken.NULL) {
            in.nextNull();
            return null;
        }

        if (token == JsonToken.BEGIN_OBJECT) {
            EtsyPaymentInfo list = new EtsyPaymentInfo();
            list.add(buildEtsyPaymentTemplate(in));
            return list;
        }

        if (token == JsonToken.BEGIN_ARRAY) {
            EtsyPaymentInfo list = new EtsyPaymentInfo();
            in.beginArray();
            while (in.hasNext()) {
                list.add(buildEtsyPaymentTemplate(in));
            }
            in.endArray();
            return list;
        }

        return null;
    }

    private boolean handledNull(JsonWriter out, Object value, String name) throws IOException {
        if (value == null && !out.getSerializeNulls()) {
            return true;
        }

        out.name(name);
        if (value == null) {
            out.nullValue();
            return true;
        }

        return false;
    }

    private void outString(JsonWriter out, String value, String name) throws IOException {
        if (!handledNull(out, value, name)) {
            out.value(value);
        }
    }

    private void outLong(JsonWriter out, Long value, String name) throws IOException {
        if (!handledNull(out, value, name)) {
            out.value(value);
        }
    }

    private void outBoolean(JsonWriter out, Boolean value, String name) throws IOException {
        if (!handledNull(out, value, name)) {
            out.value(value);
        }
    }

    private EtsyPaymentTemplate buildEtsyPaymentTemplate(JsonReader in) throws IOException {
        EtsyPaymentTemplate template = new EtsyPaymentTemplate();
        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "payment_template_id":
                    template.setPaymentTemplateId(nextLong(in));
                    break;
                case "allow_bt":
                    template.setAllowBt(nextBoolean(in));
                    break;
                case "allow_check":
                    template.setAllowCheck(nextBoolean(in));
                    break;
                case "allow_mo":
                    template.setAllowMo(nextBoolean(in));
                    break;
                case "allow_other":
                    template.setAllowOther(nextBoolean(in));
                    break;
                case "allow_paypal":
                    template.setAllowPayPal(nextBoolean(in));
                    break;
                case "allow_cc":
                    template.setAllowCc(nextBoolean(in));
                    break;
                case "paypal_email":
                    template.setPayPalEmail(nextString(in));
                    break;
                case "name":
                    template.setName(nextString(in));
                    break;
                case "first_line":
                    template.setFirstLine(nextString(in));
                    break;
                case "second_line":
                    template.setSecondLine(nextString(in));
                    break;
                case "city":
                    template.setCity(nextString(in));
                    break;
                case "state":
                    template.setState(nextString(in));
                    break;
                case "zip":
                    template.setZip(nextString(in));
                    break;
                case "country_id":
                    template.setCountryId(nextLong(in));
                    break;
                case "user_id":
                    template.setUserId(nextLong(in));
                    break;
                case "listing_payment_id":
                    template.setListingPaymentId(nextLong(in));
                    break;
                default:
                    in.skipValue();
            }
        }
        in.endObject();
        return template;
    }
}
