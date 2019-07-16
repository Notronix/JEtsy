package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.Taxonomy;

import java.util.List;

public class EtsyTaxonomy implements Taxonomy
{
    private Long id;
    private Integer level;
    private String name;
    private String parent;

    @SerializedName(value = "parent_id")
    private Long parentId;
    private String path;

    @SerializedName(value = "category_id")
    private Long categoryId;

    private List<EtsyTaxonomy> children;

    @SerializedName(value = "children_ids")
    private List<Long> childrenIds;

    @SerializedName(value = "full_path_taxonomy_ids")
    private List<Long> fullPathTaxonomyIds;

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
    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Override
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public List<EtsyTaxonomy> getChildren() {
        return children;
    }

    public void setChildren(List<EtsyTaxonomy> children) {
        this.children = children;
    }

    @Override
    public List<Long> getChildrenIds() {
        return childrenIds;
    }

    public void setChildrenIds(List<Long> childrenIds) {
        this.childrenIds = childrenIds;
    }

    @Override
    public List<Long> getFullPathTaxonomyIds() {
        return fullPathTaxonomyIds;
    }

    public void setFullPathTaxonomyIds(List<Long> fullPathTaxonomyIds) {
        this.fullPathTaxonomyIds = fullPathTaxonomyIds;
    }
}
