package num01;

import java.io.IOException;
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
                    System.out.println("---------Salvar o jogo? (s/n)");
                    String opcaoo = scanner.next();
                    if (opcaoo.equalsIgnoreCase("s")) {
                        System.out.println("Digite o nome do arquivo para salvar:");
                        String nomeArquivo = scanner.next();
                        //BRENDAAAAAAAAAAAAAAAA
                        //colocar a lógica q tu vai botar de salvar jogo
                    }
                    break;
                case 2:
                    //BRENDAAAAAAAAAAAAAAAA
                    //implementa o método de carregar jogo do menu
                    /*try {
                        Jogo jogoCarregado = carregarJogo(scanner);
                        if (jogoCarregado != null) {
                            jogoCarregado.jogar();
                        } else {
                            System.out.println("Erro ao carregar o jogo.");
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Erro ao carregar o jogo: " + e.getMessage());
                    }*/

                    break;
                case 3:
                    //BRENDAAAAAAAAAAAAAAAA
                    //implementa método apagarjogo do menu
                    /*
                    try {
                        apagarJogo(scanner);
                    } catch (IOException e) {
                        System.out.println("Erro ao apagar o jogo: " + e.getMessage());
                    }
                    */

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
