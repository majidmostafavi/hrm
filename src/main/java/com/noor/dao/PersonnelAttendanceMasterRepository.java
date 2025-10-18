package com.noor.dao;

import com.noor.dto.SumPersonnelAttendanceDTO;
import com.noor.entity.PersonnelAttendance;
import com.noor.entity.PersonnelAttendanceMaster;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class PersonnelAttendanceMasterRepository implements PanacheRepository<PersonnelAttendanceMaster> {
    public PersonnelAttendanceMaster findOrganizationYearID(Long organizationID, Long yearID, Long monthID) {
        Map<String,Object> params = new HashMap<>();
        params.put("organizationID",organizationID);
        params.put("yearID",yearID);
        params.put("monthID",monthID);

        return PersonnelAttendanceMaster.find("organizationID=:organizationID and yearID=:yearID and monthID in :monthID", params).singleResult();
    }

}
