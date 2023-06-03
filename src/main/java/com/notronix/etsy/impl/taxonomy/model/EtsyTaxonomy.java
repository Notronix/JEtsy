package com.notronix.etsy.impl.taxonomy.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.taxonomy.model.Taxonomy;

import java.util.List;

public class EtsyTaxonomy implements Taxonomy
{
    private Long id;
    private Integer level;
    private String name;

    @SerializedName("parent_id")
    private Long parentId;
    List<EtsyTaxonomy> children;

    @SerializedName("full_path_taxonomy_ids")
    List<Long> fullPathTaxonomyIds;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public List<EtsyTaxonomy> getChildren() {
        return children;
    }

    public void setChildren(List<EtsyTaxonomy> children) {
        this.children = children;
    }

    @Override
    public List<Long> getFullPathTaxonomyIds() {
        return fullPathTaxonomyIds;
    }

    public void setFullPathTaxonomyIds(List<Long> fullPathTaxonomyIds) {
        this.fullPathTaxonomyIds = fullPathTaxonomyIds;
    }
}
