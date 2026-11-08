package gestao;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "morador")
public class Morador extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 11)
    private String cpf;

    @Column(name = "numero_unidade")
    private int numeroUnidade;

    public Morador() {
        super("");
    }

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
        System.out.println(
            "Morador: " + nome +
            " | CPF: " + cpf +
            " | Unidade: " + numeroUnidade
        );
    }

    @Override
    public void exibirIdentificacao() {
        System.out.println("Morador: " + nome);
    }

    @Override
    public String toString() {
        return String.format(
            "Morador: %s | CPF: %s | Unidade: %d",
            nome, cpf, numeroUnidade
        );
    }
}
