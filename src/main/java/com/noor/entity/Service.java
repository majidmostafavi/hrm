package com.noor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.Objects;


@Entity

@Table(name = "SERVICES")

@NamedQueries({
        @NamedQuery(name = "findLeafService", query = "select  service from Service  service where service.leaf = true order by code asc " )
})
public class Service extends PanacheEntity {

    @Column(name = "CODE")
    private Long code;
    @Column(name = "NAME")
    private String name;
    @ManyToOne
    @JoinColumn(name = "PARENT_ID",insertable = false,updatable = false)
    private Service parent;
    @Column(name = "PARENT_ID")
    private Long parentId;
    @Column(name = "DESCRIPTION")
    private String description;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID",insertable = false,updatable = false)
    private Category category;
    @Column(name = "CATEGORY_ID")
    private Long categoryId;
    @Column(name = "LEAF")
    private boolean leaf;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Service getParent() {
        return parent;
    }

    public void setParent(Service parent) {
        this.parent = parent;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(code, service.code) && Objects.equals(name, service.name) && Objects.equals(parentId, service.parentId) && Objects.equals(description, service.description) && Objects.equals(categoryId, service.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, parentId, description, categoryId);
    }
}
