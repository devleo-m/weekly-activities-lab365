import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static ArrayList<Curso> cursos = new ArrayList<>();
    static ArrayList<Professor> professores = new ArrayList<>();
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
                    ListarConcluidos();
                    break;
                case "m":
                    MarcarComoConcluido();
                    break;
                case "r":
                    System.out.println("Deseja remover (C)ursos ou (P)rofessor?");
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
                    ListarTudo();
                    return;
                default:
                    System.out.println("Opcao invalida, voce deve digitar 'A', 'L', 'R' ou 'S'");
                    System.out.println("...");
            }
        }while (loop);
    }
    public static void adicionarCursos() {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o nome do curso: ");
        String nomeCurso = teclado.nextLine();
        System.out.print("Digite a descrição do curso: ");
        String descricaoCurso = teclado.nextLine();
        System.out.print("Digite o nome do professor: ");
        String nomeProfessor = teclado.nextLine();
        System.out.print("Digite a carga horária do curso: ");
        int cargaHoraria = teclado.nextInt();

        Curso curso = new Curso(nomeCurso, descricaoCurso, nomeProfessor, cargaHoraria);
        cursos.add(curso);
    }
    public static void adicionarProfessores() {
        Scanner teclado = new Scanner(System.in);
        Professor professor = new Professor();
        System.out.print("Digite o nome do professor: ");
        professor.nome = teclado.next();
        professores.add(professor);
    }
    public static void ListarCursos() {
        System.out.println("Cursos: ");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println(i + ": " + cursos.get(i).nome);
        }
    }
    public static void ListatProfessores() {
        System.out.println("Professores: ");
        for (int i = 0; i < professores.size(); i++) {
            System.out.println(i + ": " + professores.get(i).nome);
        }
    }
    public static void ListarTudo(){
        ListarCursos();
        ListatProfessores();
    }
    public static void listarPedirIndiceCursos() {
        Scanner teclado = new Scanner(System.in);
        ListarCursos();
        System.out.println("Qual desses índices você quer visualizar o curso?");
        int indice = teclado.nextInt();
        cursos.get(indice).DescricaoCurso();
    }
    public static void listarPedirIndiceProfessores() {
        Scanner teclado = new Scanner(System.in);
        ListatProfessores();
        System.out.println("Qual desses índices você quer visualizar o professor?");
        int indice = teclado.nextInt();
        professores.get(indice).DescricaoProfessor();
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
            Curso cursoConcluido = cursos.get(indiceCurso);

            // Verifica se o curso já foi concluído anteriormente
            if (!cursosConcluidos.contains(cursoConcluido.nome)) {
                cursosConcluidos.add(cursoConcluido.nome);
                cursos.remove(indiceCurso); // Remove o curso da lista original
                System.out.println("Curso " + cursoConcluido.nome + " marcado como concluído.");
            } else {
                System.out.println("Este curso já está marcado como concluído.");
            }
        } else {
            System.out.println("Índice inválido.");
        }
    }
    public static void ListarConcluidos() {
        if (!cursosConcluidos.isEmpty()) {
            System.out.println("Cursos Concluídos:");
            for (int i = 0; i < cursosConcluidos.size(); i++) {
                System.out.println(i + ": " + cursosConcluidos.get(i));
            }
        } else {
            System.out.println("Nenhum curso adicionado como concluído no momento!");
        }
    }
}
