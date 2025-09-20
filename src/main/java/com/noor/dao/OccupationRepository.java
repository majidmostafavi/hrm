package com.noor.dao;

import com.noor.entity.Occupation;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OccupationRepository implements PanacheRepository<Occupation> {
}
