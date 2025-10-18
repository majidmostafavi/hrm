package com.noor.service;

import com.noor.dao.YearRepository;
import com.noor.entity.Year;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class YearService {

    @Inject
     YearRepository yearRepository;

    public List<Year> listAll() {
        return yearRepository.listAll();

    }


    public Optional<Year> findByIdOptional(Long id) {
        return yearRepository.findByIdOptional(id);

    }

    @Transactional
    public Year create(Year year) {
        yearRepository.persist(year);
        return year;

    }

    @Transactional
    public boolean update(Year year) {
        try {
            yearRepository.getEntityManager().merge(year);
            return true;
        }  catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Transactional
    public boolean deleteById(Long id) {
        return yearRepository.deleteById(id);

    }
}
