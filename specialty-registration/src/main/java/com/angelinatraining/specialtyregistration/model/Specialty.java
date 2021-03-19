package com.angelinatraining.specialtyregistration.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "especialidades")
public class Specialty implements AutoCloseable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidade")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    @Override
    public void close() throws Exception {

    }
}
