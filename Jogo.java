package num01;

import java.util.Scanner;

public class Jogo {
    Jogador jogador1;
    Jogador jogador2;
    Tabuleiro tabuleiro;
    Jogo(String nomeJogador1, String nomeJogador2) {
        jogador1 = new Jogador();
        jogador2 = new Jogador();
        tabuleiro = new Tabuleiro();
    }
    public void jogar() {
        //while pra vida dos jogadores diferente de 0, se não acabar jogo
    }
    public void turno(){

    }

    public void aplicarEfeitoSimbolo(Jogador jogadorAtual, Jogador jogadorOponente, char simbolo) {
        switch (simbolo) {
            case '☠':
                jogadorOponente.removeVida(1);
                break;
            case '$':
                jogadorAtual.adicionaOuro(1);
                break;
            case '✚':
                jogadorAtual.adicionaVida(1);
                break;
            case '☺':
                //ver como colocar esse método no tabuleiro
                transformarElementos('☠', '✚');
                break;
            case '☻':
                transformarElementos('✚', '☠');
                break;
            case '☀':
                jogadorOponente.setOuro(0);
                break;
            case '✦':
                jogadorAtual.adicionaEXP(1);
                break;
        }
    }
    public void transformarElementos(char de, char para) {
        for (int i = 0; i < tabuleiro.getTamanho(); i++) {
            for (int j = 0; j < tabuleiro.getTamanho(); j++) {
                if (tabuleiro.tabuleiro[i][j] == de) {
                    tabuleiro.tabuleiro[i][j] = para;
                }
            }
        }
    }

}
