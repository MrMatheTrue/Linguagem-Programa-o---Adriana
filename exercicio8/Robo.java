package exercicio8;

public class Robo {
    private String identificador;
    private String funcao;
    private int nivelBateria; // 0..100

    public Robo(String identificador, String funcao, int nivelBateria) {
        this.identificador = identificador;
        this.funcao = funcao;
        this.nivelBateria = nivelBateria;
    }

    public void executarTarefa() {
        if (nivelBateria > 10) {
            nivelBateria -= 10;
            System.out.println("Robô " + identificador + " executando: " + funcao +
                    ". Bateria: " + nivelBateria + "%");
        } else {
            System.out.println("Bateria baixa! Recarregue primeiro.");
        }
    }

    public void recarregar() {
        nivelBateria = 100;
        System.out.println("Robô " + identificador + " recarregado (100%).");
    }

    public void reportarStatus() {
        System.out.println("Robô " + identificador + " | Função: " + funcao +
                " | Bateria: " + nivelBateria + "%");
    }

    // getters/setters
    public String getIdentificador() { return identificador; }
    public void setIdentificador(String identificador) { this.identificador = identificador; }
    public String getFuncao() { return funcao; }
    public void setFuncao(String funcao) { this.funcao = funcao; }
    public int getNivelBateria() { return nivelBateria; }
    public void setNivelBateria(int nivelBateria) { this.nivelBateria = nivelBateria; }
}