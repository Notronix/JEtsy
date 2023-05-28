package com.notronix.etsy.impl.v2.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.notronix.etsy.impl.v2.model.listings.EtsyMoney;

import java.io.IOException;

import static com.notronix.etsy.impl.v2.json.JsonAdapterUtils.*;

public class EtsyMoneyAdapter extends TypeAdapter<EtsyMoney>
{
    @Override
    public void write(JsonWriter out, EtsyMoney value) throws IOException {
        if (value == null || value.getAmount() == null || value.getDivisor() == null) {
            if (out.getSerializeNulls()) {
                out.nullValue();
            }
            return;
        }

        Long amount = value.getAmount();
        Integer divisor = value.getDivisor();

        double price = amount.doubleValue() / divisor.doubleValue();
        out.value(String.valueOf(price));
    }

    @Override
    public EtsyMoney read(JsonReader in) throws IOException {
        JsonToken token = in.peek();

        if (token == JsonToken.NULL) {
            in.nextNull();
            return null;
        }

        if (token == JsonToken.BEGIN_OBJECT) {
            return buildEtsyMoney(in);
        }

        return null;
    }

    private EtsyMoney buildEtsyMoney(JsonReader in) throws IOException {
        EtsyMoney money = new EtsyMoney();
        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "amount":
                    money.setAmount(nextLong(in));
                    break;
                case "divisor":
                    money.setDivisor(nextInt(in));
                    break;
                case "currency_code":
                    money.setCurrencyCode(nextString(in));
                    break;
                case "currency_formatted_raw":
                    money.setCurrencyFormattedRaw(nextString(in));
                    break;
                case "currency_formatted_short":
                    money.setCurrencyFormattedShort(nextString(in));
                    break;
                case "currency_formatted_long":
                    money.setCurrencyFormattedLong(nextString(in));
                    break;
                case "original_currency_code":
                    money.setOriginalCurrencyCode(nextString(in));
                    break;
                case "before_conversion":
                    JsonToken token = in.peek();
                    if (token == JsonToken.BEGIN_OBJECT) {
                        money.setBeforeConversion(buildEtsyMoney(in));
                        break;
                    }
                default:
                    in.skipValue();
            }
        }
        in.endObject();
        return money;
    }
}
