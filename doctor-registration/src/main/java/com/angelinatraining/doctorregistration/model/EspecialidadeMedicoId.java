package com.angelinatraining.doctorregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EspecialidadeMedicoId implements Serializable {
    private Integer idEspecialidade;
    private Integer idMedico;
}
