package com.example.sistemacontrolefinanceiro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
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

    private long id;
    private BigDecimal valor;
    private long usuarioId;
    private String descricao;
    private LocalDate dataInicial;
    private LocalDate dataFinal;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}

