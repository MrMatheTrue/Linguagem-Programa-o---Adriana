package exercicio8;

public class Astronauta {
    private String nome;
    private String traje;
    private boolean emMissao;

    public Astronauta(String nome, String traje, boolean emMissao) {
        this.nome = nome;
        this.traje = traje;
        this.emMissao = emMissao;
    }

    public void explorarEspaco() {
        System.out.println(nome + " está explorando o espaço com traje " + traje + ".");
    }

    public void comunicarBase() {
        System.out.println(nome + " comunicando com a base: Tudo certo!");
    }

    public void repararEquipamento(String equipamento) {
        System.out.println(nome + " reparando o equipamento: " + equipamento);
    }

    // getters/setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTraje() { return traje; }
    public void setTraje(String traje) { this.traje = traje; }
    public boolean isEmMissao() { return emMissao; }
    public void setEmMissao(boolean emMissao) { this.emMissao = emMissao; }
}