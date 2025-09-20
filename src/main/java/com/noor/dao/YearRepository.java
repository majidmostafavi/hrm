package com.noor.dao;

import com.noor.entity.Year;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class YearRepository implements PanacheRepository<Year> {
}
