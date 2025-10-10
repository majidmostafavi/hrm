package com.noor.entity;

import com.noor.enumration.CategoryType;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "CATEGORY")
public class Category extends PanacheEntity {

    @Column(name = "NAME")
    public String name;
    @Column(name = "CODE")
    public Long code;
    @Column(name = "DESCRIPTION")
    public String description;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "CATEGORY_TYPE")
    public CategoryType categoryType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) && Objects.equals(code, category.code) && Objects.equals(description, category.description) && categoryType == category.categoryType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, description, categoryType);
    }
}
