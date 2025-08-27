package exercicio8;

public class Viagem {
    private String destino;
    private int milhas;
    private boolean internacional;

    public Viagem(String destino, int milhas, boolean internacional) {
        this.destino = destino;
        this.milhas = milhas;
        this.internacional = internacional;
    }

    public void viajar() {
        System.out.println("Viajando para " + destino + " (" + milhas +
                " milhas) " + (internacional ? "no exterior." : "no país."));
    }

    // getters/setters
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }
    public int getMilhas() { return milhas; }
    public void setMilhas(int milhas) { this.milhas = milhas; }
    public boolean isInternacional() { return internacional; }
    public void setInternacional(boolean internacional) { this.internacional = internacional; }
}