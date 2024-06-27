package num01;
import java.util.Random;

//MEXER SE PRECISAR MUDAR ARQUIVOS
public class Tabuleiro {
    public char[][] tabuleiro;
    public final char[] simbolos = {'☠', '$', '✚', '☺', '☻', '✦', '☀'};
    public Random random;
    private final int tamanho = 8;

    public int getTamanho() {return tamanho;}

    Tabuleiro(){
        tabuleiro = new char[tamanho][tamanho];
        random = new Random();
        iniciar();
    }
    public void iniciar(){
        do {
            //cria uma matriz 8 x 8 aleatóriamente
            for (int l = 0; l < tamanho; l++) {
                for (int c = 0; c < tamanho; c++) {
                    tabuleiro[l][c] = simbolos[random.nextInt(simbolos.length)];
                }
            }
        } while (semTresAlinhados()); //enquanto não tiver 3 alinhados

    }
    public boolean semTresAlinhados() {
        //horizontal, verfica se o anterior e o proximo são iguais ao escolhido
        for (int l = 0; l < tamanho; l++) {
            for (int c = 1; c < tamanho - 1; c++) {
                if (tabuleiro[l][c] == tabuleiro[l][c - 1] && tabuleiro[l][c] == tabuleiro[l][c + 1]) {
                    return false;
                }
            }
        }
        //vertical, verfica se o anterior e o proximo são iguais ao escolhido
        for (int l = 1; l < tamanho - 1; l++) {
            for (int c = 0; c < tamanho; c++) {
                if (tabuleiro[l - 1][c] == tabuleiro[l][c] && tabuleiro[l + 1][c] == tabuleiro[l][c]) {
                    return false;
                }
            }
        }

        return true;
    }
    public void mostrarTabuleiro() {
        //só mostra o tabuleiro mesmo
        for (int l = 0; l < tamanho; l++) {
            for (int c = 0; c < tamanho; c++) {
                System.out.printf("%c ", tabuleiro[l][c]);
            }
            System.out.println();
        }
    }
    public boolean validaJogada (int linha, int coluna, char direcao) {
        //ve se o lugar escolhido existe na matriz
            switch (direcao) {
                //retorna true caso tudo estiver certo
                case 'w': return linha > 0;
                case 'a': return coluna > 0;
                case 's': return linha < tamanho - 1;
                case 'd': return coluna < tamanho - 1;
                //retorna falso se alguma jogada não existir na matriz
                default: return false;
           }

    }
    public void mexer(int linhaa, int colunaa, char direcaoo){
        //ex: linhaa= 2, colunaa = 3, direcao = w
        int novaLinha = linhaa;
        int novaColuna = colunaa;
        switch (direcaoo) {
            //move 1, depende do lado
            case 'w':
                novaLinha--; break;
                //ex: novo é linha 1 e coluna 3
            case 'a':
                novaColuna--; break;
            case 's':
                novaLinha++; break;
            case 'd':
                novaColuna++; break;
        }
        //Trocar os elementos
        char tabTemporario = tabuleiro[linhaa][colunaa]; //ex: antigo 2,3. Cria um novo pra poder fazer a troca
        tabuleiro[linhaa][colunaa] = tabuleiro[novaLinha][novaColuna];//ex: deixou o antigo 2,3 igual ao novo 1,3
        tabuleiro[novaLinha][novaColuna] = tabTemporario; //o antigo 1,3 virou 2,3

    }
    public void verCombos () {
        //esse while é pra n ter os 3 alinhados no começo
        while (semTresAlinhados()) {
            // vai até 5 pq compara com os 2 próximos
            for (int l = 0; l < tamanho; l++) {
                for (int c = 0; c < tamanho; c++) {
                    if (c <= 5 && tabuleiro[l][c] == tabuleiro[l][c + 1] && tabuleiro[l][c] == tabuleiro[l][c + 2]) {
                        //substirui por aleatório
                        tabuleiro[l][c] = simbolos[random.nextInt(simbolos.length)];
                        tabuleiro[l][c + 1] = simbolos[random.nextInt(simbolos.length)];
                        tabuleiro[l][c + 2] = simbolos[random.nextInt(simbolos.length)];
                    }
                    if (l <= 5 && tabuleiro[l][c] == tabuleiro[l + 1][c] && tabuleiro[l][c] == tabuleiro[l + 2][c]) {
                        //substirui por aleatório
                        tabuleiro[l][c] = simbolos[random.nextInt(simbolos.length)];
                        tabuleiro[l + 1][c] = simbolos[random.nextInt(simbolos.length)];
                        tabuleiro[l + 2][c] = simbolos[random.nextInt(simbolos.length)];
                    }
                }
            }
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
            case '☺':
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
        for (int l = 0; l < tamanho; l++) {
            for (int c = 0; c < tamanho; c++) {
                if (tabuleiro[l][c] == de) {
                    tabuleiro[l][c] = para;
                }
            }
        }
    }


}

