package com.noor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
@Entity
@Table(name = "PERSONNEL_ATTENDANCE_MASTER")
public class PersonnelAttendanceMaster extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "ORGANIZATION_ID" ,updatable = false,insertable = false)
    private Organization organization;
    @Column(name = "ORGANIZATION_ID")
    private Long organizationID;

    @ManyToOne
    @JoinColumn(name = "MONTH_ID",updatable = false,insertable = false)
    private Month month;
    @Column(name = "MONTH_ID")
    private Long monthID;

    @ManyToOne
    @JoinColumn(name = "YEAR_ID",updatable = false,insertable = false)
    private Year year;
    @Column(name = "YEAR_ID")
    private Long yearID;

    @OneToMany(orphanRemoval = true,mappedBy = "personnelAttendanceMaster")
    private Set<PersonnelAttendanceDetail> personnelAttendanceDetails;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Long getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(Long organizationID) {
        this.organizationID = organizationID;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Long getMonthID() {
        return monthID;
    }

    public void setMonthID(Long monthID) {
        this.monthID = monthID;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Long getYearID() {
        return yearID;
    }

    public void setYearID(Long yearID) {
        this.yearID = yearID;
    }

    public Set<PersonnelAttendanceDetail> getPersonnelAttendanceDetails() {
        return personnelAttendanceDetails;
    }
    public void setPersonnelAttendanceDetails(Set<PersonnelAttendanceDetail> personnelAttendanceDetails) {
        this.personnelAttendanceDetails = personnelAttendanceDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonnelAttendanceMaster that = (PersonnelAttendanceMaster) o;
        return Objects.equals(organizationID, that.organizationID) && Objects.equals(monthID, that.monthID) && Objects.equals(yearID, that.yearID) && Objects.equals(personnelAttendanceDetails, that.personnelAttendanceDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationID, monthID, yearID, personnelAttendanceDetails);
    }
}
