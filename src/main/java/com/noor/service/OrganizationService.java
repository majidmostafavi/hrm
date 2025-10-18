package com.noor.service;

import com.noor.dao.OrganizationRepository;
import com.noor.entity.Organization;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrganizationService {
    @Inject
    OrganizationRepository organizationRepository;

    public List<Organization> listAll() {
        return organizationRepository.listAll();

    }


    public Optional<Organization> findByIdOptional(Long id) {
        return organizationRepository.findByIdOptional(id);

    }

    @Transactional
    public Organization create(Organization organization) {
        organizationRepository.persist(organization);
        return organization;

    }

    @Transactional
    public boolean update(Organization organization) {
        try {
            organizationRepository.getEntityManager().merge(organization);
            return true;
        }  catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Transactional
    public boolean deleteById(Long id) {
        return organizationRepository.deleteById(id);

    }
}
