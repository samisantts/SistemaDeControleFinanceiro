package com.example.sistemacontrolefinanceiro.model;

import com.example.sistemacontrolefinanceiro.enums.CategoriaEnum;
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
    private LocalDate data;
    private Long usuarioId;
    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoriaEnum;


}