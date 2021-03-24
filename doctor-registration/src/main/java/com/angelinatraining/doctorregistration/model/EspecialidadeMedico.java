package com.angelinatraining.doctorregistration.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "especialidade_medico")
@IdClass(EspecialidadeMedicoId.class)
public class EspecialidadeMedico {

    @Id
    @Column(name = "id_especialidade")
    private Integer idEspecialidade;

    @Id
    @Column(name = "id_medico")
    private Integer idMedico;

}
