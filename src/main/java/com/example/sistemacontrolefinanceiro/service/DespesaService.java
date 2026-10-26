package com.example.sistemacontrolefinanceiro.service;

import com.example.sistemacontrolefinanceiro.model.Despesa;
import com.example.sistemacontrolefinanceiro.repository.DespesaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DespesaService {

    private DespesaRepository despesaRepository;
    private UsuarioService usuarioService;

    public DespesaService(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
        this.usuarioService = usuarioService;
    }

    public Despesa salvarDespesa(Despesa despesa) {
        usuarioService.listarUsuarioPorId(despesa.getUsuarioId());
        if (despesa.getValor() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor da despesa deve ser maior que zero");
        }
        return despesaRepository.save(despesa);
    }
    public Despesa atualizarDespesa (Despesa despesa) {
        usuarioService.listarUsuarioPorId(despesa.getUsuarioId());
        boolean despesaExiste = despesaRepository.existsById(despesa.getId());
        if (!despesaExiste) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Despesa nao encontrada");
        }

        return despesaRepository.save(despesa);
    }

    public void remover(Despesa despesa) {
        boolean despesaExiste = despesaRepository.existsById(despesa.getId());
        if (!despesaExiste) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Despesa nao encontrada");
        }
    }
    public List<Despesa> listarDespesas(long usuarioId) {
        usuarioService.listarUsuarioPorId(usuarioId);
        return despesaRepository.findByUsuarioId(usuarioId);
    }


}
