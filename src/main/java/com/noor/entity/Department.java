package com.noor.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.noor.enumration.DepartmentType;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "DEPARTMENTS")
public class Department  extends PanacheEntity {

    @Column(name = "NAME")
    @JsonProperty("name")
    private String name;
    @Column(name = "CODE")
    @JsonProperty("code")
    private Long code;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "DEPARTMENT_TYPE")
    @JsonProperty("departmentType")
    private DepartmentType departmentType;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;


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

    public DepartmentType getDepartmentType() {
        return departmentType;
    }
    public void setDepartmentType(DepartmentType departmentType) {
        this.departmentType = departmentType;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) && Objects.equals(code, that.code) && departmentType == that.departmentType && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, departmentType, category);
    }
}
