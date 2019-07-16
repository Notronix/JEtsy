package com.notronix.etsy.api.model;

import java.util.List;

public interface Taxonomy
{
    Long getId();
    Integer getLevel();
    String getName();
    String getParent();
    Long getParentId();
    String getPath();
    Long getCategoryId();
    List<? extends Taxonomy> getChildren();
    List<Long> getChildrenIds();
    List<Long> getFullPathTaxonomyIds();
}
