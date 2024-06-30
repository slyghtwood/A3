package Oficial;

import java.util.Scanner;
import static Oficial.Menu.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu.menuMenuzao();

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("---------Jogador 1 (só letras):");
                    String nomeJogador1 = scanner.nextLine();
                    System.out.println("---------Jogador 2 (só letras):");
                    String nomeJogador2 = scanner.nextLine();
                    Jogo jogo = new Jogo(nomeJogador1, nomeJogador2);
                    jogo.jogar();
                    System.out.println("---------Salvar o jogo? (s/n)");
                    String opcaoSalvar = scanner.next();
                    if (opcaoSalvar.equalsIgnoreCase("s")) {
                        System.out.println("---------Digite o nome do arquivo para salvar:");
                        String nomeArquivo = scanner.next();
                        salvarJogo(jogo, nomeArquivo);
                    }
                    break;
                case 2:
                    System.out.println("---------Digite o nome do arquivo para carregar:");
                    String nomeArquivoCarregar = scanner.next();
                    Jogo jogoCarregado = carregarJogo(nomeArquivoCarregar);
                    if (jogoCarregado != null) {
                        jogoCarregado.jogar();
                    } else {
                        System.out.println("✘✘✘Erro ao carregar o jogo.");
                    }
                    break;
                case 3:
                    System.out.println("---------Digite o nome do arquivo para apagar:");
                    String nomeArquivoApagar = scanner.next();
                    apagarJogo(nomeArquivoApagar);
                    break;
                case 4:
                    System.out.println("--------- Saindo do jogo...");
                    System.exit(0);
                    return;
                default:
                    System.out.println("✘✘✘ Opção inválida! Tente novamente.");
            }
        }
    }

}
