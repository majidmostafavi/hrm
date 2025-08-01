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
@Table(name = "ORGANIZATIONS")
public class Organization extends PanacheEntity {

    @Column(name = "NAME")
    private String name;
    @Column(name = "CODE")
    private Long code;
    @Column(name = "BASIS")
    private Boolean basis;

}
