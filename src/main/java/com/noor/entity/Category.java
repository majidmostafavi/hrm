package com.noor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "CATEGORY")
public class Category extends PanacheEntity {

    @Column(name = "NAME")
    public String name;
    @Column(name = "CODE")
    public Long code;
    @Column(name = "DESCRIPTION")
    public String description;
}
