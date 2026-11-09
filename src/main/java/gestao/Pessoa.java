
package gestao;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Column;

@MappedSuperclass
public abstract class Pessoa {

    @Column(nullable = false, length = 120)
    protected String nome;

    // Construtor vazio para o JPA
    protected Pessoa() {
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract void exibirIdentificacao();
}
