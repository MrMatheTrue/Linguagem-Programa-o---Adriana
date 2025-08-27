package exercicio8;

public class ManteigaAmendoim {
    private String textura;
    private double oleosidade;
    private double quantidade; // em gramas

    public ManteigaAmendoim(String textura, double oleosidade, double quantidade) {
        this.textura = textura;
        this.oleosidade = oleosidade;
        this.quantidade = quantidade;
    }

    public void darVolume(String regiao) {
        System.out.println("Dando volume com manteiga de amendoim na região: " + regiao);
    }

    // getters/setters
    public String getTextura() { return textura; }
    public void setTextura(String textura) { this.textura = textura; }
    public double getOleosidade() { return oleosidade; }
    public void setOleosidade(double oleosidade) { this.oleosidade = oleosidade; }
    public double getQuantidade() { return quantidade; }
    public void setQuantidade(double quantidade) { this.quantidade = quantidade; }
}