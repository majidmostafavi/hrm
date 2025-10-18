package com.noor.dao;

import com.noor.entity.Service;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;


@ApplicationScoped
public class ServiceRepository implements PanacheRepository<Service> {

    public List<Service> findAllLeaf(){

        EntityManager em =getEntityManager();
        Query query = em.createNamedQuery("findLeafService", Service.class);
        return query.getResultList();
    }
}
