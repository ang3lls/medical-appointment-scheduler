package com.angelinatraining.doctorregistration.repository;

import com.angelinatraining.doctorregistration.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRegistrationRepository extends JpaRepository<Doctor, Integer> {

}
