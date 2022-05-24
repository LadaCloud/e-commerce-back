package com.example.hibernateheranca.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "subtype", columnDefinition = "ENUM('RESIDENTE')")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String telefone;
    @NotBlank
    private String nome;
    private Especialidade especialidade;

}
