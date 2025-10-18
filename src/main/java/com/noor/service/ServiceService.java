package com.noor.service;

import com.noor.dao.ServiceRepository;
import com.noor.entity.Service;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ServiceService {
    @Inject
    ServiceRepository serviceRepository;



    public List<Service> listAll() {
        return serviceRepository.listAll();

    }
    public List<Service> findAllLeaf() {
        return serviceRepository.findAllLeaf();

    }

    public Optional<Service> findByIdOptional(Long id) {
        return serviceRepository.findByIdOptional(id);

    }

    @Transactional
    public Service create(Service service) {
        serviceRepository.persist(service);
        return service;

    }

    @Transactional
    public boolean update(Service service) {
        try {
            serviceRepository.getEntityManager().merge(service);
            return true;
        }  catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Transactional
    public boolean deleteById(Long id) {
        return serviceRepository.deleteById(id);

    }
}
