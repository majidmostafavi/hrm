package com.noor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Year extends PanacheEntity {
    private Long code;
    private String name;
}
