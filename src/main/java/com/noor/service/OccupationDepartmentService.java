package com.noor.service;

import com.noor.dao.OccupationDepartmentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class OccupationDepartmentService {
    @Inject
    OccupationDepartmentRepository occupationDepartmentRepository;
}
