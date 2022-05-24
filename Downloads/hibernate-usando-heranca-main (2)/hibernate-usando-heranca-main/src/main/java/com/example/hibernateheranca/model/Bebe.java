package com.example.hibernateheranca.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Bebe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank
    private String nome;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    private double altura;
    @ManyToOne
    private Mae mae;
    @ManyToMany
    private Medico medico;
}
