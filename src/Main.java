import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> cursos = new ArrayList<>();
    static ArrayList<String> professores = new ArrayList<>();
    static ArrayList<String> cursosConcluidos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean loop = true;
        System.out.println("Bem vindo(a) ao projeto M1S04 Lista de cursos e professores");
        do {
            System.out.println("Voce deseja (V)isualizar, (A)dicionar, (L)istar, (M)arcar, (R)emover ou (S)air?");
            String opicaum = teclado.next().toLowerCase();

            switch (opicaum){
                case "v":
                    ListarTudo();
                    System.out.println("Deseja visualizar um curso ou professor especifico? (S)im/(N)ao");
                    String op = teclado.next().toLowerCase();
                    if (op.equals("s")){
                        System.out.println("Deseja visualizar (C)ursos ou (p)rofessor?");
                        String opcao = teclado.next().toLowerCase();
                        if (opcao.equals("c")){
                            listarPedirIndiceCursos();
                        } else if (opcao.equals("p")) {
                            listarPedirIndiceProfessores();
                        } else {
                            System.out.println("Voce DEVERIA escolher entre (c)ursos ou (p)rofessores");
                            System.out.println("Infelizmente nem todo programa e perfeito, entao voce vai voltar desde o inicio!");
                        }
                    }
                    break;
                case "a":
                    boolean loop2 = false;
                    do {
                        System.out.println("Adicionar (C)ursos ou (P)rofessores?");
                        String opcao2 = teclado.next().toLowerCase();
                        if (opcao2.equals("c")){
                            adicionarCursos();
                        } else if (opcao2.equals("p")) {
                            adicionarProfessores();
                        } else {
                            System.out.println("Voce deve escolher entre (c)ursos ou (p)rofessores");
                            loop2 = true;
                        }
                    }while (loop2);
                    ListarTudo();
                    break;
                case "l":
                    System.out.println("l...");
                    break;
                case "m":
                    System.out.println("m...");
                    break;
                case "r":
                    System.out.println("Remover Curso ou Professor");
                    System.out.println("Deseja remover (C)ursos ou (P)rofessor");
                    String tipoRemocao = teclado.next().toLowerCase();

                    if (tipoRemocao.equals("c")) {
                        excluirItemCursos();
                        ListarCursos();
                    } else if (tipoRemocao.equals("p")) {
                        excluirItemProfessores();
                        ListatProfessores();
                    } else {
                        System.out.println("Opção inválida!! Digite 'C' ou 'P'");
                    }
                    break;
                case "s":
                    System.out.println("Sair do programa...");
                    return;
                default:
                    System.out.println("Opcao invalida, voce deve digitar 'A', 'L', 'R' ou 'S'");
                    System.out.println("...");
            }
        }while (loop);
    }
    public static void adicionarCursos(){
        System.out.print("Digite o índice do curso: ");
        Scanner teclado = new Scanner(System.in);
        String curso = teclado.next();
        cursos.add(curso);
    }
    public static void adicionarProfessores(){
        System.out.print("Digite o índice do professor: ");
        Scanner teclado = new Scanner(System.in);
        String professor = teclado.next();
        professores.add(professor);
    }

    public static void ListarCursos() {
        System.out.println("Cursos: ");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println(i + ": " + cursos.get(i));
        }
    }
    public static void ListatProfessores(){
        System.out.println("Professores");
        for (int i = 0; i < professores.size(); i++) {
            System.out.println(i+": "+professores.get(i));
        }
    }

    public static void ListarTudo(){
        ListarCursos();
        ListatProfessores();
    }

    public static void listarPedirIndiceCursos(){
        Scanner teclado = new Scanner(System.in);
        ListarCursos();
        System.out.println("Qual Desses indices voce quer visualizar o curso?");
        byte opcao = teclado.nextByte();
        System.out.println(cursos.get(opcao));
    }

    public static void listarPedirIndiceProfessores(){
        Scanner teclado = new Scanner(System.in);
        ListatProfessores();
        System.out.println("Qual Desses indices voce quer visualizar os Professores?");
        byte indice = teclado.nextByte();
        System.out.println(professores.get(indice));
    }
    private static void excluirItemCursos() {
        Scanner teclado = new Scanner(System.in);
        ListarCursos();
        System.out.println("Digite o índice do curso que deseja remover:");
        int indiceCurso = teclado.nextInt();

        if (indiceCurso >= 0 && indiceCurso < cursos.size()) {
            cursos.remove(indiceCurso);
            System.out.println("Curso removido com sucesso.");
        } else {
            System.out.println("indice invalido.");
        }
    }
    private static void excluirItemProfessores() {
        Scanner teclado = new Scanner(System.in);
        ListatProfessores();
        System.out.println("Digite o indice do professor que deseja remover:");
        int indiceProfessor = teclado.nextInt();

        if (indiceProfessor >= 0 && indiceProfessor < professores.size()) {
            professores.remove(indiceProfessor);
            System.out.println("Professor removido com sucesso.");
        } else {
            System.out.println("indice invalido.");
        }
    }
    private static void MarcarComoConcluido() {
        Scanner teclado = new Scanner(System.in);
        ListarCursos();
        System.out.println("Digite o índice do Curso Concluído:");
        int indiceCurso = teclado.nextInt();

        if (indiceCurso >= 0 && indiceCurso < cursos.size()) {
            String cursoConcluido = cursos.get(indiceCurso);

            // Verifica se o curso já foi concluído anteriormente
            if (!cursosConcluidos.contains(cursoConcluido)) {
                cursosConcluidos.add(cursoConcluido);
                System.out.println("Curso marcado como concluído com sucesso.");
            } else {
                System.out.println("Este curso já foi marcado como concluído anteriormente.");
            }
        } else {
            System.out.println("Índice inválido.");
        }
    }
}



