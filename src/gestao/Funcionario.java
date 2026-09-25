package gestao;

public class Funcionario {
    private String nome;
    protected double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public double calcularSalario() {
        return this.salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
    @Override
    public String toString() {
        return String.format("Funcionário: %s | Salário Base: R$ %.2f", nome, calcularSalario());
    }
}
