package com.noor.dao;

import com.noor.dto.PersonCategoryDTO;
import com.noor.dto.SumPersonnelAttendanceDTO;
import com.noor.entity.Month;
import com.noor.entity.PersonnelAttendanceDetail;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class PersonnelAttendanceDetailRepository implements PanacheRepository<PersonnelAttendanceDetail> {

    public List<PersonnelAttendanceDetail> findDetailByMaster(Long masterID){
        Map<String,Object> params = new HashMap<>();
        params.put("masterID",masterID);
        return PersonnelAttendanceDetail.list("masterID",params);
    }

    public List<SumPersonnelAttendanceDTO> sumOrganizationYearID(Long organizationID, Long yearID, Long monthID) {
        EntityManager em =getEntityManager();
        Query query = em.createNamedQuery("sumPersonnelAttendanceByOrganizationYearID", SumPersonnelAttendanceDTO.class);
        query.setParameter("organizationID",organizationID);
        query.setParameter("yearID",yearID);
        return  query.getResultList();
    }

    public List<PersonCategoryDTO> sumPersonCategoryByYearID(Long yearID,Long organizationID,List<Month> months) {
        List<Long> monthIDs = months.stream().map(s-> s.id).toList();
        EntityManager em =getEntityManager();
        Query query = em.createNamedQuery("sumPersonCategoryByYearID", PersonCategoryDTO.class);
        query.setParameter("organizationID",organizationID);
        query.setParameter("yearID",yearID);
        query.setParameter("months",monthIDs);
        return  query.getResultList();
    }
}
