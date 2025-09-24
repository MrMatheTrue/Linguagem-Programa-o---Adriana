package com.gordao.e1.model;

public class Computador {
  private String modelo;
  private int memoriaRAM;
  private boolean ligado;

  public Computador(String modelo, int memoriaRAM, boolean ligado) {
    this.modelo = modelo;
    this.memoriaRAM = memoriaRAM;
    this.ligado = ligado;
  }

  public void ligar() { this.ligado = true; }
  public void processarDados(String d) { /* noop */ }
  public void desligar() { this.ligado = false; }
}
