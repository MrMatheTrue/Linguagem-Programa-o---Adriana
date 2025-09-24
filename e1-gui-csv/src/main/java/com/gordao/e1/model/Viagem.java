package com.gordao.e1.model;

public class Viagem {
  private String destino;
  private int milhas;
  private boolean internacional;

  public Viagem(String destino, int milhas, boolean internacional) {
    this.destino = destino;
    this.milhas = milhas;
    this.internacional = internacional;
  }

  public void viajar() { /* noop */ }
}
