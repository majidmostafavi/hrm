package com.noor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "MEDICAL_PER_MONTH_DETAIL")
public class MedicalPerMonthDetail extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name="MASTER_ID")
    @JsonIgnore
    private MedicalPerMonthMaster medicalPerMonthMaster;

    @Column(name = "MASTER_ID",insertable = false,updatable = false)
    private Long masterID;

    @ManyToOne
    @JoinColumn(name="SERVICE_ID",insertable = false,updatable = false)
    private Service service;

    @Column(name="SERVICE_ID")
    private Long serviceID;

    @Column(name = "TOTAL_MEDICAL_PER_MONTH")
    private int totalMedicalPerMonth;


    public MedicalPerMonthMaster getMedicalPerMonthMaster() {
        return medicalPerMonthMaster;
    }
    public void setMedicalPerMonthMaster(MedicalPerMonthMaster medicalPerMonthMaster) {
        this.medicalPerMonthMaster = medicalPerMonthMaster;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Long getServiceID() {
        return serviceID;
    }

    public void setServiceID(Long serviceID) {
        this.serviceID = serviceID;
    }

    public int getTotalMedicalPerMonth() {
        return totalMedicalPerMonth;
    }

    public void setTotalMedicalPerMonth(int totalMedicalPerMonth) {
        this.totalMedicalPerMonth = totalMedicalPerMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MedicalPerMonthDetail that = (MedicalPerMonthDetail) o;
        return id.equals(that.id) && totalMedicalPerMonth == that.totalMedicalPerMonth  && Objects.equals(serviceID, that.serviceID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceID, totalMedicalPerMonth);
    }
}
