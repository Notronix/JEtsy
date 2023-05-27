package com.notronix.etsy.impl.v2.model.shops;

import com.notronix.etsy.api.v2.model.shops.RelatedLink;

public class EtsyRelatedLink implements RelatedLink
{
    private String title;
    private String url;

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
