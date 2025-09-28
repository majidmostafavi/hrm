package com.noor.dao;

import com.noor.entity.PersonnelAttendanceDetail;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonnelAttendanceDetailRepository implements PanacheRepository<PersonnelAttendanceDetail> {
}
