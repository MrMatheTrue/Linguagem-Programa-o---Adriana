package com.gordao.e1.model;

public class GeleiaUva {
  private String tonalidade;
  private double viscosidade;
  private double quantidade;

  public GeleiaUva(String tonalidade, double viscosidade, double quantidade) {
    this.tonalidade = tonalidade;
    this.viscosidade = viscosidade;
    this.quantidade = quantidade;
  }

  public void espalhar(double areaCm2) { /* noop */ }
}
