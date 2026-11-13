package com.example.sistemacontrolefinanceiro.controller;

import com.example.sistemacontrolefinanceiro.service.CategoriaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller: recebe as requisições HTTP e devolve as respostas.
// Não tem regra de negócio, só repassa o trabalho para o Categoria.

@RestController
@RequestMapping
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
}
