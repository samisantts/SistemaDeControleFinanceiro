package com.example.sistemacontrolefinanceiro.exception;

public class DespesaJaExisteException extends RuntimeException {
  public DespesaJaExisteException(String message) {
    super(message);
  }
}
