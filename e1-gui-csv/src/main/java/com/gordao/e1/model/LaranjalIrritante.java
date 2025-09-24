package com.gordao.e1.model;

public class LaranjalIrritante {
  private String nome;
  private int volumeVoz;
  private int nivelIrritacao;

  public LaranjalIrritante(String nome, int volumeVoz, int nivelIrritacao) {
    this.nome = nome;
    this.volumeVoz = volumeVoz;
    this.nivelIrritacao = nivelIrritacao;
  }

  public void provocar(Maca alvo) { /* noop */ }
  public void rir() { /* noop */ }
  public void aumentarIrritacao(int qtd) { this.nivelIrritacao += qtd; }
}
