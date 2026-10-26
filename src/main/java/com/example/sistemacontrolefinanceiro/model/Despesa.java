package com.example.sistemacontrolefinanceiro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private BigDecimal valor;
    private long usuarioId;
    private String descricao;
    private LocalDate dataInicial;
    private LocalDate dataFinal;

}
