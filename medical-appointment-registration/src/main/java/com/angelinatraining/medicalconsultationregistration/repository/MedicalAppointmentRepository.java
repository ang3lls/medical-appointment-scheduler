package com.angelinatraining.medicalconsultationregistration.repository;

import com.angelinatraining.medicalconsultationregistration.model.MedicalAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Integer> {
}
