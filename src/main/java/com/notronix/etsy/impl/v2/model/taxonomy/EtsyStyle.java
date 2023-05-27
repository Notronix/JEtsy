package com.notronix.etsy.impl.v2.model.taxonomy;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.v2.model.taxonomy.Style;

public class EtsyStyle implements Style
{
    @SerializedName(value = "style_id")
    private Long styleId;
    private String style;

    @Override
    public Long getStyleId() {
        return styleId;
    }

    public void setStyleId(Long styleId) {
        this.styleId = styleId;
    }

    @Override
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
