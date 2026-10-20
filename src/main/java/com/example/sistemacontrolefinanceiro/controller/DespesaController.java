package com.example.sistemacontrolefinanceiro.controller;

import com.example.sistemacontrolefinanceiro.model.Despesa;
import com.example.sistemacontrolefinanceiro.service.DespesaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
