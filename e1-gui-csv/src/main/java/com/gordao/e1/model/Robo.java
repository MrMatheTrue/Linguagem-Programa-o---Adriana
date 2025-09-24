package com.gordao.e1.model;

public class Robo {
  private String identificador;
  private String funcao;
  private int nivelBateria;

  public Robo(String identificador, String funcao, int nivelBateria) {
    this.identificador = identificador;
    this.funcao = funcao;
    this.nivelBateria = nivelBateria;
  }

  public void executarTarefa() { /* noop */ }
  public void recarregar() { this.nivelBateria = 100; }
  public void reportarStatus() { /* noop */ }
}
