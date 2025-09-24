package com.gordao.e1.model;

public class Astronauta {
  private String nome;
  private String traje;
  private boolean emMissao;

  public Astronauta(String nome, String traje, boolean emMissao) {
    this.nome = nome;
    this.traje = traje;
    this.emMissao = emMissao;
  }

  public void explorarEspaco() { /* noop */ }
  public void comunicarBase() { /* noop */ }
  public void repararEquipamento(String qual) { /* noop */ }
}
