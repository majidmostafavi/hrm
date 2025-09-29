package com.noor.dao;


import com.noor.entity.MedicalPerMonthDetail;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

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
}
