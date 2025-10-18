package com.noor.service;

import com.noor.dao.PersonnelAttendanceDetailRepository;
import com.noor.dao.PersonnelAttendanceMasterRepository;
import com.noor.dto.PersonCategoryDTO;
import com.noor.dto.PersonnelAttendanceDetailDTO;
import com.noor.dto.SumPersonnelAttendanceDTO;
import com.noor.entity.Category;
import com.noor.entity.Month;
import com.noor.entity.PersonnelAttendanceDetail;
import com.noor.entity.PersonnelAttendanceMaster;
import com.noor.enumration.CategoryType;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PersonAttendanceService {

    @Inject
    PersonnelAttendanceMasterRepository masterRepository;
    @Inject
    PersonnelAttendanceDetailRepository detailRepository;

    public List<PersonnelAttendanceMaster> listAll() {
        return masterRepository.listAll();
    }

    public Optional<PersonnelAttendanceMaster> findById(Long id) {
        return masterRepository.findByIdOptional(id);
    }

    public List<PersonnelAttendanceDetail> findDetailByMaster(Long masterID) {
        return detailRepository.findDetailByMaster(masterID) ;
    }

    public List<SumPersonnelAttendanceDTO> sumByOrganizationYear(Long organizationID, Long yearID, Long monthID) {
        try {
            return detailRepository.sumOrganizationYearID(organizationID,yearID,monthID);
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>(0);
        }
    }

    @Transactional
    public PersonnelAttendanceMaster create(PersonnelAttendanceMaster person) {
        person.getPersonnelAttendanceDetails().forEach(detail -> {
            detail.setMaster(person);
        });
        masterRepository.persist(person);
        return person;
    }

    @Transactional
    public boolean delete(Long id) {
        return masterRepository.deleteById(id);
    }

    public PersonnelAttendanceMaster findOrganizationYearID(Long yearID, Long monthID,Long organizationID) {
        return masterRepository.findOrganizationYearID(organizationID,yearID,monthID);
    }

    public List<PersonCategoryDTO> sumPersonCategoryByYearID(Long yearID,Long organizationID, List<Month> monthList){
        return detailRepository.sumPersonCategoryByYearID(yearID,organizationID,monthList);
    }
    public PersonCategoryDTO sumPersonCategoryByYearID(Long yearID, Long organizationID, List<Month> monthList, Category category){
        return detailRepository.sumPersonCategoryByYearID(yearID,organizationID,monthList,category);
    }
    public PersonCategoryDTO sumPersonCategoryByYearID(Long yearID, Long organizationID, List<Month> monthList, CategoryType categoryType){
        return detailRepository.sumPersonCategoryByYearID(yearID,organizationID,monthList,categoryType);
    }
    public List<PersonnelAttendanceDetailDTO>sumDTOPersonAttendanceDetail(Long yearID, Long organizationID, List<Long> monthList){
        return detailRepository.sumDTOPersonAttendanceDetail(yearID,organizationID,monthList);
    }
}
