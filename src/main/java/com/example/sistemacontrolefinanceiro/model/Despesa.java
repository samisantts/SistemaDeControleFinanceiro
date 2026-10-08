package com.example.sistemacontrolefinanceiro.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Despesa {

    private long id;
    private String descricao;
    private double valor;
    private String categoria;

}
