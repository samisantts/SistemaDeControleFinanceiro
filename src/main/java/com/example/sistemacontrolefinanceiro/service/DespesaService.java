package com.example.sistemacontrolefinanceiro.service;

import com.example.sistemacontrolefinanceiro.model.Despesa;
import com.example.sistemacontrolefinanceiro.repository.DespesaRepository;
import org.springframework.stereotype.Service;

@Service
public class DespesaService {

    private DespesaRepository despesaRepository;
    private UsuarioService usuarioService;

    public DespesaService(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    public Despesa salvar(Despesa despesa) {
        usuarioService.listarUsuarioPorId(despesa.getUsuarioId());
       return despesaRepository.save(despesa);
    }

    public Despesa atualizar(Despesa despesa) {

        boolean despesaExiste = despesaRepository.existsById(despesa.getId());
        if (!despesaExiste) {
            throw new RuntimeException("Despesa nao encontrada");
        }
        usuarioService.listarUsuarioPorId(despesa.getUsuarioId());
        return despesaRepository.save(despesa);
    }
}


