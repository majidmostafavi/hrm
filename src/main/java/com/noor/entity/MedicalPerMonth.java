package com.noor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int yearId;
    @ManyToOne
    @JoinColumn(name = "MONTH_ID", insertable = false, updatable = false)
    private Month month;
    @Column(name = "MONTH_ID")
    private int monthId;
    @ManyToOne
    @JoinColumn(name = "ORGANIZATION_ID", insertable = false, updatable = false)
    private Organization organization;
    @Column(name = "ORGANIZATION_ID")
    private int organizationId;
    @ManyToOne
    @JoinColumn(name="SERVICE_ID",insertable = false,updatable = false)
    private Service service;
    @Column(name="SERVICE_ID")
    private Long serviceId;
    @Column(name = "TOTAL_MEDICAL_PER_MONTH")
    private int totalMedicalPerMonth;
}
