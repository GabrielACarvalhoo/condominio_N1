
package gestao;

public class Funcionario extends Pessoa implements Calculavel {

    protected double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        super(nome);
        this.salarioBase = salarioBase;
    }

    public double calcularSalario() {
        return this.salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    @Override
    public String toString() {
        return String.format(
                "Funcionário: %s | Salário Base: R$ %.2f",
                getNome(),
                calcularSalario()
        );
    }

    @Override
    public void exibirIdentificacao() {
        System.out.println("Funcionário: " + getNome());
    }

    @Override
    public double calcularValor() {
        return calcularSalario();
    }
}

