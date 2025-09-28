package com.noor.dao;


import com.noor.entity.MedicalPerMonthDetail;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MedicalPerMonthDetailRepository implements PanacheRepository<MedicalPerMonthDetail>{
}
