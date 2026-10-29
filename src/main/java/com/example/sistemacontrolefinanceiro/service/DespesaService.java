package com.example.sistemacontrolefinanceiro.service;

import com.example.sistemacontrolefinanceiro.model.Despesa;
import com.example.sistemacontrolefinanceiro.repository.DespesaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class DespesaService {

    private DespesaRepository despesaRepository;
    private UsuarioService usuarioService;

    public DespesaService(DespesaRepository despesaRepository, UsuarioService usuarioService) {
        this.despesaRepository = despesaRepository;
        this.usuarioService = usuarioService;
    }

    public Despesa salvarDespesa(Despesa despesa) {
        if (despesa.getUsuarioId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario da despesa deve ser informado");
        }
        usuarioService.listarUsuarioPorId(despesa.getUsuarioId());

        if (despesa.getValor() == null || despesa.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor da despesa deve ser maior que zero");
        }
        return despesaRepository.save(despesa);
    }

    public Despesa atualizarDespesa(Despesa despesa) {
        if (despesa.getId() == null || despesa.getUsuarioId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id da despesa e do usuario devem ser informados");
        }
        usuarioService.listarUsuarioPorId(despesa.getUsuarioId());

        boolean despesaExiste = despesaRepository.existsById(despesa.getId());
        if (!despesaExiste) {
        }
        return despesaRepository.save(despesa);
    }

    public void remover(Despesa despesa) {
        boolean despesaExiste = despesaRepository.existsById(despesa.getId());
        if (!despesaExiste) {
        }
        despesaRepository.deleteById(despesa.getId());
    }

    public List<Despesa> listarDespesas(long usuarioId) {
        usuarioService.listarUsuarioPorId(usuarioId);
        return despesaRepository.findByUsuarioId(usuarioId);
    }

    public Despesa buscarPorId(Long id) {
        boolean despesaExiste = despesaRepository.existsById(id);
        if (!despesaExiste) {
        }
        return despesaRepository.findById(id).get();
    }

    public BigDecimal totalDoMes(Long usuarioId, int ano, int mes) {
        usuarioService.listarUsuarioPorId(usuarioId);

        LocalDate inicio = LocalDate.of(ano, mes, 1);
        LocalDate fim = inicio.withDayOfMonth(inicio.lengthOfMonth());

        List<Despesa> despesas = despesaRepository.findByUsuarioIdAndDataInicialBetween(usuarioId, inicio, fim);

        BigDecimal total = BigDecimal.ZERO;
        for (Despesa despesa : despesas) {
            total = total.add(despesa.getValor());
        }
        return total;
    }
}