package com.noor.dao;

import com.noor.dto.SumPersonnelAttendanceDTO;
import com.noor.entity.MedicalPerMonth;
import com.noor.entity.PersonnelAttendance;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ApplicationScoped
public class PersonnelAttendanceRepository implements PanacheRepository<PersonnelAttendance> {


    public List<SumPersonnelAttendanceDTO> sumOrganizationYearID(Long organizationID, Long yearID, Long monthID) {
        EntityManager em =getEntityManager();
        Query query = em.createNamedQuery("sumPersonnelAttendanceByOrganizationYearID", SumPersonnelAttendanceDTO.class);
        query.setParameter("organizationID",organizationID);
        query.setParameter("yearID",yearID);
        return  query.getResultList();
    }

    public List<PersonnelAttendance> findOrganizationYearID(Long organizationID, Long yearID, Long monthID) {
        Map<String,Object> params = new HashMap<>();
        params.put("organizationID",organizationID);
        params.put("yearID",yearID);
        params.put("monthID",monthID);

        return PersonnelAttendance.list("organizationID=:organizationID and yearID=:yearID and monthID=:monthID", params);
    }
}
