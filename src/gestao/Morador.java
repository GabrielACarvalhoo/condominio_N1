package gestao;

public class Morador extends Pessoa {
    private String nome;
    private String cpf;
    private int numeroUnidade;

    public Morador(String nome, String cpf, int numeroUnidade) {
        super(nome);
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

    @Override
    public void exibirIdentificacao() {
        System.out.println("Morador: " + nome);
}
}
