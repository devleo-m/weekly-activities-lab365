public class Curso {
    String nome;
    String descricao;
    String professor;
    int cargaHoraria = 0;

    // Construtor com parâmetros
    public Curso(String nome, String descricao, String professor, int cargaHoraria) {
        this.nome = nome;
        this.descricao = descricao;
        this.professor = professor;
        this.cargaHoraria = cargaHoraria;
    }

    // Construtor de cópia
    public Curso(Curso outroCurso) {
        this.nome = outroCurso.nome;
        this.descricao = outroCurso.descricao;
        this.professor = outroCurso.professor;
        this.cargaHoraria = outroCurso.cargaHoraria;
    }

    public void Progresso() {
        System.out.println("Os alunos vão estudar: " + nome);
    }

    public void DescricaoCurso() {
        System.out.println("Curso de " + nome + ", com foco em: " + descricao);
        System.out.println("Professor do curso: " + professor);
        System.out.println("Carga Horária total: " + cargaHoraria + " horas");
    }
}
