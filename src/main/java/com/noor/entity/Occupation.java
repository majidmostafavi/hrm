package com.noor.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.Objects;


@Entity

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
    @JoinColumn(name = "DEPARTMENT_ID")
    @ManyToOne
    private Department department;


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

    public Long getApprovedHeadcount() {
        return approvedHeadcount;
    }
    public void setApprovedHeadcount(Long approvedHeadcount) {
        this.approvedHeadcount = approvedHeadcount;
    }

    public Long getRegulatoryOvertime() {
        return regulatoryOvertime;
    }
    public void setRegulatoryOvertime(Long regulatoryOvertime) {
        this.regulatoryOvertime = regulatoryOvertime;
    }

    public Long getMandatoryShifts() {
        return mandatoryShifts;
    }
    public void setMandatoryShifts(Long mandatoryShifts) {
        this.mandatoryShifts = mandatoryShifts;
    }

    public Double getFactorOvertime() {
        return factorOvertime;
    }
    public void setFactorOvertime(Double factorOvertime) {
        this.factorOvertime = factorOvertime;
    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Occupation that = (Occupation) o;
        return Objects.equals(id,that.id) && Objects.equals(name, that.name) && Objects.equals(code, that.code) && Objects.equals(approvedHeadcount, that.approvedHeadcount) && Objects.equals(regulatoryOvertime, that.regulatoryOvertime) && Objects.equals(mandatoryShifts, that.mandatoryShifts) && Objects.equals(factorOvertime, that.factorOvertime) && Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name, code, approvedHeadcount, regulatoryOvertime, mandatoryShifts, factorOvertime, department);
    }
}
