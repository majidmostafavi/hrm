
package com.noor.dao;

import com.noor.entity.MedicalPerMonth;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class MedicalPerMonthRepository implements PanacheRepository<MedicalPerMonth> {

    public List<MedicalPerMonth> findByOrganizationYearID(Long organizationID,Long yearID,Long monthID) {
        Map<String,Object> params = new HashMap<>();
        params.put("organizationID",organizationID);
        params.put("yearID",yearID);
        params.put("monthID",monthID);

        return MedicalPerMonth.list("organizationID=:organizationID and yearID=:yearID and monthID=:monthID", params);
    }
}
