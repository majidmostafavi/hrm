package com.noor.entity;

import com.noor.DepartmentType;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DEPARTMENTS")
public class Department  extends PanacheEntity {

    @Column(name = "NAME")
    private String name;
    @Column(name = "CODE")
    private Long code;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "DEPARTMENT_TYPE")
    private DepartmentType departmentType;
}
