package com.noor.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;


@Entity
public class Occupation   extends PanacheEntity {
    public String name;
    private Long code;
}
