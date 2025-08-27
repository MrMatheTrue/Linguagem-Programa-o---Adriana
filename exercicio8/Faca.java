package exercicio8;

public class Faca {
    private int afiacao;        // 0..100
    private String material;
    private String posicao;

    public Faca(int afiacao, String material, String posicao) {
        this.afiacao = afiacao;
        this.material = material;
        this.posicao = posicao;
    }

    public void aproximarDoAlvo(Maca alvo) {
        posicao = "perto de " + alvo.getNome();
        System.out.println("Faca aproximou-se: " + posicao);
    }

    public void cortar(Maca alvo) {
        System.out.println("Cortando " + alvo.getNome() + " (imagético da cena).");
    }

    public void afiar(int qtd) {
        afiacao = Math.min(100, afiacao + qtd);
        System.out.println("Faca afiada. Afiacao: " + afiacao);
    }

    // getters/setters
    public int getAfiacao() { return afiacao; }
    public void setAfiacao(int afiacao) { this.afiacao = afiacao; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public String getPosicao() { return posicao; }
    public void setPosicao(String posicao) { this.posicao = posicao; }
}