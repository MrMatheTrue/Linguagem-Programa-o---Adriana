package exercicio8;

public class LaranjaIrritante {
    private String nome;
    private int volumeVoz;      // 0..100
    private int nivelIrritacao; // 0..100

    public LaranjaIrritante(String nome, int volumeVoz, int nivelIrritacao) {
        this.nome = nome;
        this.volumeVoz = volumeVoz;
        this.nivelIrritacao = nivelIrritacao;
    }

    public void provocar(Maca alvo) {
        System.out.println(nome + ": Ei, " + alvo.getNome() + "! Hehehe!");
        alvo.reduzirPaciencia(10);
        aumentarIrritacao(5);
    }

    public void rir() {
        System.out.println(nome + " ri alto (volume " + volumeVoz + ").");
    }

    public void aumentarIrritacao(int qtd) {
        nivelIrritacao = Math.min(100, nivelIrritacao + qtd);
    }

    // getters/setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getVolumeVoz() { return volumeVoz; }
    public void setVolumeVoz(int volumeVoz) { this.volumeVoz = volumeVoz; }
    public int getNivelIrritacao() { return nivelIrritacao; }
    public void setNivelIrritacao(int nivelIrritacao) { this.nivelIrritacao = nivelIrritacao; }
}