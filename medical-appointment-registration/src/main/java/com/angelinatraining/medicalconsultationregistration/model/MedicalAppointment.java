package com.angelinatraining.medicalconsultationregistration.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "consulta")
public class MedicalAppointment implements AutoCloseable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Integer id;

    @Column(name = "id_medico")
    private Integer idMedico;

    @Column(name = "id_paciente")
    private Integer idPaciente;

    @Column(name = "data_consulta")
    private LocalDate dataConsulta;

    @Column(name = "hora_consulta")
    private LocalTime horaConsulta;

    @Override
    public void close() throws Exception {

    }
}
