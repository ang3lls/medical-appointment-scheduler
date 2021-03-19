package com.angelinatraining.doctorregistration.model;

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
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Transient
    private List<EspecialidadesDTO> listaEspecialidades;

    @Override
    public void close() throws Exception {

    }
}
