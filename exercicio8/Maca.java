package exercicio8;

public class Maca {
    private String nome;
    private int paciencia; // 0..100
    private String estado;

    public Maca(String nome, int paciencia, String estado) {
        this.nome = nome;
        this.paciencia = paciencia;
        this.estado = estado;
    }

    public void responderProvocacao() {
        if (paciencia > 0) {
            System.out.println(nome + ": Para com isso!");
        } else {
            gritar();
        }
    }

    public void reduzirPaciencia(int qtd) {
        paciencia = Math.max(0, paciencia - qtd);
        if (paciencia == 0) {
            estado = "furiosa";
        }
    }

    public void gritar() {
        System.out.println(nome + " GRITA! (estado: " + estado + ")");
    }

    // getters/setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getPaciencia() { return paciencia; }
    public void setPaciencia(int paciencia) { this.paciencia = paciencia; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}