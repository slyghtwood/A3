package num01;

import java.io.Serializable;
import java.util.Scanner;


public class Jogo implements Serializable{

    Jogador jogador1;
    Jogador jogador2;
    Tabuleiro tabuleiro;
    Scanner scanner = new Scanner(System.in);
    Jogo(String nomeJogador1, String nomeJogador2) {
        jogador1 = new Jogador(nomeJogador1);
        jogador2 = new Jogador(nomeJogador2);
        tabuleiro = new Tabuleiro();
    }
    public void jogar() {
        while (jogador1.getVida() > 0 && jogador2.getVida() > 0) {
            turno(jogador1, jogador2);
            if (jogador2.getVida() > 0) {
                turno(jogador2, jogador1);
            }
        }
        System.out.println("FIM de jogo!!!!");
        if (jogador1.getVida() > 0) {
            System.out.println(jogador1.getNome() + " venceuuuu!");
        } else {
            System.out.println(jogador2.getNome() + " venceuuuu!");
        }
    }
    public void turno(Jogador jogadorAtual, Jogador jogadorOponente){
        tabuleiro.mostrarTabuleiro();
        System.out.println(jogadorAtual.getNome() + ", sua vez de jogar");
        System.out.println(jogadorAtual);

        boolean jogadaValida = false;
        while (jogadaValida == false) {
            System.out.println("Digite a posição por linha x coluna (começa em 0) e a direção (w, a, s, d) para mover:");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();
            char direcao = scanner.next().charAt(0);

            if (tabuleiro.validaJogada(linha, coluna, direcao)) {
                tabuleiro.mexer(linha, coluna, direcao,jogadorAtual, jogadorOponente);
                aplicarEfeito(jogadorAtual, jogadorOponente, linha, coluna, direcao);
                jogadaValida = true;
            } else {
                System.out.println("Jogada inválida! Tente novamente.");
            }
        }
    }
    void aplicarEfeito(Jogador jogadorAtual, Jogador jogadorOponente, int linha, int coluna, char direcao) {
        int novaLinha = linha, novaColuna = coluna;
        switch (direcao) {
            case 'w': novaLinha--; break;
            case 'a': novaColuna--; break;
            case 's': novaLinha++; break;
            case 'd': novaColuna++; break;
        }
        char elemento = tabuleiro.tabuleiro[novaLinha][novaColuna];
        tabuleiro.aplicarEfeitoSimbolo(jogadorAtual, jogadorOponente, elemento);
    }


}
