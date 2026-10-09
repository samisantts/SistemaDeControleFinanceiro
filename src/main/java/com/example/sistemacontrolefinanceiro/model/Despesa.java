package com.example.sistemacontrolefinanceiro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String descricao;
    private double valor;
    private String categoria;

}
