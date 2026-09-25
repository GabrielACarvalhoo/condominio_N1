package gestao;

public class Morador {
    private String nome;
    private String cpf;
    private int numeroUnidade;

    public Morador(String nome, String cpf, int numeroUnidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.numeroUnidade = numeroUnidade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getNumeroUnidade() {
        return numeroUnidade;
    }

    public void exibirDados() {
        System.out.println("Morador: " + nome + " | CPF: " + cpf + " | Unidade: " + numeroUnidade);
    }

    @Override
    public String toString() {
        return String.format("Morador: %s | CPF: %s | Unidade: %d", nome, cpf, numeroUnidade);
    }
}
