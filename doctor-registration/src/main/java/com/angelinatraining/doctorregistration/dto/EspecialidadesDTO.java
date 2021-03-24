package com.angelinatraining.doctorregistration.dto;

public class EspecialidadesDTO extends EspecialidadeMedicoDTO {
    private Integer idEspecialidade;
    private String descricao;

    @Override
    public Integer getIdEspecialidade() {
        return idEspecialidade;
    }

    @Override
    public void setIdEspecialidade(Integer idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
