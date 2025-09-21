package com.noor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity

@Table(name = "MONTHS")
public class Month  extends PanacheEntity {
    @Column(name = "CODE")
    private Long code;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NUMBER_MONTH")
    private Long numberMonth;

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

    public Long getNumberMonth() {
        return numberMonth;
    }

    public void setNumberMonth(Long numberMonth) {
        this.numberMonth = numberMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return Objects.equals(code, month.code) && Objects.equals(name, month.name) && Objects.equals(numberMonth, month.numberMonth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, numberMonth);
    }
}
