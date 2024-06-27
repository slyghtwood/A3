package num01;

//NÃO MEXER
public class Jogador {
    private int vida;
    private int ouro;
    private int experiencia;
    private String nome;

    public Jogador(String nome) {
        this.nome = nome;
        this.vida = 100;
        this.ouro = 0;
        this.experiencia = 0;
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public int getVida() {return vida;}
    public void setVida(int vida) {this.vida = vida;}
    public int getOuro() {return ouro;}
    public void setOuro(int ouro) {this.ouro = ouro;}
    public int getExperiencia() {return experiencia;}
    public void setExperiencia(int experiencia) {this.experiencia = experiencia;}

    public int adicionaVida(int quant){
        return vida += quant;
    }
    public int removeVida(int quant){
        return vida -= quant;
    }
    public int adicionaOuro(int quant){
        return ouro += quant;
    }
    public int adicionaEXP(int quant){
        return experiencia += quant;
    }

    @Override
    public String toString() {
        return "\n" + "Jogador: " + nome + "\n" +
                "Vida: " + vida + "\n" +
                "Ouro: " + ouro + "\n" +
                "Experiência: " + experiencia + "\n";
    }
}
