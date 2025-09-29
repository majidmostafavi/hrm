package com.noor.dao;


import com.noor.entity.MedicalPerMonthMaster;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class MedicalPerMonthMasterRepository implements PanacheRepository<MedicalPerMonthMaster> {

    public List<MedicalPerMonthMaster> findByOrganizationYearID(Long organizationID, Long yearID,Long monthID){
        Map<String,Object> params = new HashMap<>();
        params.put("organizationID",organizationID);
        params.put("yearID",yearID);
        params.put("monthID",monthID);

        return MedicalPerMonthMaster.list("organizationID=:organizationID and yearID=:yearID and monthID=:monthID", params);
    }
}
