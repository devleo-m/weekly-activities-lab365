public class Jogador {
    private String nome;
    private int idade;
    private int pontuacao;
    private int numeroTentativas;

    //CONSTRUTOR DO JOGADOR
    public Jogador(String nome, int idade, int pontuacao, int numeroTentativas) {
        this.nome = nome;
        this.idade = idade;
        this.pontuacao = pontuacao;
        this.numeroTentativas = numeroTentativas;
    }

    public Jogador(String nome) { //Mais um construtor para a class JOGO
        this.nome = nome;
        this.idade = 0;  // Idade padrão, você pode ajustar conforme necessário
        this.pontuacao = 0;
        this.numeroTentativas = 0;
    }

    //Metodos
    public void adicionaPontos(int pontos){
        this.pontuacao += pontos;
    }
    public void perdePontos(int pontos){
        this.pontuacao -= pontos;
        if (this.pontuacao < 0) {
            this.pontuacao = 0;
        }
    }
    public void adicionaTentativa(){
        this.numeroTentativas++;
    }

    //P/JOGO
    public void incrementarPontuacao() {
        this.pontuacao++;
    }

    //*****************************************************************************************************************//
    //[M1S05] EX 2 - Adicione encapsulamento ao Jogador
    //Metodos getts e settrs:
    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getNumeroTentativas() {
        return numeroTentativas;
    }

    public void setNumeroTentativas(int numeroTentativas) {
        this.numeroTentativas = numeroTentativas;
    }


}
