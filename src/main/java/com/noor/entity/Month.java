package com.noor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MONTHS")
public class Month  extends PanacheEntity {
    @Column(name = "CODE")
    private Long code;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NUMBER_MONTH")
    private Long numberMonth;
}
