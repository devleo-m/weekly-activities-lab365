import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Jogador> ranking = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Jogadores existentes
        ranking.add(new Jogador("Fulano", 18, 199, 8));
        ranking.add(new Jogador("Beltrano", 16, 183, 3));
        ranking.add(new Jogador("Sicrano", 7, 173, 8));
        ranking.add(new Jogador("Fulano de tal", 9, 152, 5));
        ranking.add(new Jogador("Beltrano de tal", 47, 123, 6));

        // Criando novo jogador
        Jogador novoJogador;
        do {
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

                novoJogador = new Jogador(novoNome, novaIdade, novaPontuacao, novoNumeroTentativas);
                ranking.add(novoJogador);
                break;  // Sai do loop se o nome for único
            } else {
                System.out.println("Nome já existente. Escolha outro nome.");
            }
        } while (true);

        scanner.close();

        // Organiza os jogadores pela pontuação
        ranking.sort(Comparator.comparingInt(Jogador::getPontuacao).reversed());

        // Limita a lista aos top 10 jogadores
        List<Jogador> top10 = ranking.subList(0, Math.min(ranking.size(), 10));

        // Ranking dos TOP10 jogadores
        for (int i = 0; i < top10.size(); i++) {
            Jogador jogador = top10.get(i);
            System.out.println(jogador.getNome() + " - Posição: " + (i + 1));
        }
    }
}
