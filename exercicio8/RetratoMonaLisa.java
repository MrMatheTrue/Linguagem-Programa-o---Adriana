package exercicio8;

public class RetratoMonaLisa {
    private int larguraCm;
    private int alturaCm;
    private String fundo;

    public RetratoMonaLisa(int larguraCm, int alturaCm, String fundo) {
        this.larguraCm = larguraCm;
        this.alturaCm = alturaCm;
        this.fundo = fundo;
    }

    public void compor(GeleiaUva geleia, ManteigaAmendoim manteiga) {
        System.out.println("Compondo retrato (" + larguraCm + "x" + alturaCm + " cm) com fundo '" +
                fundo + "'.");
        geleia.espalhar(larguraCm * alturaCm * 0.4);
        manteiga.darVolume("rosto");
    }

    // getters/setters
    public int getLarguraCm() { return larguraCm; }
    public void setLarguraCm(int larguraCm) { this.larguraCm = larguraCm; }
    public int getAlturaCm() { return alturaCm; }
    public void setAlturaCm(int alturaCm) { this.alturaCm = alturaCm; }
    public String getFundo() { return fundo; }
    public void setFundo(String fundo) { this.fundo = fundo; }
}