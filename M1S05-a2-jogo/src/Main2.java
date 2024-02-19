import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        List<Jogador> ranking = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Jogadores existentes
        ranking.add(new Jogador("Fulano", 18, 199, 8));
        ranking.add(new Jogador("Beltrano", 16, 183, 3));
        ranking.add(new Jogador("Sicrano", 7, 173, 8));
        ranking.add(new Jogador("Fulano de tal", 9, 152, 5));
        ranking.add(new Jogador("Beltrano de tal", 47, 123, 6));

        while (true) {
            System.out.println("Bem-vindo ao Jogo!");

            System.out.println("Escolha uma opção:");
            System.out.println("1 - Ver Ranking Completo");
            System.out.println("2 - Ver Top 10");
            System.out.println("3 - Criar Novo Jogador");
            System.out.println("0 - Encerrar o Jogo");

            System.out.print("Opção escolhida: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

            switch (opcao) {
                case 1:
                    exibirRankingCompleto(ranking);
                    break;
                case 2:
                    exibirTop10(ranking);
                    break;
                case 3:
                    criarNovoJogador(ranking, scanner);
                    break;
                case 0:
                    System.out.println("Jogo encerrado. Até mais!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void criarNovoJogador(List<Jogador> ranking, Scanner scanner) {
        System.out.print("Digite o nome do novo jogador: ");
        String novoNome = scanner.nextLine();

        // Verificando se o nome já existe
        boolean nomeExistente = ranking.stream().anyMatch(j -> j.getNome().equalsIgnoreCase(novoNome));

        if (!nomeExistente) {
            System.out.print("Digite a idade do novo jogador: ");
            int novaIdade = scanner.nextInt();

            System.out.print("Digite a pontuação do novo jogador: ");
            int novaPontuacao = scanner.nextInt();

            System.out.print("Digite o número de tentativas do novo jogador: ");
            int novoNumeroTentativas = scanner.nextInt();

            Jogador novoJogador = new Jogador(novoNome, novaIdade, novaPontuacao, novoNumeroTentativas);
            ranking.add(novoJogador);
            System.out.println("Novo jogador criado: " + novoNome);
        } else {
            System.out.println("Nome já existente. Escolha outro nome.");
        }
    }

    private static void exibirRankingCompleto(List<Jogador> ranking) {
        System.out.println("Ranking Completo:");

        if (ranking.isEmpty()) {
            System.out.println("O ranking está vazio. Nenhum jogador registrado ainda.");
        } else {
            for (int i = 0; i < ranking.size(); i++) {
                Jogador jogador = ranking.get(i);
                System.out.println((i + 1) + ". " + jogador.getNome() + " - Pontuação: " + jogador.getPontuacao());
            }
        }
    }

    private static void exibirTop10(List<Jogador> ranking) {
        System.out.println("Top 10 Jogadores:");

        if (ranking.isEmpty()) {
            System.out.println("O ranking está vazio. Nenhum jogador registrado ainda.");
        } else {
            int limite = Math.min(ranking.size(), 10);
            for (int i = 0; i < limite; i++) {
                Jogador jogador = ranking.get(i);
                System.out.println((i + 1) + ". " + jogador.getNome() + " - Pontuação: " + jogador.getPontuacao());
            }
        }
    }
}
