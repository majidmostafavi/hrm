package com.noor.dao;

import com.noor.entity.Month;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MonthRepository implements PanacheRepository<Month> {
}
