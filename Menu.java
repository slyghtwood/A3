package Oficial;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Menu {

    public static void menuMenuzao() {
        System.out.println("---------Menu---------");
        System.out.println("1. Nova partida");
        System.out.println("2. Recuperar partida anterior");
        System.out.println("3. Apagar algum jogo salvo");
        System.out.println("4. Sair do jogo");
        System.out.println("-----------------------");
    }

    public static void salvarJogo(Jogo jogo, String nomeArquivo) {
        List<String> dadosJogo = jogo.exportarDados();
        try {
            Files.write(Paths.get(nomeArquivo), dadosJogo);
            System.out.println("Jogo salvo com sucesso!");
        } catch (IOException e) {
            System.err.println("✘✘✘ Erro ao salvar o jogo: " + e.getMessage());
        }
    }

    public static Jogo carregarJogo(String nomeArquivo) {
        try {
            List<String> dadosJogo = Files.readAllLines(Paths.get(nomeArquivo));
            return Jogo.importarDados(dadosJogo);
        } catch (IOException e) {
            System.err.println("✘✘✘ Erro ao carregar o jogo: " + e.getMessage());
            return null;
        }
    }

    public static void apagarJogo(String nomeArquivo) {
        try {
            Files.deleteIfExists(Paths.get(nomeArquivo));
            System.out.println("Jogo apagado com sucesso!");
        } catch (IOException e) {
            System.err.println("✘✘✘ Erro ao apagar o jogo: " + e.getMessage());
        }
    }


}
