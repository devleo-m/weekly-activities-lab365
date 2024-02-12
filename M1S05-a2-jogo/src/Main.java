import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Jogador> ranking = new ArrayList<>();

        Jogador jogador1 = new Jogador("Fulano", 18, 199, 8);
        Jogador jogador2 = new Jogador("Beltrano", 16, 183, 3);
        Jogador jogador3 = new Jogador("Sicrano", 7, 173, 8);
        Jogador jogador4 = new Jogador("Fulano de tal", 9, 152, 5);
        Jogador jogador5 = new Jogador("Beltrano de tal", 47, 123, 6);

        ranking.add(jogador1);
        ranking.add(jogador2);
        ranking.add(jogador3);
        ranking.add(jogador4);
        ranking.add(jogador5);

        // Organiza os jogadores pela pontuação
        ranking.sort((j1, j2) -> Integer.compare(j2.getPontuacao(), j1.getPontuacao()));

        // printa tudos os jogadores:
        for (int i = 0; i < ranking.size(); i++) {
            Jogador jogador = ranking.get(i);
            System.out.println("Ranking " + (i + 1) + ": " + jogador.getNome() + " - Pontuação: " + jogador.getPontuacao());
        }
    }
}
