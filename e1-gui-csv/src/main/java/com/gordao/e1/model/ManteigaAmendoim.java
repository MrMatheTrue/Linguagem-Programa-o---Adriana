package com.gordao.e1.model;

public class ManteigaAmendoim {
  private String textura;
  private double oleosidade;
  private double quantidade;

  public ManteigaAmendoim(String textura, double oleosidade, double quantidade) {
    this.textura = textura;
    this.oleosidade = oleosidade;
    this.quantidade = quantidade;
  }

  public void darVolume(String regiao) { /* noop */ }
}
