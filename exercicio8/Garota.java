package exercicio8;

public class Garota {

	private String nome;
    private int idade;
    private String sotaque;

    public Garota(String nome, int idade, String sotaque) {
        this.nome = nome;
        this.idade = idade;
        this.sotaque = sotaque;
    }

    public void falar() {
        System.out.println(nome + " (sotaque " + sotaque + "): Oi!");
    }

    // getters/setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public String getSotaque() { return sotaque; }
    public void setSotaque(String sotaque) { this.sotaque = sotaque; }
}
