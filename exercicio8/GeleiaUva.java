package exercicio8;

public class GeleiaUva {
    private String tonalidade;
    private double viscosidade;
    private double quantidade; // em gramas

    public GeleiaUva(String tonalidade, double viscosidade, double quantidade) {
        this.tonalidade = tonalidade;
        this.viscosidade = viscosidade;
        this.quantidade = quantidade;
    }

    public void espalhar(double areaCm2) {
        System.out.println("Espalhando geleia (" + tonalidade + ") em " + areaCm2 + " cm².");
    }

    // getters/setters
    public String getTonalidade() { return tonalidade; }
    public void setTonalidade(String tonalidade) { this.tonalidade = tonalidade; }
    public double getViscosidade() { return viscosidade; }
    public void setViscosidade(double viscosidade) { this.viscosidade = viscosidade; }
    public double getQuantidade() { return quantidade; }
    public void setQuantidade(double quantidade) { this.quantidade = quantidade; }
}