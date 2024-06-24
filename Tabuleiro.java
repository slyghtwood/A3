package num01;
import java.util.Random;
public class Tabuleiro {
    public char[][] tabuleiro;
    public final char[] simbolos = {'☠', '$', '✚', '☺', '☻', '✦', '☀'};
    public Random random;
    private int tamanho = 8;

    public int getTamanho() {return tamanho;}

    Tabuleiro(){
        tabuleiro = new char[tamanho][tamanho];
    }
    public void iniciar(){

    }
    public void tresAlinhados(){

    }
    //toString
    public void validarJogada(){

    }
    public void mexer(int linha, int coluna, char direcao){

    }
    public void verCombos(){
        //verificar se tem 3 alinhados pelo jogador, coloca o combo relacionado ao símbolo e substitui aleatóriamente
        //Atençaõ: ver verticalmente e horizontalmente
    }
    public void preenchervazio(){

    }

    public void transformarElemento(char de, char para) {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (tabuleiro[i][j] == de) {
                    tabuleiro[i][j] = para;
                }
            }
        }
    }
}
