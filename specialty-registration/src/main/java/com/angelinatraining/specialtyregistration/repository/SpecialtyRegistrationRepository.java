package com.angelinatraining.specialtyregistration.repository;

import com.angelinatraining.specialtyregistration.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRegistrationRepository extends JpaRepository<Specialty, Integer> {
}
