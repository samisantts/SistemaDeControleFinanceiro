package com.example.sistemacontrolefinanceiro.service;

import com.example.sistemacontrolefinanceiro.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;
    private UsuarioService usuarioService;

    public CategoriaService(CategoriaRepository categoriaRepository, UsuarioService usuarioService) {
        this.categoriaRepository = categoriaRepository;
        this.usuarioService = usuarioService;
    }
}