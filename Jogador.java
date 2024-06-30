package Oficial;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private int vida;
    private int ouro;
    private int experiencia;
    private String nome;
    private int jogadasExtras;

    public Jogador(String nome) {
        this.nome = nome;
        this.vida = 100;
        this.ouro = 0;
        this.experiencia = 0;
        this.jogadasExtras = 0;
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public int getVida() {return vida;}
    public void setVida(int vida) {this.vida = vida;}
    public int getOuro() {return ouro;}
    public void setOuro(int ouro) {this.ouro = ouro;}
    public int getExperiencia() {return experiencia;}
    public void setExperiencia(int experiencia) {this.experiencia = experiencia;}

    public int adicionaVida(int quant){return vida = vida + quant;}
    public int removeVida(int quant){return vida = vida - quant;}
    public int adicionaOuro(int quant){
        return ouro += quant;
    }
    public int adicionaEXP(int quant){
        return experiencia += quant;
    }
    public void ganharJogadaExtra() {jogadasExtras++;}
    public boolean temJogadaExtra() {return jogadasExtras > 0;}
    public void usarJogadaExtra() {
        if (temJogadaExtra()) {
            jogadasExtras--;
        }
    }

    @Override
    public String toString() {
        return "\n" + "Jogador: " + nome + "\n" +
                "Vida: " + vida + "\n" +
                "Ouro: " + ouro + "\n" +
                "Experiência: " + experiencia + "\n";
    }

    //salvar as informações do jogador
    public List<String> exportarDados() {
        List<String> dadosJogador = new ArrayList<>();
        dadosJogador.add(nome);
        dadosJogador.add(String.valueOf(vida));
        dadosJogador.add(String.valueOf(ouro));
        dadosJogador.add(String.valueOf(experiencia));
        return dadosJogador;
    }
    //pegar informações do jogador da partida anterior
    public void importarDados(List<String> dadosJogador) {
        this.nome = dadosJogador.get(0);
        this.vida = Integer.parseInt(dadosJogador.get(1));
        this.ouro = Integer.parseInt(dadosJogador.get(2));
        this.experiencia = Integer.parseInt(dadosJogador.get(3));
    }
}
