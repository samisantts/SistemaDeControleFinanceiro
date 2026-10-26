package com.example.sistemacontrolefinanceiro.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String categoria;
    private String descricao;


}
