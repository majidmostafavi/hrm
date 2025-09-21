package com.noor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "ORGANIZATIONS")
public class Organization extends PanacheEntity {

    @Column(name = "NAME")
    private String name;
    @Column(name = "CODE")
    private Long code;
    @Column(name = "BASIS")
    private Boolean basis;

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

    public Boolean getBasis() {
        return basis;
    }

    public void setBasis(Boolean basis) {
        this.basis = basis;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(name, that.name) && Objects.equals(code, that.code) && Objects.equals(basis, that.basis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, basis);
    }
}
