package com.noor.service;

import com.noor.dao.MedicalPerMonthRepository;
import com.noor.entity.MedicalPerMonth;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class MedicalPerMonthService {

    @Inject
    MedicalPerMonthRepository medicalPerMonthRepository;

    public List<MedicalPerMonth> listAll() {
        return medicalPerMonthRepository.listAll();
    }

    public Optional<MedicalPerMonth> findById(Long id) {
        return medicalPerMonthRepository.findByIdOptional(id);
    }

    public List<MedicalPerMonth> searchByOrganizationYear(Long organizationID, Long yearID,Long monthID) {
        try {
            return medicalPerMonthRepository.findByOrganizationYearID(organizationID,yearID,monthID);
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Transactional
    public MedicalPerMonth create(MedicalPerMonth medicalPerMonth) {
        medicalPerMonthRepository.persist(medicalPerMonth);
        return medicalPerMonth;
    }

    @Transactional
    public boolean delete(Long id) {
        return medicalPerMonthRepository.deleteById(id);
    }
}
