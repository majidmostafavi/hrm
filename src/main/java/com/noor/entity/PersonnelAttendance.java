package com.noor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity



@Table(name = "PERSONNEL_ATTENDANCE")
public class PersonnelAttendance extends PanacheEntity {

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

    @ManyToOne
    @JoinColumn(name = "OCCUPATION_ID",updatable = false,insertable = false)
    private Occupation occupation;
    @Column(name = "OCCUPATION_ID")
    private Long occupationId;

    @Column(name = "TOTAL_DAYS_WORKED")
    private Long totalDaysWorked;
    @Column(name = "TOTAL_HOURS_WORKED")
    private Long totalHoursWorked;
    @Column(name = "TOTAL_MINUTES_WORKED")
    private Long totalMinutesWorked;
    @Column(name = "TOTAL_WORKED")
    private Long totalWorked;

    @Column(name = "OVERTIME_DAYS_WORKED")
    private Long overtimeDaysWorked;
    @Column(name = "OVERTIME_HOURS_WORKED")
    private Long overtimeHoursWorked;
    @Column(name = "OVERTIME_MINUTES_WORKED")
    private Long overtimeMinutesWorked;
    @Column(name = "OVERTIME_TOTAL_WORKED")
    private Long overtimeTotalWorked;

    @Column(name = "TOTAL_WITH_MULTIPLIER")
    private Long overtimeWithMultiplier;

    @Column(name = "ATTENDANCE_COUNT")
    private Long attendanceCount;


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

    public Long getTotalDaysWorked() {
        return totalDaysWorked;
    }

    public void setTotalDaysWorked(Long totalDaysWorked) {
        this.totalDaysWorked = totalDaysWorked;
    }

    public Long getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(Long totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public Long getTotalMinutesWorked() {
        return totalMinutesWorked;
    }

    public void setTotalMinutesWorked(Long totalMinutesWorked) {
        this.totalMinutesWorked = totalMinutesWorked;
    }

    public Long getTotalWorked() {
        return totalWorked;
    }

    public void setTotalWorked(Long totalWorked) {
        this.totalWorked = totalWorked;
    }

    public Long getOvertimeDaysWorked() {
        return overtimeDaysWorked;
    }

    public void setOvertimeDaysWorked(Long overtimeDaysWorked) {
        this.overtimeDaysWorked = overtimeDaysWorked;
    }

    public Long getOvertimeHoursWorked() {
        return overtimeHoursWorked;
    }

    public void setOvertimeHoursWorked(Long overtimeHoursWorked) {
        this.overtimeHoursWorked = overtimeHoursWorked;
    }

    public Long getOvertimeMinutesWorked() {
        return overtimeMinutesWorked;
    }

    public void setOvertimeMinutesWorked(Long overtimeMinutesWorked) {
        this.overtimeMinutesWorked = overtimeMinutesWorked;
    }

    public Long getOvertimeTotalWorked() {
        return overtimeTotalWorked;
    }

    public void setOvertimeTotalWorked(Long overtimeTotalWorked) {
        this.overtimeTotalWorked = overtimeTotalWorked;
    }

    public Long getOvertimeWithMultiplier() {
        return overtimeWithMultiplier;
    }

    public void setOvertimeWithMultiplier(Long overtimeWithMultiplier) {
        this.overtimeWithMultiplier = overtimeWithMultiplier;
    }

    public Long getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(Long attendanceCount) {
        this.attendanceCount = attendanceCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonnelAttendance that = (PersonnelAttendance) o;
        return Objects.equals(id,that.id) && Objects.equals(organizationID, that.organizationID) && Objects.equals(monthID , that.monthID) && Objects.equals(yearID , that.yearID) && Objects.equals(occupationId , that.occupationId) && totalHoursWorked == that.totalHoursWorked && totalMinutesWorked == that.totalMinutesWorked && totalWorked == that.totalWorked && overtimeWithMultiplier == that.overtimeWithMultiplier  && overtimeDaysWorked == that.overtimeDaysWorked && overtimeHoursWorked == that.overtimeHoursWorked && overtimeMinutesWorked == that.overtimeMinutesWorked && overtimeTotalWorked == that.overtimeTotalWorked && attendanceCount == that.attendanceCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, organizationID, monthID, yearID, occupationId, totalHoursWorked, totalMinutesWorked, totalWorked, overtimeWithMultiplier, overtimeDaysWorked, overtimeHoursWorked, overtimeMinutesWorked, overtimeTotalWorked, attendanceCount);
    }
}
