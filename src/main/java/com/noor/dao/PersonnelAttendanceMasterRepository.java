package com.noor.dao;

import com.noor.entity.PersonnelAttendanceMaster;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonnelAttendanceMasterRepository implements PanacheRepository<PersonnelAttendanceMaster> {
}
