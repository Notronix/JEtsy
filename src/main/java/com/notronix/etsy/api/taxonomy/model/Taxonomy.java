package com.notronix.etsy.api.taxonomy.model;

import java.util.List;

public interface Taxonomy
{
    Long getId();
    Integer getLevel();
    String getName();
    Long getParentId();
    List<? extends Taxonomy> getChildren();
    List<Long> getFullPathTaxonomyIds();
}
