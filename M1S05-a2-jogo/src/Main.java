import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Jogador> ranking = new ArrayList<>();

        // Jogadores
        ranking.add(new Jogador("Fulano", 18, 199, 8));
        ranking.add(new Jogador("Beltrano", 16, 183, 3));
        ranking.add(new Jogador("Sicrano", 7, 173, 8));
        ranking.add(new Jogador("Fulano de tal", 9, 152, 5));
        ranking.add(new Jogador("Beltrano de tal", 47, 123, 6));

        // Crtiando novo jogador/
        Jogador novoJogador = new Jogador("Novo Jogador", 25, 210, 7);
        ranking.add(novoJogador);

        // Organiza os jogadores pela pontuação
        ranking.sort(Comparator.comparingInt(Jogador::getPontuacao).reversed());

        // limita a lista aos top 10 jogadores
        List<Jogador> top10 = ranking.subList(0, Math.min(ranking.size(), 10));

        // ranking dos TOP10 jogadores
        for (int i = 0; i < top10.size(); i++) {
            Jogador jogador = top10.get(i);
            System.out.println(jogador.getNome() + " - Posição: " + (i + 1));
        }
    }
}
