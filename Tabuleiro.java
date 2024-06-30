package Oficial;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tabuleiro {
    public static char[][] tabuleiro;
    public final char[] simbolos = {'☠', '$', '✚', 'V', 'A', '✦', '☀'};
    public Random random;
    private final int tamanho = 8;

    public int getTamanho() {
        return tamanho;
    }

    Tabuleiro() {
        tabuleiro = new char[tamanho][tamanho];
        random = new Random();
        iniciar();
    }

    public void iniciar() {
        do {
            // Cria uma matriz 8 x 8 aleatoriamente
            for (int l = 0; l < tamanho; l++) {
                for (int c = 0; c < tamanho; c++) {
                    tabuleiro[l][c] = simbolos[random.nextInt(simbolos.length)];
                }
            }
        } while (semTresAlinhados()); // Enquanto não tiver 3 alinhados
    }

    public boolean semTresAlinhados() {
        // Horizontal, verifica se o anterior e o próximo são iguais ao escolhido
        for (int l = 0; l < tamanho; l++) {
            for (int c = 1; c < tamanho - 1; c++) {
                if (tabuleiro[l][c] == tabuleiro[l][c - 1] && tabuleiro[l][c] == tabuleiro[l][c + 1]) {
                    return true;
                }
            }
        }
        // Vertical, verifica se o anterior e o próximo são iguais ao escolhido
        for (int l = 1; l < tamanho - 1; l++) {
            for (int c = 0; c < tamanho; c++) {
                if (tabuleiro[l - 1][c] == tabuleiro[l][c] && tabuleiro[l + 1][c] == tabuleiro[l][c]) {
                    return true;
                }
            }
        }

        return false;
    }

    public void mostrarTabuleiro() {
        // Mostra o tabuleiro
        for (int l = 0; l < tamanho; l++) {
            for (int c = 0; c < tamanho; c++) {
                System.out.printf("%c ", tabuleiro[l][c]);
            }
            System.out.println();
        }
    }

    public boolean validaJogada(int linha, int coluna, char direcao) {
        // Verifica se o lugar escolhido existe na matriz
        switch (direcao) {
            case 'w':
                return linha > 0;
            case 'a':
                return coluna > 0;
            case 's':
                return linha < tamanho - 1;
            case 'd':
                return coluna < tamanho - 1;
            default:
                return false;
        }
    }

    public void mexer(int linha, int coluna, char direcao, Jogador jogadorAtual, Jogador jogadorOponente) {
        int novaLinha = linha;
        int novaColuna = coluna;
        //muda a direção de 1 em 1, w a s d
        switch (direcao) {
            case 'w':
                novaLinha--;
                break;
            case 'a':
                novaColuna--;
                break;
            case 's':
                novaLinha++;
                break;
            case 'd':
                novaColuna++;
                break;
        }
        // Trocar os elementos
        char temp = tabuleiro[linha][coluna];
        tabuleiro[linha][coluna] = tabuleiro[novaLinha][novaColuna];
        tabuleiro[novaLinha][novaColuna] = temp;
        //coloca combo e gravidade
        while (verERemoverCombo(jogadorAtual, jogadorOponente)) {
            aplicarGravidade(jogadorAtual, jogadorOponente);
        }
    }

    private boolean verERemoverCombo(Jogador jogadorAtual, Jogador jogadorOponente) {
        boolean temCombinacao = false;
        boolean[][] paraRemover = new boolean[tamanho][tamanho];
        boolean ganhouJogadaExtra = false;

        //até -3 pq ele compara com próximos 3, só pra combo de 4
        for (int l = 0; l < tamanho; l++) {
            for (int c = 0; c < tamanho - 3; c++) {
                //ve se tem igual na horizontal
                if (tabuleiro[l][c] == tabuleiro[l][c + 1] && tabuleiro[l][c] == tabuleiro[l][c + 2] && tabuleiro[l][c] == tabuleiro[l][c + 3]) {
                    //diz onde tem q remover
                    paraRemover[l][c] = paraRemover[l][c + 1] = paraRemover[l][c + 2] = paraRemover[l][c + 3] = true;
                    temCombinacao = true;
                    //aplica jogada extra
                    ganhouJogadaExtra = true;
                    //aplica combo
                    aplicarEfeitoSimbolo(jogadorAtual, jogadorOponente, tabuleiro[l][c]);
                    aplicarEfeitoSimbolo(jogadorAtual, jogadorOponente, tabuleiro[l][c]);
                    aplicarEfeitoSimbolo(jogadorAtual, jogadorOponente, tabuleiro[l][c]);
                    aplicarEfeitoSimbolo(jogadorAtual, jogadorOponente, tabuleiro[l][c]);
                }
            }
        }

        //até -3 pq ele compara com próximos 3, só pra combo de 4
        for (int l = 0; l < tamanho - 3; l++) {
            for (int c = 0; c < tamanho; c++) {
                //ve se tem igual na vertical
                if (tabuleiro[l][c] == tabuleiro[l + 1][c] && tabuleiro[l][c] == tabuleiro[l + 2][c] && tabuleiro[l][c] == tabuleiro[l + 3][c]) {
                    //diz onde tem q remover
                    paraRemover[l][c] = paraRemover[l + 1][c] = paraRemover[l + 2][c] = paraRemover[l + 3][c] = true;
                    temCombinacao = true;
                    //aplica jogada extra
                    ganhouJogadaExtra = true;
                    //aplica combo
                    aplicarEfeitoSimbolo(jogadorAtual, jogadorOponente, tabuleiro[l][c]);
                    aplicarEfeitoSimbolo(jogadorAtual, jogadorOponente, tabuleiro[l][c]);
                    aplicarEfeitoSimbolo(jogadorAtual, jogadorOponente, tabuleiro[l][c]);
                    aplicarEfeitoSimbolo(jogadorAtual, jogadorOponente, tabuleiro[l][c]);
                }
            }
        }

        //verifica combinações de 3 símbolos (horizontal e vertical)
        for (int l = 0; l < tamanho; l++) {
            for (int c = 0; c < tamanho - 2; c++) {
                if (tabuleiro[l][c] == tabuleiro[l][c + 1] && tabuleiro[l][c] == tabuleiro[l][c + 2]) {
                    //diz onde tem q remover
                    paraRemover[l][c] = paraRemover[l][c + 1] = paraRemover[l][c + 2] = true;
                    //aplica combo
                    temCombinacao = true;
                    aplicarEfeitoSimbolo(jogadorAtual, jogadorOponente, tabuleiro[l][c]);
                    aplicarEfeitoSimbolo(jogadorAtual, jogadorOponente, tabuleiro[l][c]);
                    aplicarEfeitoSimbolo(jogadorAtual, jogadorOponente, tabuleiro[l][c]);
                }
            }
        }

        for (int l = 0; l < tamanho - 2; l++) {
            for (int c = 0; c < tamanho; c++) {
                if (tabuleiro[l][c] == tabuleiro[l + 1][c] && tabuleiro[l][c] == tabuleiro[l + 2][c]) {
                    //diz onde tem q remover
                    paraRemover[l][c] = paraRemover[l + 1][c] = paraRemover[l + 2][c] = true;
                    //aplica combo
                    temCombinacao = true;
                    aplicarEfeitoSimbolo(jogadorAtual, jogadorOponente, tabuleiro[l][c]);
                    aplicarEfeitoSimbolo(jogadorAtual, jogadorOponente, tabuleiro[l][c]);
                    aplicarEfeitoSimbolo(jogadorAtual, jogadorOponente, tabuleiro[l][c]);
                }
            }
        }

        //remove os simbolos se fizer combo, tranforma num espaço vazio
        for (int l = 0; l < tamanho; l++) {
            for (int c = 0; c < tamanho; c++) {
                if (paraRemover[l][c]) {
                    tabuleiro[l][c] = ' ';
                }
            }
        }

        //adiciona jogada extra
        if (ganhouJogadaExtra) {
            jogadorAtual.ganharJogadaExtra();
        }

        return temCombinacao;
    }


    private void aplicarGravidade(Jogador jogadorAtual, Jogador jogadorOponente) {
        boolean teveMudanca;
        do {
            teveMudanca = false;
            for (int c = 0; c < tamanho; c++) {
                for (int l = tamanho - 1; l >= 0; l--) {
                    if (tabuleiro[l][c] == ' ') {
                        int k = l; //busca na posição atual
                        while (k >= 0 && tabuleiro[k][c] == ' ') {//sobe enquanto encontrar espaços vazios
                            k--;
                        }
                        if (k >= 0) { //pra achar um simbolo acima do vazio
                            tabuleiro[l][c] = tabuleiro[k][c];// move o símbolo encontrado pra posição do espaço vazio
                            tabuleiro[k][c] = ' '; //define a posição original do símbolo como vazia
                            teveMudanca = true;
                        } else {
                            tabuleiro[l][c] = simbolos[random.nextInt(simbolos.length)];// preenche o vazio com símbolo aleatório
                        }
                    }
                }
            }
        } while (teveMudanca);

        //aplica a gravidade se tiver espaõ vazio
        while (verERemoverCombo(jogadorAtual, jogadorOponente)) {
            teveMudanca = true;
            aplicarGravidade(jogadorAtual, jogadorOponente);
        }
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
            case 'V':
                for (int l = 0; l < tamanho; l++) {
                    for (int c = 0; c < tamanho; c++) {
                        if (tabuleiro[l][c] == '☠') {
                            tabuleiro[l][c] = '✚';
                        }
                    }
                }
                break;
            case 'A':
                for (int l = 0; l < tamanho; l++) {
                    for (int c = 0; c < tamanho; c++) {
                        if (tabuleiro[l][c] == '✚') {
                            tabuleiro[l][c] = '☠';
                        }
                    }
                }
                break;
            case '☀':
                jogadorOponente.setOuro(0);
                break;
            case '✦':
                jogadorAtual.adicionaEXP(1);
                break;
        }
    }
    //salvar os dados do tabuleiro
    public static List<String> exportarDados() {
        List<String> dadosTabuleiro = new ArrayList<>();
        for (char[] linha : tabuleiro) {
            dadosTabuleiro.add(new String(linha));
        }
        return dadosTabuleiro;
    }
    //mostrar os dados do tabuleiro quando for recuperar a partida
    public void importarDados(List<String> dadosTabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            tabuleiro[i] = dadosTabuleiro.get(i).toCharArray();
        }
    }
}
