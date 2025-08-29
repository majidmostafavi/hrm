package com.noor.dao;

import com.noor.entity.Department;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class DepartmentRepository implements PanacheRepository<Department> {
}
