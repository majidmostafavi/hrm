package com.noor.dao;

import com.noor.entity.Service;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ServiceRepository implements PanacheRepository<Service> {
}
