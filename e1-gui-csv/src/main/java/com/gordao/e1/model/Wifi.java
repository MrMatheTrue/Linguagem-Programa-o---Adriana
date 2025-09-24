package com.gordao.e1.model;

public class Wifi {
  private String nomeRede;
  private String senha;
  private boolean conectado;

  public Wifi(String nomeRede, String senha, boolean conectado) {
    this.nomeRede = nomeRede;
    this.senha = senha;
    this.conectado = conectado;
  }

  public void conectar() {
    this.conectado = true;
  }
}
