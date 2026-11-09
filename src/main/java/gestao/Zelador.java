package gestao;

public class Zelador extends Funcionario {
    public Zelador(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public double calcularSalario() {
        double salarioComum = super.calcularSalario();
        return salarioComum * 1.10;
    }

    @Override
    public String toString() {
        return String.format("Zelador: %s | Salário Final (+10%%): R$ %.2f", getNome(), calcularSalario());
    }
}