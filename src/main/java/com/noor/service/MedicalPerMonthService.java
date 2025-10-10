package com.noor.service;

import com.noor.dao.MedicalPerMonthDetailRepository;
import com.noor.dao.MedicalPerMonthMasterRepository;
import com.noor.dto.ServiceCategoryDTO;
import com.noor.entity.MedicalPerMonthDetail;
import com.noor.entity.MedicalPerMonthMaster;
import com.noor.entity.Month;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class MedicalPerMonthService {

    @Inject
    MedicalPerMonthMasterRepository masterRepository;
    @Inject
    MedicalPerMonthDetailRepository detailRepository;

    public List<MedicalPerMonthMaster> listAll() {
        return masterRepository.listAll(Sort.by("year").descending().and("month", Sort.Direction.Ascending));
    }

    public Optional<MedicalPerMonthMaster> findById(Long id) {
        return masterRepository.findByIdOptional(id);
    }

    public List<MedicalPerMonthDetail> findDetailByMaster(Long masterId) {
        return detailRepository.findDetailByMasterID(masterId);
    }

    public MedicalPerMonthMaster searchByOrganizationYear(Long organizationID, Long yearID,Long monthID) {
        try {
            return masterRepository.findByOrganizationYearID(organizationID,yearID,monthID);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public MedicalPerMonthMaster create(MedicalPerMonthMaster medicalPerMonth) {
        medicalPerMonth.getMedicalPerMonthDetails().forEach(detail -> {
            detail.setMedicalPerMonthMaster(medicalPerMonth);
        });
        masterRepository.persist(medicalPerMonth);
        return medicalPerMonth;
    }

    @Transactional
    public boolean delete(Long id) {
        return masterRepository.deleteById(id);
    }

    public List<ServiceCategoryDTO> sumServiceCategoryByYearOrganizationMonth(Long yearID, Long organizationID, List<Month> monthList) {
         return detailRepository.sumServiceCategoryByYearOrganizationMonth(yearID,organizationID,monthList);
    }
}
