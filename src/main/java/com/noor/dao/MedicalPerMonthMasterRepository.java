package com.noor.dao;


import com.noor.entity.MedicalPerMonthMaster;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MedicalPerMonthMasterRepository implements PanacheRepository<MedicalPerMonthMaster> {
}
