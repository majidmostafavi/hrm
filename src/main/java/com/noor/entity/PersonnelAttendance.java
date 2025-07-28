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
public class PersonnelAttendance extends PanacheEntity {

    @ManyToOne
    @JoinColumn
    private Department department;
    private int departmentId;

    @ManyToOne
    @JoinColumn
    private Month month;
    private int monthId;

    @ManyToOne
    @JoinColumn
    private Year year;
    private int yearId;

    @ManyToOne
    @JoinColumn
    private Occupation occupation;
    private int occupationId;

    private int totalHoursWorked;
    private int overtimeHoursWorked;
    private int overtimeMinWorked;
    private int overtimeWorked;
    private int attendanceCount;
}
