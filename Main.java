package num01;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("--------- Saindo do jogo...");
                    return;
                default:
                    System.out.println("✘✘✘ Opção inválida! Tente novamente.");
            }
        }
    }
}
