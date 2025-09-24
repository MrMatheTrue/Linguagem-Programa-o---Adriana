package com.gordao.e1.model;

public class Maca {
  private String nome;
  private int paciencia;
  private String estado;

  public Maca(String nome, int paciencia, String estado) {
    this.nome = nome;
    this.paciencia = paciencia;
    this.estado = estado;
  }

  public void responderProvocacao() { /* noop */ }
  public void reduzirPaciencia(int qtd) { this.paciencia -= qtd; }
  public void gritar() { /* noop */ }
}
