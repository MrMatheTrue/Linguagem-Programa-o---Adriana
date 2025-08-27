package exercicio8;

public class Computador {
    private String modelo;
    private int memoriaRAM;
    private boolean ligado;

    public Computador(String modelo, int memoriaRAM) {
        this.modelo = modelo;
        this.memoriaRAM = memoriaRAM;
        this.ligado = false;
    }

    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("Computador " + modelo + " ligado.");
        }
    }

    public void processarDados(String dados) {
        if (ligado) {
            System.out.println("Processando dados: " + dados + " (" + memoriaRAM + " GB RAM)");
        } else {
            System.out.println("Não é possível processar. O computador está desligado.");
        }
    }

    public void desligar() {
        if (ligado) {
            ligado = false;
            System.out.println("Computador " + modelo + " desligado.");
        }
    }

    // getters/setters
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public int getMemoriaRAM() { return memoriaRAM; }
    public void setMemoriaRAM(int memoriaRAM) { this.memoriaRAM = memoriaRAM; }
    public boolean isLigado() { return ligado; }
}