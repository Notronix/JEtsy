package com.notronix.etsy.api.shops.model;

import java.util.Arrays;
import java.util.Objects;

public enum ShippingUpgradeType
{
    domestic("0"),
    international("1");

    private final String apiValue;

    ShippingUpgradeType() {
        apiValue = this.name();
    }

    ShippingUpgradeType(String apiValue) {
        this.apiValue = apiValue;
    }

    public static ShippingUpgradeType forApiValue(String apiValue) {
        ShippingUpgradeType type = Arrays.stream(ShippingUpgradeType.values())
                .filter(t -> Objects.equals(t.apiValue, apiValue))
                .findFirst().orElse(null);

        if (type == null) {
            throw new IllegalArgumentException("invalid apiValue");
        }

        return type;
    }

    public static ShippingUpgradeType forValue(String value) {
        try {
            return ShippingUpgradeType.valueOf(value);
        }
        catch (Exception ex) {
            return forApiValue(value);
        }
    }
}
