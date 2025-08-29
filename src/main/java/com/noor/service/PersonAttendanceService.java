package com.noor.service;

import com.noor.dao.PersonnelAttendanceRepository;
import com.noor.dto.SumPersonnelAttendanceDTO;
import com.noor.entity.PersonnelAttendance;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PersonAttendanceService {

    @Inject
    PersonnelAttendanceRepository personRepository;

    public List<PersonnelAttendance> listAll() {
        return personRepository.listAll();
    }

    public Optional<PersonnelAttendance> findById(Long id) {
        return personRepository.findByIdOptional(id);
    }

    public List<SumPersonnelAttendanceDTO> sumByOrganizationYear(Long organizationID, Long yearID, Long monthID) {
        try {
            return personRepository.sumOrganizationYearID(organizationID,yearID,monthID);
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>(0);
        }
    }

    @Transactional
    public PersonnelAttendance create(PersonnelAttendance person) {
        personRepository.persist(person);
        return person;
    }

    @Transactional
    public boolean delete(Long id) {
        return personRepository.deleteById(id);
    }
}
