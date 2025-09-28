package com.noor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "OCCUPATION_DEPARTMENT")
public class OccupationDepartment extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "OCCUPATION_ID",updatable = false,insertable = false)
    private Occupation occupation;
    @Column(name = "OCCUPATION_ID")
    private Long occupationId;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID",updatable = false,insertable = false)
    private Department department;
    @Column(name = "DEPARTMENT_ID")
    private Long departmentID;

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public Long getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(Long occupationId) {
        this.occupationId = occupationId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Long departmentID) {
        this.departmentID = departmentID;
    }
}
