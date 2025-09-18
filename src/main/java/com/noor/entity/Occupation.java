package com.noor.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "OCCUPATIONS")
public class Occupation   extends PanacheEntity {
    @Column(name = "NAME")
    public String name;
    @Column(name = "CODE")
    private Long code;
    @Column(name = "APPROVED_HEADCOUNT")
    private Long approvedHeadcount;
    @Column(name = "REGULATORY_OVERTIME")
    private Long regulatoryOvertime;
    @Column(name = "MANDATORY_SHIFTS")
    private Long mandatoryShifts;
    @Column(name = "FACTOR_OVERTIME")
    private Double factorOvertime ;

}
