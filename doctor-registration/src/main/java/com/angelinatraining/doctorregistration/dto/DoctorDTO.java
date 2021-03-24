package com.angelinatraining.doctorregistration.dto;

import lombok.Data;

import java.util.List;

@Data
public class DoctorDTO {
    private Integer id;
    private String nome;
    private List<EspecialidadesDTO> listaEspecialidades;

    public DoctorDTO(Integer id, String nome, List<EspecialidadesDTO> listaEspecialidades) {
        this.id = id;
        this.nome = nome;
        this.listaEspecialidades = listaEspecialidades;
    }

    public DoctorDTO(){

    }

}
