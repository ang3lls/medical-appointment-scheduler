package com.angelinatraining.patientregistration.repository;

import com.angelinatraining.patientregistration.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
