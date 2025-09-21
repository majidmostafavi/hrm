package com.noor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "YEARS")
public class Year extends PanacheEntity {
    @Column(name = "CODE")
    private Long code;
    @Column(name = "NAME")
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Year year = (Year) o;
        return Objects.equals(code, year.code) && Objects.equals(name, year.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }
}
