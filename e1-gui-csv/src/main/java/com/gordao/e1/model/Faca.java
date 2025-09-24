package com.gordao.e1.model;

public class Faca {
  private int afiacao;
  private String material;
  private String posicao;

  public Faca(int afiacao, String material, String posicao) {
    this.afiacao = afiacao;
    this.material = material;
    this.posicao = posicao;
  }

  public void aproximarDoAlvo(Maca alvo) { /* noop */ }
  public void cortar(Maca alvo) { /* noop */ }
  public void afiar(int qtd) { this.afiacao += qtd; }
}
