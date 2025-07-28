package com.noor.dao;

import com.noor.entity.PersonnelAttendance;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class PersonnelAttendanceRepository implements PanacheRepository<PersonnelAttendance> {
}
