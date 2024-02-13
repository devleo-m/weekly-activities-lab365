import java.util.Scanner;

public class Jogo {
    private Jogador melhorJogador;
    private int numeroJogadas;

    public Jogo() {
        this.melhorJogador = null;
        this.numeroJogadas = 0;
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do Jogador 1: ");
        String nomeJogador1 = scanner.nextLine();
        Jogador jogador1 = new Jogador(nomeJogador1);

        System.out.print("Digite o nome do Jogador 2: ");
        String nomeJogador2 = scanner.nextLine();
        Jogador jogador2 = new Jogador(nomeJogador2);

        System.out.println("Vamos começar o jogo!");

        while (true) {
            System.out.println("\nRodada " + (numeroJogadas + 1));

            System.out.print(jogador1.getNome() + ", escolha: (1) Pedra, (2) Papel, (3) Tesoura: ");
            int escolhaJogador1 = scanner.nextInt();

            System.out.print(jogador2.getNome() + ", escolha: (1) Pedra, (2) Papel, (3) Tesoura: ");
            int escolhaJogador2 = scanner.nextInt();

            int resultado = resultadoRodada(escolhaJogador1, escolhaJogador2, jogador1, jogador2);

            if (resultado == 1) {
                jogador1.incrementarPontuacao();
                melhorJogador = jogador1;
            } else if (resultado == 2) {
                jogador2.incrementarPontuacao();
                melhorJogador = jogador2;
            }

            numeroJogadas++;

            System.out.println("Placar: " + jogador1.getNome() + " " + jogador1.getPontuacao() +
                    " - " + jogador2.getPontuacao() + " " + jogador2.getNome());

            System.out.print("Deseja jogar novamente? (S/N): ");
            String continuar = scanner.next().toUpperCase();

            if (!continuar.equals("S")) {
                break;
            }
        }

        scanner.close();

        System.out.println("\nFim do Jogo!");
        System.out.println("Melhor jogador: " + melhorJogador.getNome());
        System.out.println("Número total de jogadas: " + numeroJogadas);
    }

    private int resultadoRodada(int escolhaJogador1, int escolhaJogador2, Jogador jogador1, Jogador jogador2) {
        if (escolhaJogador1 == escolhaJogador2) {
            System.out.println("Empate!");
            return 0;
        } else if ((escolhaJogador1 == 1 && escolhaJogador2 == 3) ||
                (escolhaJogador1 == 2 && escolhaJogador2 == 1) ||
                (escolhaJogador1 == 3 && escolhaJogador2 == 2)) {
            System.out.println("Vitória de " + jogador1.getNome() + "!");
            return 1;
        } else {
            System.out.println("Vitória de " + jogador2.getNome() + "!");
            return 2;
        }
    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.jogar();
    }
}
