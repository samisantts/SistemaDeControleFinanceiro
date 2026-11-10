package com.example.sistemacontrolefinanceiro.service;

import com.example.sistemacontrolefinanceiro.enums.CategoriaEnum;
import com.example.sistemacontrolefinanceiro.exception.CategoriaNaoExisteException;
import com.example.sistemacontrolefinanceiro.model.Categoria;
import com.example.sistemacontrolefinanceiro.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;
    private UsuarioService usuarioService;
    private CategoriaEnum categoriaEnum;


    public CategoriaService(CategoriaRepository categoriaRepository, UsuarioService usuarioService, CategoriaEnum categoriaEnum) {
        this.usuarioService = usuarioService;
        this.categoriaEnum = categoriaEnum;
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria salvarCategoria(Categoria categoria) {

        String categoriaNome = categoria.getNome();

        try {
            CategoriaEnum categoriaEnum = Enum.valueOf(
                    CategoriaEnum.class,
                    categoriaNome.trim().toUpperCase()
            );

        } catch (IllegalArgumentException e) {
            throw new CategoriaNaoExisteException("Categoria não encontrada!");
        }

        return categoriaRepository.save(categoria);
    }
}





