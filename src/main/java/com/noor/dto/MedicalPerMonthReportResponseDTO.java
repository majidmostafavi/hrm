package com.noor.dto;

import java.io.Serializable;
import java.util.List;

public class MedicalPerMonthReportResponseDTO implements Serializable {

    Long monthID;
    String monthName;
    Long yearID;
    String yearName;
    Long organizationID;
    String organizationName;
    int totalPerson;
    int totalOverTime;
    List<MedicalPerMonthDTO> medicalPerMonthDTOList;

    public MedicalPerMonthReportResponseDTO(Long monthID, String monthName, Long yearID, String yearName, Long organizationID, String organizationName, int totalPerson, int totalOverTime, List<MedicalPerMonthDTO> medicalPerMonthDTOList) {
        this.monthID = monthID;
        this.monthName = monthName;
        this.yearID = yearID;
        this.yearName = yearName;
        this.organizationID = organizationID;
        this.organizationName = organizationName;
        this.totalPerson = totalPerson;
        this.totalOverTime = totalOverTime;
        this.medicalPerMonthDTOList = medicalPerMonthDTOList;
    }

    public Long getMonthID() {
        return monthID;
    }

    public void setMonthID(Long monthID) {
        this.monthID = monthID;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public Long getYearID() {
        return yearID;
    }

    public void setYearID(Long yearID) {
        this.yearID = yearID;
    }

    public String getYearName() {
        return yearName;
    }

    public void setYearName(String yearName) {
        this.yearName = yearName;
    }

    public Long getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(Long organizationID) {
        this.organizationID = organizationID;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public int getTotalPerson() {
        return totalPerson;
    }

    public void setTotalPerson(int totalPerson) {
        this.totalPerson = totalPerson;
    }

    public int getTotalOverTime() {
        return totalOverTime;
    }

    public void setTotalOverTime(int totalOverTime) {
        this.totalOverTime = totalOverTime;
    }

    public List<MedicalPerMonthDTO> getMedicalPerMonthDTOList() {
        return medicalPerMonthDTOList;
    }

    public void setMedicalPerMonthDTOList(List<MedicalPerMonthDTO> medicalPerMonthDTOList) {
        this.medicalPerMonthDTOList = medicalPerMonthDTOList;
    }
}
