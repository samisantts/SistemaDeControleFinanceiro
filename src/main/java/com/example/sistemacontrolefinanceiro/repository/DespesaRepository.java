package com.example.sistemacontrolefinanceiro.repository;

import com.example.sistemacontrolefinanceiro.model.Despesa;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface DespesaRepository extends JpaRepository<Despesa, Long>{

    //;despesaRepository.save(despesa); //       // salva ou atualiza uma despesa
// despesaRepository.existsById(id);         // true/false: essa despesa existe?
// despesaRepository.findById(id);           // busca uma despesa pelo id
// despesaRepository.deleteById(id);         // apaga pelo id
// despesaRepository.findAll();              // devolve todas as despesas
}
