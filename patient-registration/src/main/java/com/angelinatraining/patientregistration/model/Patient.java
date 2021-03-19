package com.angelinatraining.patientregistration.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "paciente")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private int idade;

    @Column(name = "cpf")
    private String cpf;
}
