package gestao;

public class Morador {
    String nome;
    String cpf;
    int numeroUnidade;

    public Morador(String nome, String cpf, int numeroUnidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.numeroUnidade = numeroUnidade;
    }

    public void exibirDados() {
        System.out.println("Morador: " + nome + " | CPF: " + cpf + " | Unidade: " + numeroUnidade);
    }

    @Override
    public String toString() {
        return String.format("Morador: %s | CPF: %s | Unidade: %d", nome, cpf, numeroUnidade);
    }
}
