package com.example.hibernateheranca.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Mae {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String cep;
    @NotBlank
    private String nome;
    private String logradouro;
    @Positive
    private int numero;
    @Size(max = 100)
    private String complemento;
    private String telefone;
    private LocalDate nascimento;
}
