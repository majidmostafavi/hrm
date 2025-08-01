
package com.noor.dao;

import com.noor.entity.MedicalPerMonth;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MedicalPerMonthRepository implements PanacheRepository<MedicalPerMonth> {
}
