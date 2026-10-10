package com.example.sistemacontrolefinanceiro.repository;

import com.example.sistemacontrolefinanceiro.model.Despesa;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface DespesaRepository extends JpaRepository<Despesa, Long>{

}
