package com.example.sistemacontrolefinanceiro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private BigDecimal valor;
    private String descricao;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Long usuarioId;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}