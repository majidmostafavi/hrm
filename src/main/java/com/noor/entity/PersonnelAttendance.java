package com.noor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PERSONNEL_ATTENDANCE")
public class PersonnelAttendance extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID",updatable = false,insertable = false)
    private Department department;
    @Column(name = "DEPARTMENT_ID")
    private int departmentId;

    @ManyToOne
    @JoinColumn(name = "MONTH_ID",updatable = false,insertable = false)
    private Month month;
    @Column(name = "MONTH_ID")
    private int monthId;

    @ManyToOne
    @JoinColumn(name = "YEAR_ID",updatable = false,insertable = false)
    private Year year;
    @Column(name = "YEAR_ID")
    private int yearId;

    @ManyToOne
    @JoinColumn(name = "OCCUPATION_ID",updatable = false,insertable = false)
    private Occupation occupation;
    @Column(name = "OCCUPATION_ID")
    private int occupationId;

    @Column(name = "TOTAL_HOURS_WORKED")
    private int totalHoursWorked;
    @Column(name = "TOTAL_MINUTES_WORKED")
    private int totalMinutesWorked;
    @Column(name = "TOTAL_WORKED")
    private int totalWorked;

    @Column(name = "TOTAL_WITH_MULTIPLIER")
    private int overtimeWithMultiplier;
    @Column(name = "TOTAL_WITH_OUT_MULTIPLIER")
    private int overtimeWithOutMultiplier;

    @Column(name = "OVERTIME_DAYS_WORKED")
    private int overtimeDaysWorked;
    @Column(name = "OVERTIME_HOURS_WORKED")
    private int overtimeHoursWorked;
    @Column(name = "OVERTIME_MINUTES_WORKED")
    private int overtimeMinutesWorked;
    @Column(name = "OVERTIME_TOTAL_WORKED")
    private int overtimeTotalWorked;


    @Column(name = "ATTENDANCE_COUNT")
    private int attendanceCount;
}
