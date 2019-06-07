package com.project.demo.repositories;

import com.project.demo.domains.MedicalCenter;
import org.springframework.data.repository.CrudRepository;

public interface MedicalCenterRepository extends CrudRepository<MedicalCenter, String> {
}
