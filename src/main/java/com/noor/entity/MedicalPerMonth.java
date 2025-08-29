package com.noor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Entity
@Table(name = "MEDICAL_PER_MONTH")
@NoArgsConstructor
@AllArgsConstructor
public class MedicalPerMonth  extends PanacheEntity {
    @JoinColumn(name = "YEAR_ID",insertable = false,updatable = false)
    @ManyToOne
    private Year year;
    @Column(name = "YEAR_ID")
    private Long yearID;
    @ManyToOne
    @JoinColumn(name = "MONTH_ID", insertable = false, updatable = false)
    private Month month;
    @Column(name = "MONTH_ID")
    private Long monthID;
    @ManyToOne
    @JoinColumn(name = "ORGANIZATION_ID", insertable = false, updatable = false)
    private Organization organization;
    @Column(name = "ORGANIZATION_ID")
    private Long organizationID;
    @ManyToOne
    @JoinColumn(name="SERVICE_ID",insertable = false,updatable = false)
    private Service service;
    @Column(name="SERVICE_ID")
    private Long serviceID;
    @Column(name = "TOTAL_MEDICAL_PER_MONTH")
    private int totalMedicalPerMonth;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MedicalPerMonth that = (MedicalPerMonth) o;
        return  Objects.equals( id ,that.id) && Objects.equals(yearID, that.yearID) && Objects.equals( monthID , that.monthID )&& Objects.equals(organizationID, that.organizationID) && totalMedicalPerMonth == that.totalMedicalPerMonth && Objects.equals(serviceID, that.serviceID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,yearID, monthID, organizationID, serviceID, totalMedicalPerMonth);
    }
}
