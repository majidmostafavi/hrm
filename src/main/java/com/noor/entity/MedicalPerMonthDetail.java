package com.noor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "MEDICAL_PER_MONTH_DETAIL")

@NamedQueries({
        @NamedQuery(name = "sumServiceCategoryByYearOrganizationMonth",query = "select  new com.noor.dto.ServiceCategoryDTO(category.name,category.code,category.id,sum (detail.totalMedicalPerMonth)) from MedicalPerMonthDetail detail " +
                "inner join detail.service service inner join service.category category inner join detail.medicalPerMonthMaster master inner join master.month month " +
                "where master.yearID=: yearID and master.organizationID =: organizationID and master.monthID in :monthIDs " +
                "group by category.name,category.code,category.id  ")
})
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
    private Long totalMedicalPerMonth;


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

    public Long getTotalMedicalPerMonth() {
        return totalMedicalPerMonth;
    }
    public void setTotalMedicalPerMonth(Long totalMedicalPerMonth) {
        this.totalMedicalPerMonth = totalMedicalPerMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MedicalPerMonthDetail that = (MedicalPerMonthDetail) o;
        return id.equals(that.id) && totalMedicalPerMonth.equals( that.totalMedicalPerMonth ) && Objects.equals(serviceID, that.serviceID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceID, totalMedicalPerMonth);
    }
}
