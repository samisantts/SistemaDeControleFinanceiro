package com.example.sistemacontrolefinanceiro.controller;

import com.example.sistemacontrolefinanceiro.model.Despesa;
import com.example.sistemacontrolefinanceiro.service.DespesaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping ("/Despesas")
public class DespesaController {

    private final DespesaService despesaService;

    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }
    @PostMapping
    public Despesa salvar(@RequestBody Despesa despesa) {
        return despesaService.salvarDespesa(despesa);
    }
    @PutMapping
    public Despesa atualizar(@RequestBody Despesa despesa) {
        return despesaService.atualizarDespesa(despesa);
    }
    @DeleteMapping
    public void remover(@RequestBody Despesa despesa) {
        despesaService.remover(despesa);
    }

    @GetMapping("/usuarios/{usuarioId}/despesas")
    public List<Despesa> listar(@PathVariable Long usuarioId) {
        return despesaService.listarDespesas(usuarioId);
    }
}
