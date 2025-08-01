package com.noor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SERVICES")
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

}
