package com.noor.dao;

import com.noor.entity.Organization;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class OrganizationRepository implements PanacheRepository<Organization> {
}
