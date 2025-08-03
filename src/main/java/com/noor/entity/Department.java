package com.noor.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.noor.enumration.DepartmentType;
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
    @JsonProperty("name")
    private String name;
    @Column(name = "CODE")
    @JsonProperty("code")
    private Long code;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "DEPARTMENT_TYPE")
    @JsonProperty("departmentType")
    private DepartmentType departmentType;
}
