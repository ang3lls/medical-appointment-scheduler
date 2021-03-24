package com.angelinatraining.doctorregistration.model;

import com.angelinatraining.doctorregistration.dto.DoctorDTO;
import com.angelinatraining.doctorregistration.dto.EspecialidadesDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "medico")
public class Doctor implements AutoCloseable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Integer id_medico;

    @Column(name = "nome")
    private String nome;

    @Column(name = "id_especialidade")
    public Integer id_especialidade;

    @Transient
    public DoctorDTO medicoId;

    @Transient
    public List<EspecialidadesDTO> idsEspecialidades;


    @Override
    public void close() throws Exception {

    }
}
