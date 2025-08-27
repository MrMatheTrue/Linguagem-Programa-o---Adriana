package exercicio8;

public class Wifi {

	private String nomeRede;
    private String senha;
    private boolean conectado;

    public Wifi(String nomeRede, String senha) {
        this.nomeRede = nomeRede;
        this.senha = senha;
        this.conectado = false;
    }

    public void conectar() {
        if (!conectado) {
            conectado = true;
            System.out.println("Conectado à rede: " + nomeRede);
        } else {
            System.out.println("Já está conectado.");
        }
    }

    // getters/setters
    public String getNomeRede() { return nomeRede; }
    public void setNomeRede(String nomeRede) { this.nomeRede = nomeRede; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public boolean isConectado() { return conectado; }
}