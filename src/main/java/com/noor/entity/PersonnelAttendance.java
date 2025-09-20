package com.noor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "sumPersonnelAttendanceByOrganizationYearID", query = "select new com.noor.dto.SumPersonnelAttendanceDTO (  " +
                "personnelAttendance.yearID,personnelAttendance.year.name,personnelAttendance.monthID,personnelAttendance.month.name,personnelAttendance.organizationID,personnelAttendance.organization.name," +
                "sum(personnelAttendance.totalWorked),sum(personnelAttendance.overtimeTotalWorked),sum(personnelAttendance.attendanceCount) )  " +
                "from PersonnelAttendance  personnelAttendance where personnelAttendance.organizationID=: organizationID and personnelAttendance.yearID=: yearID " +
                "group by personnelAttendance.yearID,personnelAttendance.year.name,personnelAttendance.monthID,personnelAttendance.month.name,personnelAttendance.organizationID,personnelAttendance.organization.name "),

})

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
