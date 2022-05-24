package com.example.hibernateheranca.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
@DiscriminatorValue("RESIDENTE")
public class Residente extends Medico {
    @NotBlank
    @Column(name = "instituicao_ensino")
    private String instituicaoEnsino;
    @NotBlank
    @Column(name = "ano_ingresso")
    private int anoIngresso;
}
