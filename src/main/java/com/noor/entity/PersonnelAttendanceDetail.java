package com.noor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "PERSONNEL_ATTENDANCE_DETAIL")
@NamedQueries({
        @NamedQuery(name = "sumPersonnelAttendanceByOrganizationYearID", query = "select new com.noor.dto.SumPersonnelAttendanceDTO (  " +
                "master.yearID,master.year.name,master.monthID,master.month.name,master.organizationID,master.organization.name," +
                "sum(detail.totalWorked),sum(detail.overtimeHoursWorked),sum(detail.overtimeMinutesWorked),sum(detail.attendanceCount) )  " +
                "from PersonnelAttendanceDetail  detail join detail.master master where master.organizationID=: organizationID and master.yearID=: yearID " +
                "group by master.yearID,master.year.name,master.monthID,master.month.name,master.organizationID,master.organization.name  order by master.monthID"),
        @NamedQuery(name = "sumPersonCategoryByYearID", query = "select new com.noor.dto.PersonCategoryDTO (  " +
                "category.name,category.code,category.id,category.categoryType , " +
                "sum(detail.attendanceCount),sum(detail.overtimeHoursWorked),sum(detail.overtimeMinutesWorked))  " +
                "from PersonnelAttendanceDetail  detail join detail.master master join detail.occupation occupation join occupation.department department join department.category category " +
                "where master.organizationID=: organizationID and master.yearID=: yearID and master.monthID in :months " +
                "group by category.name,category.code,category.id,category.categoryType "),


})
public class PersonnelAttendanceDetail  extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "MASTER_ID")
    @JsonIgnore
    private PersonnelAttendanceMaster master;

    @Column(name = "MASTER_ID", nullable = false,updatable = false,insertable = false)
    private Long masterID;

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

    public PersonnelAttendanceMaster getMaster() {
        return master;
    }

    public void setMaster(PersonnelAttendanceMaster master) {
        this.master = master;
    }

    public Long getMasterID() {
        return masterID;
    }

    public void setMasterID(Long masterID) {
        this.masterID = masterID;
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
        PersonnelAttendanceDetail that = (PersonnelAttendanceDetail) o;
        return  Objects.equals(occupationId, that.occupationId) && Objects.equals(totalDaysWorked, that.totalDaysWorked) && Objects.equals(totalHoursWorked, that.totalHoursWorked) && Objects.equals(totalMinutesWorked, that.totalMinutesWorked) && Objects.equals(totalWorked, that.totalWorked) && Objects.equals(overtimeDaysWorked, that.overtimeDaysWorked) && Objects.equals(overtimeHoursWorked, that.overtimeHoursWorked) && Objects.equals(overtimeMinutesWorked, that.overtimeMinutesWorked) && Objects.equals(overtimeTotalWorked, that.overtimeTotalWorked) && Objects.equals(overtimeWithMultiplier, that.overtimeWithMultiplier) && Objects.equals(attendanceCount, that.attendanceCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash( occupationId, totalDaysWorked, totalHoursWorked, totalMinutesWorked, totalWorked, overtimeDaysWorked, overtimeHoursWorked, overtimeMinutesWorked, overtimeTotalWorked, overtimeWithMultiplier, attendanceCount);
    }
}
