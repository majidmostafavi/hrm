package com.noor.dao;


import com.noor.dto.ServiceCategoryDTO;
import com.noor.entity.MedicalPerMonthDetail;
import com.noor.entity.Month;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class MedicalPerMonthDetailRepository implements PanacheRepository<MedicalPerMonthDetail>{

    public List<MedicalPerMonthDetail> findDetailByMasterID(Long masterID){
        Map<String,Object> params = new HashMap<>();
        params.put("masterID",masterID);
        return MedicalPerMonthDetail.list("masterID",params);
    }

    public List<ServiceCategoryDTO> sumServiceCategoryByYearOrganizationMonth(Long yearID, Long organizationID, List<Month> monthList) {
        List<Long> monthIDs = monthList.stream().map(s->s.id).toList();
        EntityManager em =getEntityManager();
        Query query = em.createNamedQuery("sumServiceCategoryByYearOrganizationMonth", ServiceCategoryDTO.class);
        query.setParameter("organizationID",organizationID);
        query.setParameter("yearID",yearID);
        query.setParameter("monthIDs",monthIDs);
        return  query.getResultList();
    }
}
