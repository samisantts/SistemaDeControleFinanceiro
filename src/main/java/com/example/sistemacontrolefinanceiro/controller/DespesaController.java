package com.example.sistemacontrolefinanceiro.controller;

import com.example.sistemacontrolefinanceiro.model.Despesa;
import com.example.sistemacontrolefinanceiro.service.DespesaService;
import org.springframework.web.bind.annotation.*;

@RestController
public class DespesaController {

    private DespesaService despesaService;


    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;

    }

    @PostMapping("/despesas")
    public Despesa salvar(@RequestBody Despesa despesa) {
        return despesaService.salvarDespesa(despesa);
    }

    @PutMapping("/despesas")
    public Despesa atualizar(@RequestBody Despesa despesa) {
        return despesaService.atualizarDespesa(despesa);
    }

    @DeleteMapping("/despesas")
    public void remover(@RequestBody Despesa despesa) {
        despesaService.remover(despesa);
    }
}