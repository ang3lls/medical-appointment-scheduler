package com.angelinatraining.medicalconsultationregistration.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class MedicalAppointmentDTO {
    private Integer id;
    private Integer idMedico;
    private Integer idPaciente;
    private LocalDate dataConsulta;
    private LocalTime horaConsulta;

    public MedicalAppointmentDTO(Integer id, Integer idMedico, Integer idPaciente,
                                 LocalDate dataConsulta, LocalTime horaConsulta) {
        this.id = id;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
    }

    public MedicalAppointmentDTO(){

    }
}
