package com.notronix.etsy.impl.model;

import com.notronix.etsy.api.model.RelatedLink;

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
