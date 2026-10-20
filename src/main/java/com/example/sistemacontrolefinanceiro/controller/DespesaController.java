package com.example.sistemacontrolefinanceiro.controller;

import com.example.sistemacontrolefinanceiro.repository.DespesaRepository;
import com.example.sistemacontrolefinanceiro.service.DespesaService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DespesaController {

    private DespesaService despesaService;


    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;

    }

    public

}
